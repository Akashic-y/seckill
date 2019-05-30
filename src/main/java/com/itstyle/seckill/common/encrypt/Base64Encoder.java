package com.itstyle.seckill.common.encrypt;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Base64Encoder
{
    private final static Logger log = LoggerFactory.getLogger(Base64Encoder.class);

    //加密
    public static String getBASE64(String s)
    {
        if (s == null) return null;
        try
        {
            return Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e)
        {
            log.error("发生异常", e);
            return null;
        }
    }

    // 将 BASE64 编码的字符串 s 进行解码   解密
    public static String getFromBASE64(String s)
    {
        if (s == null) return null;
        try
        {
            byte[] b = Base64.getDecoder().decode(s);
            return new String(b);
        } catch (Exception e)
        {
            return null;
        }
    }

    public static String mTOa(Object ming)
    {
        return Base64Encoder.getBASE64(Base64Encoder.getBASE64(Base64Encoder.getBASE64((String) ming)));
    }

    public static String aTOm(String an)
    {
        return Base64Encoder.getFromBASE64(Base64Encoder.getFromBASE64(Base64Encoder.getFromBASE64(an)));
    }

    public static void main(String[] args)
    {
        String a = mTOa("爪哇笔记".toString());
        System.out.println(a);//加密
        System.out.println(aTOm(a));//解密
    }

}
