package frontendservice.service;

import lombok.Data;

@Data
public class Course {

    private Long id;

    private String name;

    private int limit;

    private CourseDetails courseDetails;
}
