/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.krismorte.repost4twitter;

import com.alee.laf.WebLookAndFeel;
import com.github.krismorte.repost4twitter.util.DirTree;
import com.github.krismorte.repost4twitter.view.MainScreen;

/**
 *
 * @author krisnamourtscf
 */
public class Main {

    public static void main(String[] args) {
        WebLookAndFeel.install();

        DirTree.verify();

        MainScreen mainScreen = new MainScreen();
        mainScreen.setLocationRelativeTo(null);
        mainScreen.setVisible(true);
    }
  
}
