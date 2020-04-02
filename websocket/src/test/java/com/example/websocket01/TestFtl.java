package com.example.websocket01;

import com.example.websocket01.exportWord.utils.ExportMyWord;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 王尔玉 on 2019/9/30 17:02
 */
public class TestFtl {

    public static void main(String[] args) {
        ExportMyWord emw = new ExportMyWord();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("title","标题1");
        dataMap.put("name","燕双鹰");
        File file = new File("E:\\项目\\项目案例\\websocket01\\src\\main\\resources\\word\\test.ftl");
        String absolutePath = file.getAbsolutePath();
        String name = file.getName();
        boolean file1 = file.isFile();
       /* dataMap.put("name", "黄xx");
        dataMap.put("age", 26);
        dataMap.put("blog", "sun_flower火柴客");
        dataMap.put("email", "sun_flower@xxxx.com");
        dataMap.put("gender", "男");
        dataMap.put("imgheader", emw.getImageStr("D:\\picture\\23.jpg"));
        dataMap.put("telephone", "123456789101");
        dataMap.put("address", "深圳");
        dataMap.put("naturework", "全职");
        dataMap.put("industry", "IT");
        dataMap.put("aplication", "Java开发");
        dataMap.put("time", "2013年-2017年");
        dataMap.put("schoolname", "南昌大学");
        dataMap.put("education", "本科");
        dataMap.put("projectname", "电子证照xxxx");
        dataMap.put("projecttime", "2017年3月");
        dataMap.put("projectcontent", "我们除了有视、听、味、嗅、触这些外感系统之外，人类还有一个非常重要的内感系统，就是我们情绪和情感的世界。"
                + "这种感受是那样地细腻、微妙、强烈、深沉；看不见、摸不着，说不清、道不明。...");*/
        emw.createWord(dataMap, absolutePath, "E:/简历.doc");
    }
}
