package courseservice.coursecommand.model;

import courseservice.coursecommand.dto.CreateCourseCommand;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    private String description;

    @Lob
    private String syllabus;

    @Column(name = "attendee_limit")
    private int limit;

    @ElementCollection
    List<Long> enrolledEmployees;

    @ElementCollection
    List<Long> completedEmployees;

}
