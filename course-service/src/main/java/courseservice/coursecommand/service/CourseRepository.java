package courseservice.coursecommand.service;

import courseservice.coursecommand.dto.CourseView;
import courseservice.coursecommand.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {



}
