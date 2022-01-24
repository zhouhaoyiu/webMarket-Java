package com.zhy.market.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("goodsClassfication")
public class GoodsclassificationController {
    @GetMapping
    public Object addClassification(HttpServletRequest request){
        String classificationName = request.getParameter("classificationName");
        Integer parentId = Integer.valueOf(request.getParameter("parentId"));

        return null;
    }
}
