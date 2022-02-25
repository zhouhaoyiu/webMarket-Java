package com.zhy.market.controller;

import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RequestMapping("goods")
@RestController
public class GoodsController {

    @PostMapping("upload/image")
    public Object uploadImage(@RequestParam("picture") MultipartFile picture, HttpServletRequest request) {
        // return null;
        String path = "E://market//goods//images";
        File filePath = new File(path);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        String fileName = picture.getOriginalFilename();
        File file = new File(path, fileName);
        JSONObject json = new JSONObject();
        try {
            picture.transferTo(file);
            json.put("code", 0);
            json.put("msg", "上传成功");
            json.put("data", path + "/" + fileName);
            System.out.println(path + "/" + fileName);

        } catch (Exception e) {
            e.printStackTrace();
            json.put("code", 1);
            json.put("msg", "上传失败");
        }
        return json;
    }
}
