/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.krismorte.repost4twitter.model;

import com.towel.el.annotation.Resolvable;
import javax.persistence.Entity;
import javax.persistence.Transient;
import lombok.Data;
import twitter4j.User;

/**
 *
 * @author krismorte
 */
@Entity
@Data
public class AccountTarget extends EntityModel{

    @Transient
    private User twitterUser;
    private String account;
    @Resolvable(colName = "Id")
    private Long targetId;
    @Resolvable(colName = "Username")
    private String userName;

    public static AccountTarget getTwitterTarget(TwitterAccount account, User twitterUser) {
        AccountTarget accountTarget = new AccountTarget();
        accountTarget.setUserName(twitterUser.getScreenName());
        accountTarget.setAccount(account.getUsername());
        accountTarget.setTargetId(twitterUser.getId());
        accountTarget.setTwitterUser(twitterUser);
        return accountTarget;
    }

}
