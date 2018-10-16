/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.krismorte.repost4twitter.view.tables;

import com.github.krismorte.repost4twitter.model.TwitterAccount;

/**
 *
 * @author krisnamourtscf
 */
public class TwitterAccountTables extends TablesHelper<TwitterAccount> {

    public TwitterAccountTables() {
        super(TwitterAccount.class, "userName");
    }
}
