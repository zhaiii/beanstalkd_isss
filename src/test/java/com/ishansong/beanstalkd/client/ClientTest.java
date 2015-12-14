package com.ishansong.beanstalkd.client;

import com.surftools.BeanstalkClient.Job;
import com.surftools.BeanstalkClientImpl.ClientImpl;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by zhai on 15/11/22.
 */
public class ClientTest {
    ArrayList<String> server;
    @Before
    public void hosts(){
        server=new ArrayList<String>();
        server.add(0,"127.0.0.1:11300");
    }

    @Test
    public void test(){

        BeanstalkdClient client=new BeanstalkdClient(server,50);
        client.use("zhai");
        BeanstalkdClient.JobBuilder job=new BeanstalkdClient.JobBuilder("haha".getBytes());
        job.delaySeconds(2);

        long jobId = client.put(job);
        System.out.println(jobId);

        Job j1 = client.reserve();
//        client.release(j1);
        client.release(j1,1024,10);//release到delay状态
        client.bury(j1,1024);
        String s=new String(j1.getData());

        System.out.println(s);

        int zhai = client.watch("zhai");
        System.out.println(zhai);
    }
    @Test
    public void test2(){
        BeanstalkdClient client=new BeanstalkdClient(server, ClientImpl.class);
        Set<String> tubes = client.listTubes();
        System.out.println(tubes);
    }
    @Test
    public void test3(){
//        BigDecimal amountCommission = new BigDecimal(2300).multiply(new BigDecimal(0.2)).multiply(new BigDecimal(-1)).setScale(2, RoundingMode.DOWN);
//        System.out.println(amountCommission);

        String s="\"\"";
        System.out.println(s.length());
        String ss = s.substring(0, s.length());
        System.out.println(ss.length());
    }
}
