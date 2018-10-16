/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.krismorte.repost4twitter.view.tables;

import com.github.krismorte.repost4twitter.model.AccountTarget;

/**
 *
 * @author krisnamourtscf
 */
public class AccountTargetTables extends TablesHelper<AccountTarget> {

    public AccountTargetTables() {
        super(AccountTarget.class, "id,userName");
    }
}
