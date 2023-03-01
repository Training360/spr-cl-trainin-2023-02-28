package careerservice.kafkagateway;

import careerservice.enrollment.saga.EnrollCourseCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CourseKafkaGateway {

    private StreamBridge streamBridge;

    @EventListener
    public void enroll(EnrollCourseCommand command) {
        streamBridge.send("course-request-topic", command);
    }
}
