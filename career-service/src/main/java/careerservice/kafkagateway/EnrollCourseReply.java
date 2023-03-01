package careerservice.kafkagateway;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollCourseReply {

    private long courseId;

    private long employeeId;

    private boolean success;
}
