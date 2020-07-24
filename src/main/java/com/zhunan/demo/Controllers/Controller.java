package com.zhunan.demo.Controllers;

import com.zhunan.demo.Models.jsonData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Api(description = "测试接口文档")
@RestController
//@org.springframework.stereotype.Controller
public class Controller {
    public static void main(String[] args) {

    }

    @ApiOperation(value="index页面",notes = "")
    @RequestMapping("/index")
    public ModelAndView hello(){
        System.out.println("测试");
        return new ModelAndView("/index");
    }

    private static final String filePath="D:/IDEA/IDEAproject/SpringbootDemo/src/main/resources/static/images/";

    @RequestMapping(value = "/upload")
    public jsonData upload(@RequestParam("file") MultipartFile file){
        //获取文件名
        String fileName=file.getOriginalFilename();
        System.out.println("上传的文件名："+fileName);

        //获取文件后缀名
        String suffixName=fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的文件后缀名："+suffixName);

        //文件上传后的文件名
        fileName= UUID.randomUUID()+suffixName;
        System.out.println("转换后的文件名称："+fileName);
        File newFile=new File(filePath+fileName);

        try {
            file.transferTo(newFile);
            return new jsonData(0,"上传成功",fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new jsonData(-1,"上传失败",null);
    }
}
