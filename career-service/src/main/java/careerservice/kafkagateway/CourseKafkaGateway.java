package careerservice.kafkagateway;

import careerservice.enrollment.saga.EnrollCourseCommand;
import careerservice.enrollment.saga.EnrollSaga;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Consumer;

@Service
@AllArgsConstructor
@Slf4j
@Configuration
public class CourseKafkaGateway {

    private StreamBridge streamBridge;

    private EnrollSaga saga;

    @EventListener
    public void enroll(EnrollCourseCommand command) {
        streamBridge.send("course-request-topic", command);
    }

    @Bean
    public Consumer<EnrollCourseReply> enrollCourseReplyConsumer() {
        return reply -> {
            log.debug("Message has come: {}", reply);
            saga.register(reply);
        };
    }

}
