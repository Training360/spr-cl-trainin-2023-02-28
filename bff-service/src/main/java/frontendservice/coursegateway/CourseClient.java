package frontendservice.coursegateway;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface CourseClient {

    @GetExchange("/api/courses")
    public List<Course> findAllCourses();
    @GetExchange("/api/courses/{id}")
    public CourseDetails findCourseById(@PathVariable("id") long id);

}
