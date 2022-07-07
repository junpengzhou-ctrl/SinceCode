package com.baifute.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
//国际化配置
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //解析请求   根据网页链接 th:href="@{/index.html(1='en_US')}"
        String language = request.getParameter("l");   //接受网页的 l 传参。
        Locale locale = Locale.getDefault();  //如果没有获取到请求参数就走默认的方式来解析
        if (!StringUtils.isEmpty(language)){
            //如果请求的链接携带了国际化的参数，取出对应的属性值
            String[] split = language.split("_");  //得到 en_US 或者 zh_CN  两个数
            //拿到国家和地区 封装在Locale对象里
            locale = new Locale(split[0],split[1]);
        }
        
        return locale;
        
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
