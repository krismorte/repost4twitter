/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.krismorte.repost4twitter.model;

import lombok.Data;
import twitter4j.ResponseList;
import twitter4j.Status;

/**
 *
 * @author krismorte
 */
@Data
public class TimeLine {
    
    private ResponseList<Status> tweets;
    
}
