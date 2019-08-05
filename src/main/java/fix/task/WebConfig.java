package fix.task;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServlet;

@Configuration
public class WebConfig {
    @Bean
    public ServletRegistrationBean<HttpServlet> hourseServlet(HourseService hourseService) {
        ServletRegistrationBean<HttpServlet> sRBean = new ServletRegistrationBean<>();
        sRBean.setServlet(new HourseServlet(hourseService));
        sRBean.addUrlMappings("/hourse/servlet/count");
        sRBean.setLoadOnStartup(1);
        return sRBean;
    }
}
