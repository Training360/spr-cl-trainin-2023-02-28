package frontendservice.service;

import frontendservice.dto.Course;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoursesService {

    private EmployeesService employeesService;

    private CourseMapper courseMapper;

    public List<Course> findAllCourses() {
        return null;
    }

    public CourseDetailsDto findCourseById(long id) {
        return null;
    }
}
