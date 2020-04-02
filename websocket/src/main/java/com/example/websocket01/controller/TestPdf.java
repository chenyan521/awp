package com.example.websocket01.controller;

import ch.qos.logback.core.util.FileUtil;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 王尔玉 on 2019/9/29 16:55
 */
@Controller
public class TestPdf {

    @RequestMapping("/pdf")
    @ResponseBody
    public String test(){
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream("E:\\Helloworld.pdf"));
            document.open();
            document.add(new Paragraph("HelloWorld!"));
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "创建成功";
    }

    @RequestMapping("/word")
    @ResponseBody
    public String createDoc(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> params = new HashMap<>();
        params.put("title","这是标题");
        params.put("name","李四");
        //这里是我说的一行代码
        WordUtils.exportWord("word/test.ftl","F://test","aaa.docx",params,request,response);
        return "生成word";
    }
}
