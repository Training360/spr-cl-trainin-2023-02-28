package frontendservice.employeesgateway;

import frontendservice.coursegateway.CourseGatewayProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
@EnableConfigurationProperties(EmployeeGatewayProperties.class)
public class EmployeeClientConfig {

    @Bean
    public EmployeeClient employeeClient(EmployeeGatewayProperties properties) {
        var client = WebClient.builder().baseUrl(properties.getEmployeeServiceUrl()).build();
        var factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        var employeeClient = factory.createClient(EmployeeClient.class);
        return employeeClient;
    }
}
