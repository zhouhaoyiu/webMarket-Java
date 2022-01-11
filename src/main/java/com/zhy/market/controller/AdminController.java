package com.zhy.market.controller;

import com.zhy.market.domain.Admin;
import com.zhy.market.mapper.AdminMapper;
import net.sf.json.JSONObject;

import com.zhy.market.mapper.RsaKeyMapper;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.crypto.Cipher;
import javax.servlet.http.HttpServletRequest;

import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.UUID;

@RequestMapping("admin")
@RestController
public class AdminController {
    @Autowired
    private AdminMapper adminMapper;

    @Resource
    private RsaKeyMapper rsaKeyMapper;

    @PostMapping("adminLogin")
    public Object adminLogin(HttpServletRequest request, HttpServletRequest response, @RequestBody Admin userLoginInfo)
            throws Exception {
        String userName = userLoginInfo.userName;
        String passWord = userLoginInfo.passWord;

        String privateKey = rsaKeyMapper.getPrivateKey();
        // 64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(passWord.getBytes("UTF-8"));
        // base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);

        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA")
                .generatePrivate(new PKCS8EncodedKeySpec(decoded));

        // RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        System.out.println(userName);
        System.out.println(outStr);

        JSONObject json = new JSONObject();
        return json;
    }

    @PostMapping("adminRegis")
    public Object adminRegis(HttpServletRequest request, HttpServletRequest response, @RequestBody Admin userRegisInfo)
            throws Exception {
        String pin = userRegisInfo.pin;
        String userName = userRegisInfo.userName;

        if (pin != "574601**") {
            JSONObject json = new JSONObject();
            json.put("code", "1");
            json.put("msg", "pin码错误");
            return json;
        } else if (adminMapper.checkUserName(userName) == 1) {
            JSONObject json = new JSONObject();
            json.put("code", "1");
            json.put("msg", "用户名已存在");
            return json;
        }

        else {
            String passWord = userRegisInfo.passWord;
            String emailAddress = userRegisInfo.emailAddress;
            String phoneNumber = userRegisInfo.phoneNumber;
            UUID uuid = UUID.randomUUID();
            int result = adminMapper.adminRegis(userName, passWord, emailAddress, phoneNumber, uuid.toString(), 1);
            JSONObject json = new JSONObject();
            if (result == 1) {
                json.put("code", "0");
                json.put("msg", "注册成功");
            } else {
                json.put("code", "1");
                json.put("msg", "注册失败");
            }
            return json;
        }
    }

}
