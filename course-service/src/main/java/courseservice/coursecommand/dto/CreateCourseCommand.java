package courseservice.coursecommand.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateCourseCommand {

    private String name;

    private String description;

    private String syllabus;

    private int limit;

}
