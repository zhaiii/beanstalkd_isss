/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ishansong.beanstalkd.client;

/**
 *
 */
public interface DistributeStrategy {
    public void reset();
    public int shard();
    public boolean tryNextServer();
}
