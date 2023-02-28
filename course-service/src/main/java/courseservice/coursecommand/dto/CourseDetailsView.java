package courseservice.coursecommand.dto;

import lombok.Data;

import java.util.List;

@Data
public class CourseDetailsView {

    private Long id;

    private String name;

    private String description;

    private String syllabus;

    private int limit;

    List<Long> enrolledEmployees;

    List<Long> completedEmployees;
}
