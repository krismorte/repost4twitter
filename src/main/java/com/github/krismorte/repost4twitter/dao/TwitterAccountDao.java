/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.krismorte.repost4twitter.dao;

import com.github.krismorte.repost4twitter.model.TwitterAccount;
import java.util.List;

/**
 *
 * @author krisnamourtscf
 */
public class TwitterAccountDao extends GenericDao<TwitterAccount> {

    public TwitterAccountDao() {
        super(TwitterAccount.class);
    }

    public void doSave(TwitterAccount account) {
        beginTransaction();
        save(account);
        commitAndCloseTransaction();
    }

    public List<TwitterAccount> list() {
        beginTransaction();
        List<TwitterAccount> accounts = findAll();
        commitAndCloseTransaction();
        return accounts;
    }
    
    public TwitterAccount findByUserName(String userName) {
        beginTransaction();
        TwitterAccount accounts = getEntityManager()
                .createQuery("select a from TwitterAccount a where a.userName = :userName",TwitterAccount.class)
                .setParameter("userName", userName)
                .getSingleResult();
        commitAndCloseTransaction();
        return accounts;
    }

}
