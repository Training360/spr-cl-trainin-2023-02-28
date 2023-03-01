package careerservice.enrollment.saga;

import careerservice.enrollment.model.EnrollCommand;
import careerservice.enrollment.service.EnrollmentService;
import careerservice.enrollment.view.EnrollmentView;
import careerservice.kafkagateway.EnrollCourseReply;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EnrollSaga {

    private EnrollmentService enrollmentService;

    private ApplicationEventPublisher publisher;

    public EnrollmentView enroll(EnrollCommand command) {
        var view = enrollmentService.enrollToCourse(command);
        var event = new EnrollCourseCommand(command.getCourseId(), command.getEmployeeId());
        publisher.publishEvent(event);
        return view;
    }

    public void register(EnrollCourseReply reply) {
        if (reply.isSuccess()) {
            enrollmentService.registered(reply.getCourseId(), reply.getEmployeeId());
        }
        else {
            enrollmentService.reject(reply.getCourseId(), reply.getEmployeeId());
        }
    }
}
