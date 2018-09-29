package com.testupload.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@RestController
@RequestMapping("upload")
public class UploadController {

    @GetMapping("test")
    public String hello() {
        return "yes";
    }

    @PostMapping("img")
    @CrossOrigin
    public String uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
//        String contextPath = request.getSession().getServletContext().getRealPath("/");
        String contextPath = "D:/workspace/IdeaProjects/uploadImgs/";
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
                return "上传失败," + e.getMessage();
            }
        } else {
            System.out.println("null");
            return "上传失败，因为文件是空的.";
        }
    }
}
