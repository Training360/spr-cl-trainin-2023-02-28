package courseservice.kafkagateway;

import courseservice.coursecommand.dto.EnrollCommand;
import courseservice.coursecommand.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@AllArgsConstructor
@Slf4j
@Configuration
public class CourseCommandHandler {

    private CourseService courseService;

    @Bean
    public Function<EnrollCourseCommand, EnrollCourseReply> enrollCourseCommandFunction() {
        return command -> {
            log.debug("Message has come: {}", command);
            var success = courseService.enroll(new EnrollCommand(command.getCourseId(), command.getEmployeeId()));
            return new EnrollCourseReply(success);
        };
    }
}
