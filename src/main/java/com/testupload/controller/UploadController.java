package com.testupload.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("upload")
public class UploadController {

    @GetMapping("test")
    public String hello() {
        return "yes";
    }

    @PostMapping("img")
    @CrossOrigin
    public String uploadImg(@RequestParam("file") MultipartFile file) {
        String contextPath = "D:/workspace/IdeaProjects/uploadImgs/";   // 临时写死地址，实际项目需要自定义
        if (!file.isEmpty()) {
            try {
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File((contextPath + file.getOriginalFilename()))));
                System.out.println(contextPath + file.getOriginalFilename());
                out.write(file.getBytes());
                out.flush();
                out.close();
                System.out.println("yes");
                return "yes";
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("no");
                return "no";
            }
        } else {
            System.out.println("null");
            return "null";
        }
    }
}
