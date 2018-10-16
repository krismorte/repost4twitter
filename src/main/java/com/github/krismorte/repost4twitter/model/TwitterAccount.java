/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.krismorte.repost4twitter.model;

import com.towel.el.annotation.Resolvable;
import javax.persistence.Entity;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author krisnamourtscf
 */
@Entity
@NoArgsConstructor
public class TwitterAccount extends EntityModel implements Account {

    @Transient
    private Twitter twitter;
    @Transient
    private User user;
    @Resolvable(colName = "Username")
    @Getter
    @Setter
    private String userName;
    @Getter
    @Setter
    private String consumerKey;
    @Getter
    @Setter
    private String consumerSecret;
    @Getter
    @Setter
    private String accessToken;
    @Getter
    @Setter
    private String accessTokenSecret;

    public TwitterAccount(String consumerKey, String consumerSecret, String accessToken,
            String accessTokenSecret) throws Exception {
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
        this.accessToken = accessToken;
        this.accessTokenSecret = accessTokenSecret;
        connect();
        this.userName = user.getScreenName();
    }

    @Override
    public String getUsername() {
        if (user != null) {
            return user.getScreenName();
        } else {
            return userName;
        }
    }

    @Override
    public String getUrlProfilePic() {
        return user.get400x400ProfileImageURL();
    }

    @Override
    public void connect() throws Exception {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setOAuthConsumerKey(consumerKey);
        cb.setOAuthConsumerSecret(consumerSecret);
        cb.setOAuthAccessToken(accessToken);
        cb.setOAuthAccessTokenSecret(accessTokenSecret);
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
        user = twitter.showUser(twitter.getId());
    }

    @Override
    public boolean isConnect() {
        if (twitter != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public AccountTarget getUser(String userName) throws Exception {
        User localUser = twitter.showUser(userName);
        return AccountTarget.getTwitterTarget(this, localUser);
    }

    @Override
    public TimeLine getUserTimeline(Long userId) throws Exception {
        TimeLine timeLine = new TimeLine();
        timeLine.setTweets(twitter.getUserTimeline(userId));
        return timeLine;
    }

    @Override
    public void repost(Post post) throws Exception {
        twitter.retweetStatus(post.getTweet().getId());
    }

}
