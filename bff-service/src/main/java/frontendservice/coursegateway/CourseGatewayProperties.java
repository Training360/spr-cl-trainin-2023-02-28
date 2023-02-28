package frontendservice.coursegateway;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "bff-service")
@Data
public class CourseGatewayProperties {

    private String courseServiceUrl;
}
