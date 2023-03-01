package careerservice.completecourse.service;

import lombok.Data;

@Data
public class CompleteCourseCommand {

    private Long employeeId;

    private Long courseId;
}
