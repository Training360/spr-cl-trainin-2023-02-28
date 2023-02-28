package courseservice.coursecommand.service;

import courseservice.NotFoundException;
import courseservice.coursecommand.dto.CourseDetailsView;
import courseservice.coursecommand.dto.CourseView;
import courseservice.coursecommand.dto.CreateCourseCommand;
import courseservice.coursecommand.model.Course;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CourseService {

    private CourseRepository courseRepository;

    private CourseMapper courseMapper;

    public CourseView createCourse(CreateCourseCommand command) {
        return null;
    }

    public CourseDetailsView findCourseById(long id) {
        return null;
    }

    public List<CourseView> findAllCourses() {
        return null;
    }

}
