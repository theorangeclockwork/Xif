package fix.task;

import fix.task.controller.HourseServlet;
import fix.task.service.HourseService;
import fix.task.service.ValidationService;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServlet;

@Configuration
public class WebConfig {
    @Bean
    public ServletRegistrationBean<HttpServlet> hourseServlet(HourseService hourseService, ValidationService validationService) {
        ServletRegistrationBean<HttpServlet> sRBean = new ServletRegistrationBean<>();
        sRBean.setServlet(new HourseServlet(hourseService, validationService));
        sRBean.addUrlMappings("/hourse/servlet/count");
        sRBean.setLoadOnStartup(1);
        return sRBean;
    }
}
