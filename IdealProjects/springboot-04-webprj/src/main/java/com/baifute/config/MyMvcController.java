package com.baifute.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
@Configuration     //从源码中得知要想添加自己的mvc配置必须 写上@Configuration
public class MyMvcController implements WebMvcConfigurer {
    //重写addViewControllers 也可以是实现视图控制，可以对比IndexController　效果一样
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index.html");  //当输入是"/"让它跳转到index.html
        registry.addViewController("/index.html").setViewName("index.html");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    //将我配置的地区解析实现类注入到Bean ，返回实现类， 只有放到spring容器中自定义的国际化组件才生效！！
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }



    //mvc添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/css/**","/index.html","/","/user/login","/js/**","/img/**","/css/**");
    }
}
