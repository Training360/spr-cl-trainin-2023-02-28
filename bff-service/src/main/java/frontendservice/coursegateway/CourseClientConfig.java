package frontendservice.coursegateway;

import frontendservice.employeesgateway.EmployeeGatewayProperties;
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
    public CourseClient courseClient(CourseGatewayProperties properties) {
        var client = WebClient.builder().baseUrl(properties.getCourseServiceUrl()).build();
        var factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        var courseClient = factory.createClient(CourseClient.class);
        return courseClient;
    }
}
