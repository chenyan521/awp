package com.example.websocket01.exportWord.testword;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by 王尔玉 on 2019/10/7 1:23
 */
public class WordUtil {
    /**
     * 生成word文件
     *
     * @param dataMap      word中需要展示的动态数据，用map集合来保存
     * @param templateName word模板名称，例如：test.ftl
     * @param filePath     文件生成的目标路径，例如：D:/wordFile/
     * @param fileName     生成的文件名称，例如：test.doc
     */
    @SuppressWarnings("unchecked")
    public static void createWord(Map dataMap, String templateName, String filePath, String fileName) {
        try {
            //创建配置实例
            Configuration configuration = new Configuration();


            //设置编码
            configuration.setDefaultEncoding("UTF-8");

            //ftl模板文件
            configuration.setClassForTemplateLoading(WordUtil.class, "/word");

            //获取模板
            File file = new File(templateName);
            boolean file1 = file.isFile();
            Template template = configuration.getTemplate(templateName);

            //输出文件
            File outFile = new File(filePath + File.separator + fileName);

            //如果输出目标文件夹不存在，则创建
            if (!outFile.getParentFile().exists()) {
                outFile.getParentFile().mkdirs();
            }

            //将模板和数据模型合并生成文件
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));


            //生成文件
            template.process(dataMap, out);

            //关闭流
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] downWord(Map dataMap, String templateName, String filePath, String fileName) {
        byte[] result = null;
        try {
            //创建配置实例
            Configuration configuration = new Configuration();
            //设置编码
            configuration.setDefaultEncoding("UTF-8");

            //ftl模板文件
            configuration.setClassForTemplateLoading(WordUtil.class, "/word");
            //获取模板
            Template template = configuration.getTemplate(templateName);

            //输出文件
            File outFile = new File(filePath + File.separator + fileName);

            //如果输出目标文件夹不存在，则创建
            if (!outFile.getParentFile().exists()) {
                outFile.getParentFile().mkdirs();
            }
            //将模板和数据模型合并生成文件
            Writer out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(outFile), "UTF-8"));
            //生成文件
           template.process(dataMap,out);

            result = FileUtils.readFileToByteArray(new File(outFile.toString()));
            //关闭流
            out.flush();
            out.close();
            outFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static String downWord1(Map dataMap, String templateName, String filePath, String fileName) {
        String result = null;
        try {
            //创建配置实例
            Configuration configuration = new Configuration();
            //设置编码
            configuration.setDefaultEncoding("UTF-8");

            //ftl模板文件
            configuration.setClassForTemplateLoading(WordUtil.class, "/word");
            //获取模板
            Template template = configuration.getTemplate(templateName);

            //输出文件
            File outFile = new File(filePath + File.separator + fileName);

            //如果输出目标文件夹不存在，则创建
            if (!outFile.getParentFile().exists()) {
                outFile.getParentFile().mkdirs();
            }
            //将模板和数据模型合并生成文件
            Writer out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(outFile), "UTF-8"));
            //生成文件
            template.process(dataMap,out);
            result = outFile.toString();
            //result = FileUtils.readFileToByteArray(new File(outFile.toString()));
            //关闭流
            out.flush();
            out.close();
            //outFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
