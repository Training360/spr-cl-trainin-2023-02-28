package careerservice.enrollment.model;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long employeeId;

    private long courseId;

    private Enrollment() {

    }

    public static Enrollment enrollToCourse(EnrollCommand command) {
        var enrollment = new Enrollment();
        enrollment.employeeId = command.getEmployeeId();
        enrollment.courseId = command.getCourseId();
        return enrollment;
    }

}
