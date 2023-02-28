package frontendservice.service;

import frontendservice.coursegateway.CourseClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoursesService {

    private CourseClient courseClient;

    private EmployeesService employeesService;

    private CourseMapper courseMapper;

    public List<Course> findAllCourses() {
        return courseMapper.toDto(courseClient.findAllCourses());
    }

    public CourseDetails findById(Long id) {
        var course = courseClient.findCourseById(id);
        var employees = employeesService.listEmployees();
        return courseMapper.toDto(course, employees);

    }
}
