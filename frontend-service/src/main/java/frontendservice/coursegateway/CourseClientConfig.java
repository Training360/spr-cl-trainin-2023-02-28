package frontendservice.coursegateway;

import frontendservice.employeegateway.EmployeeClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
@EnableConfigurationProperties(CourseGatewayProperties.class)
public class CourseClientConfig {

    @Bean
    public CourseClient courseClient(WebClient.Builder builder, CourseGatewayProperties courseGatewayProperties) {

        // Config: @EnableConfigurationProperties
        var client = builder.baseUrl(courseGatewayProperties.getCourseServiceUrl()).build();
        var factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        return factory.createClient(CourseClient.class);
    }
}
