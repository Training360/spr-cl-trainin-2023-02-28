package courseservice.kafkagateway;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollCourseCommand {

    private long courseId;

    private long employeeId;
}
