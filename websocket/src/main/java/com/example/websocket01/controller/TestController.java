package com.example.websocket01.controller;

import com.example.websocket01.entity.ClassRoom;
import com.example.websocket01.entity.RequestParam;
import com.example.websocket01.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 王尔玉 on 2019/11/20 18:02
 */
@Controller
public class TestController {

    @RequestMapping(value = "/test/data",method = RequestMethod.POST)
    @ResponseBody
    public String getData(@RequestBody RequestParam requestParam){
        System.out.println(requestParam.getClassRoom());
        System.out.println(requestParam.getStudent());
        return "请求成功！";
    }
    @RequestMapping(value = "/data1",method = RequestMethod.GET)
    @ResponseBody
    public String getData1(){
        System.out.println("请求成功");
        return "请求成功！";
    }
}
