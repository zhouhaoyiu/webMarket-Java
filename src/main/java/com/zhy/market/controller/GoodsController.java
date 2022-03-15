package com.zhy.market.controller;

import com.zhy.market.domain.Goods;
import com.zhy.market.mapper.GoodsMapper;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@RequestMapping("goods")
@RestController
public class GoodsController {

    @Resource
    private GoodsMapper goodsMapper;

    @PostMapping("upload/image")
    public Object uploadImage(@RequestParam("picture") MultipartFile picture, HttpServletRequest request) {
        // return null;
        String path = "E://market//goods//images";
        File filePath = new File(path);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }

        File file = new File(path, String.valueOf(UUID.randomUUID()) + ".jpg");
        String fileName = file.getName();
        JSONObject json = new JSONObject();
        try {
            picture.transferTo(file);
            json.put("code", 0);
            json.put("msg", "上传成功");
            json.put("data", fileName);
            System.out.println(path + "/" + fileName);

        } catch (Exception e) {
            e.printStackTrace();
            json.put("code", 1);
            json.put("msg", "上传失败");
        }
        return json;
    }

    @PostMapping("addGoods")
    public Object addGoods(@RequestBody Goods good) {
        Integer result = goodsMapper.addGood(good.goodName, good.goodClassification, good.goodPrice, good.goodCount, good.goodImages, good.goodDescribeImages);
        JSONObject json = new JSONObject();
        if (result > 0) {
            json.put("code", 0);
            json.put("msg", "添加成功");
        } else {
            json.put("code", 1);
            json.put("msg", "添加失败");
        }
        return json;
    }

    @GetMapping("getAllGoods")
    public Object getAllGoods() {
        List<Goods> list = goodsMapper.getAllGoods();
        JSONObject json = new JSONObject();
        json.put("data", list);
        return json;
    }
}
