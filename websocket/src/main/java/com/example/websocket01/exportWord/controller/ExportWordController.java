package com.example.websocket01.exportWord.controller;

import com.example.websocket01.exportWord.testword.WordAction;
import com.example.websocket01.exportWord.testword.WordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by 王尔玉 on 2019/9/30 15:51
 */
@Controller
public class ExportWordController {

    @Autowired
    private WordAction wordAction;

    @RequestMapping("/testdown")
    public InputStream exportDoc(){
        wordAction.createWord();
        wordAction.dowloadWord();
        InputStream wordFile = wordAction.getWordFile();
        return wordFile;
    }
    @RequestMapping(value = "/down",method =RequestMethod.GET,produces = "application/msword")
    @ResponseBody
    public byte[] downdoc( HttpServletRequest request,HttpServletResponse response){

        /** 用于组装word页面需要的数据 */
        Map<String, Object> dataMap = new HashMap<String, Object>();

        /** 组装数据 */
        dataMap.put("userName", "seawater");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        //dataMap.put("date", sdf.format(new Date()));

        // dataMap.put("content", "freeMark生成Word文档段落内容");

        //dataMap.put("image",imagePath());
        dataMap.put("name","燕双鹰");
        dataMap.put("age","41");

        /** 文件名称，唯一字符串 */
        Random r = new Random();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        StringBuffer sb = new StringBuffer();
        sb.append(sdf1.format(new Date()));
        sb.append("_");
        sb.append(r.nextInt(100));

        //文件路径
        String filePath = "F:/test/";

        //文件唯一名称
        String  fileOnlyName = "用freemarker生成Word文档_" + sb + ".doc";
        

        /** 生成word */
        byte[] bytes = WordUtil.downWord(dataMap, "test.ftl", filePath, fileOnlyName);
        response.setHeader("Content-disposition", "attachment; filename=" + fileOnlyName);
        response.setContentLength(bytes.length);
        response.setContentType("application/msword");
        //response.setContentType("application/json");
        return bytes;
    }

    @RequestMapping(value = "/down1",method =RequestMethod.GET,produces = "application/msword")
    @ResponseBody
    public String downdoc1( HttpServletRequest request,HttpServletResponse response){

        /** 用于组装word页面需要的数据 */
        Map<String, Object> dataMap = new HashMap<String, Object>();

        /** 组装数据 */
        dataMap.put("userName", "seawater");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        //dataMap.put("date", sdf.format(new Date()));

        // dataMap.put("content", "freeMark生成Word文档段落内容");

        //dataMap.put("image",imagePath());
        dataMap.put("name","燕双鹰");
        dataMap.put("age","41");

        /** 文件名称，唯一字符串 */
        Random r = new Random();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        StringBuffer sb = new StringBuffer();
        sb.append(sdf1.format(new Date()));
        sb.append("_");
        sb.append(r.nextInt(100));

        //文件路径
        String filePath = "F:/test/";

        //文件唯一名称
        String  fileOnlyName = "用freemarker生成Word文档_" + sb + ".doc";
        /** 生成word */
        String path = WordUtil.downWord1(dataMap, "test.ftl", filePath, fileOnlyName);
        File file = new File(path);
        if (!file.exists()){
            System.out.println("文件已经被删除");
        }
        try {
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            response.reset();
            response.addHeader("Content-disposition", "attachment; filename=" + fileOnlyName);
            response.addHeader("Content-Length",""+file.length());
            OutputStream out = new BufferedOutputStream(response.getOutputStream());
            out.write(buffer);
            out.flush();
            out.close();
            file.delete();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //response.setContentType("application/json");
        return "下载成功";
    }
}
