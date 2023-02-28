package frontendservice.service;

import frontendservice.coursegateway.CourseClient;
import frontendservice.dto.Course;
import frontendservice.dto.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoursesService {

    private EmployeesService employeesService;

    private CourseClient courseClient;

    private CourseMapper courseMapper;

    public List<Course> findAllCourses() {
        return courseClient.listAllCourses();
    }

    public CourseDetailsDto findCourseById(long courseId) {
        var course = courseClient.findCourseById(courseId);

        // TODO Csak a megfelelő id-jú employee-k lekérdezése
        var employees = employeesService.listEmployees();

        // API composition
        // CourseDetails átkonvertálása CourseDetailsDto-ra, hogy Employee referenciákat tartalmazzon

        return courseMapper.toDto(course, employees);
    }
}
