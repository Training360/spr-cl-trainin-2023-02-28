package careerservice.enrollment.view;

import careerservice.enrollment.model.EnrollmentStatus;
import lombok.Data;

@Data
public class EnrollmentView {

    private Long id;

    private long employeeId;

    private long courseId;

    private EnrollmentStatus status;
}
