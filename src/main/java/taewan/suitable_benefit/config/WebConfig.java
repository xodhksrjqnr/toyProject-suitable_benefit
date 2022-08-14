package taewan.suitable_benefit.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //application.properties에 정의된 데이터를 호출
    @Value("${resource.path}")
    private String resourcePath;

    //application.properties에 정의된 데이터를 호출
    @Value("${access.path}")
    private String accessPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //리소스에 대한 접근 경로 설정
        registry.addResourceHandler(accessPath)
                .addResourceLocations(resourcePath + "img/");
    }
}
