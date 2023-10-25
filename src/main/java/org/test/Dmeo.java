package org.test;


import org.junit.Test;
import redis.clients.jedis.Jedis;

public class Dmeo {
    @Test
    public void connection(){
        //测试连接
        //1.构建redis对象
        Jedis jedis = new Jedis("192.168.193.129",6379);
        //2、测试连接
        String ping = jedis.ping();
        System.out.println("ping = " + ping);

    }
    @Test
    public void set(){
        //1、连接redis
        Jedis jedis = new Jedis("192.168.193.129",6379);
        //2、操作Redis，jedis和Redis命令一样
        String value = jedis.set("name","李白");
        System.out.println("value"+value);
        jedis.close();
    }
    @Test
    public void get(){
        //1、连接redis
        Jedis jedis = new Jedis("192.168.193.129",6379);
        //2、操作Redis，jedis和Redis命令一样
        String value = jedis.get("name");
        System.out.println("value"+value);
//        /3、释放资源，断开连接
        jedis.close();
    }
}
