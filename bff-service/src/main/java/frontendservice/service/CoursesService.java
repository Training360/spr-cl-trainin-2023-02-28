package frontendservice.service;

import frontendservice.coursegateway.CourseClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CoursesService {

    private CourseClient courseClient;

    private EmployeesService employeesService;

    private CourseMapper courseMapper;

    public List<Course> findAllCourses() {
        log.debug("findAllCourses");
        return courseMapper.toDto(courseClient.findAllCourses());
    }

    public CourseDetails findById(Long id) {
        log.debug("findById");
        var course = courseClient.findCourseById(id);
        var employees = employeesService.listEmployees();
        return courseMapper.toDto(course, employees);

    }
}
