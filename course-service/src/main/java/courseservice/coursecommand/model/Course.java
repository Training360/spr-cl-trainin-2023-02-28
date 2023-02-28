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

    public static Course announceCourse(CreateCourseCommand command) {
        var course = new Course();
        course.name = command.getName();
        course.description = command.getDescription();
        course.syllabus = command.getSyllabus();
        course.limit = command.getLimit();

        return course;
    }

    public boolean enroll(long employeeId) {
        if (enrolledEmployees.contains(employeeId)) {
            return true;
        }
        if (isFull()) {
            return false;
        }
        enrolledEmployees.add(employeeId);
        return true;
    }

    private boolean isFull() {
        return enrolledEmployees.size() >= limit;
    }
}
