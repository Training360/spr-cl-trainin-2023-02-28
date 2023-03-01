package careerservice.enrollment.service;

import careerservice.enrollment.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {


    List<Enrollment> findAllByEmployeeId(long employeeId);

    Optional<Enrollment> findByCourseIdAndEmployeeId(long courseId, long employeeId);
}
