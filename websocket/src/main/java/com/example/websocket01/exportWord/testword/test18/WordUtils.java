package com.example.websocket01.exportWord.testword.test18;

import com.example.websocket01.exportWord.testword.WordUtil;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by 王尔玉 on 2019/10/8 13:57
 */
public class WordUtils {

    private static String filePath; //文件路径
    private static String fileName; //文件名称
    private static String fileOnlyName; //文件唯一名称
    //图片所存放路径
    private static String imagePath = "";
    /**
     * 需要手动替换一下图片的base64编码
     * @return
     */
    public String imagePath(){
        //1、校验是否为空
        if(imagePath==null || imagePath.trim().length()<=0){
            return "";
        }

        //2、校验文件是否为目录或者是否存在
        File picFile = new File(imagePath);
        if(picFile.isDirectory() || (!picFile.exists())) {
            return "";
        };

        //3、校验是否为图片
        try {
            BufferedImage image = ImageIO.read(picFile);
            if (image == null) {
                return "";
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }

        //4、转换成base64编码
        String imageStr = "";
        try {
            byte[] data = null;
            InputStream in = new FileInputStream(imagePath);
            data = new byte[in.available()];
            in.read(data);
            BASE64Encoder encoder = new BASE64Encoder();
            imageStr = encoder.encode(data);
        } catch (Exception e) {
            imageStr="";
            e.printStackTrace();
        }
        return imageStr;
    }


    public static String  createWord() {



        /** 用于组装word页面需要的数据 */
        Map<String, Object> dataMap = new HashMap<String, Object>();

        /** 组装数据 */
        dataMap.put("userName", "seawater");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        //dataMap.put("date", sdf.format(new Date()));

        // dataMap.put("content", "freeMark生成Word文档段落内容");

        //dataMap.put("image",imagePath());
        dataMap.put("title","气象");
        dataMap.put("name","王尔玉");

    /*    List<Map<String, Object>> listInfo = new ArrayList<Map<String, Object>>();
        for (int i = 1; i <= 10; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("title", "标题" + i);
            map.put("content", "内容" + i);
            map.put("author", "作者" + i);
            listInfo.add(map);
        }
        dataMap.put("listInfo", listInfo);*/

        /** 文件名称，唯一字符串 */
        Random r = new Random();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        StringBuffer sb = new StringBuffer();
        sb.append(sdf1.format(new Date()));
        sb.append("_");
        sb.append(r.nextInt(100));

        //文件路径
        filePath = "F:/test/";

        //文件唯一名称
        fileOnlyName = "用freemarker生成Word文档_" + sb + ".doc";

        //文件名称
        fileName = "用freemarker生成Word文档.doc";

        /** 生成word */
        WordUtil.createWord(dataMap, "test.ftl", filePath, fileOnlyName);
        //dowloadWord();
        //getWordFile();

        return "createWordSuccess";
    }


    /**
     * 下载生成的word文档
     */
    public String dowloadWord() {
        /** 先判断文件是否已生成  */
        try {
            //解决中文乱码
            filePath = URLDecoder.decode(filePath, "UTF-8");
            fileOnlyName = URLDecoder.decode(fileOnlyName, "UTF-8");
            fileName = URLDecoder.decode(fileName, "UTF-8");

            //如果文件不存在，则会跳入异常，然后可以进行异常处理
            new FileInputStream(filePath + File.separator + fileOnlyName);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "dowloadWord";
    }

    /**
     * 返回最终生成的word文档 文件流
     * 下载生成的word文档
     */
    public InputStream getWordFile() {
        try {
            //解决中文乱码
            fileName = URLDecoder.decode(fileName, "UTF-8");

            /** 返回最终生成的word文件流  */
            return new FileInputStream(filePath + File.separator + fileOnlyName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public String getFilePath() {
        return filePath;
    }


    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


    public String getFileName() {
        return fileName;
    }


    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public String getFileOnlyName() {
        return fileOnlyName;
    }


    public void setFileOnlyName(String fileOnlyName) {
        this.fileOnlyName = fileOnlyName;
    }

}
