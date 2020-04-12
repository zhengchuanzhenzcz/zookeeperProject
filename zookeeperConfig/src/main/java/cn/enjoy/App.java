package cn.enjoy;

import cn.enjoy.listener.InitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Created by VULCAN on 2018/9/14.
 */
//spring boot 启动类
//代表着是个springboot的项目
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        //启动类是哪个，定制化参数
        SpringApplication.run(App.class, args);

    }

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new InitListener());
        return servletListenerRegistrationBean;
    }
}
