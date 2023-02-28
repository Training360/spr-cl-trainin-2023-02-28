package courseservice.coursecommand.dto;

import lombok.Data;

@Data
public class EnrollCommand {

    private long courseId;

    private long employeeId;
}
