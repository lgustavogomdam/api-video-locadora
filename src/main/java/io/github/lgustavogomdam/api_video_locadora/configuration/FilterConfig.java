package io.github.lgustavogomdam.api_video_locadora.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<CustomCORSFilter> corsFilter() {
        FilterRegistrationBean<CustomCORSFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CustomCORSFilter());
        registrationBean.addUrlPatterns("/api/actor/*"); // Todos os endpoints relacionados a /api/ator/ (com ou sem uma ID)
        registrationBean.addUrlPatterns("/api/class/*"); // Todos os endpoints relacionados a /api/ator/ (com ou sem uma ID)
        registrationBean.addUrlPatterns("/api/director/*"); // Todos os endpoints relacionados a /api/ator/ (com ou sem uma ID)

        return registrationBean;
    }
}