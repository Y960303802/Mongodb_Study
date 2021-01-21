package com.xizi.mongoClient;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.UpdateOptions;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class TestMongClient {

    private  MongoClient mongoClient;

    @Before
    public void before(){
        mongoClient= new MongoClient("192.168.153.124", 27017);

    }

    //1. 关闭linux防火墙
    //2. 开启mongo多客户端连接 ./mongo --port=27017 --dbpath=/root/data --bind_ip 0.0.0.0
     @Test
     public void testDatabseNames(){
         MongoIterable<String> strings = mongoClient.listDatabaseNames();
         for (String dataBaseName : strings) {
             System.out.println(dataBaseName);
         }
     }


    //获取指定库中集合
    @Test
    public void testDataBase(){
        MongoDatabase ems = mongoClient.getDatabase("ems");
        MongoCollection<Document> mongoCollection = ems.getCollection("users");
        FindIterable<Document> documents = mongoCollection.find();
        for (Document document : documents) {
            System.out.println(document.get("_id"));
            System.out.println(document.get("name"));
            System.out.println(document.get("age"));
            System.out.println(document.get("bir"));
            System.out.println("=========================");
        }
    }

    //修改集合中数据
    @Test
    public void testUpdate(){
        MongoCollection<Document> t_user = mongoClient.getDatabase("ems").getCollection("t_user");
        //更新条件
        Document document = new Document();
        document.put("age",19);
        //更新对象
        Document document1 = new Document();
        document1.put("name", "小黑");
        UpdateOptions updateOptions = new UpdateOptions();
        updateOptions.upsert(true);
        t_user.replaceOne(document, document1,updateOptions);
    }

    //删除集合中数据
    @Test
    public void testDelete(){
        MongoCollection<Document> t_user = mongoClient.getDatabase("ems").getCollection("t_user");
        //删除条件
        Document document = new Document();
        document.put("name","小黑");
        t_user.deleteMany(document);
    }

    //查询记录
    @Test
    public void testFind(){
        MongoCollection<Document> t_user = mongoClient.getDatabase("ems").getCollection("t_user");
        //查询条件
        Document document = new Document();
        document.put("name","戏子");

        //设置显示字段
        Document document2 = new Document();
        document2.put("name","1");
        FindIterable<Document> documents = t_user.find(document);
        for (Document document1 : documents) {
            System.out.println(document1.get("id"));
            System.out.println(document1.get("name"));
            System.out.println(document1.get("age"));
            System.out.println("=========================");
        }
    }
}
