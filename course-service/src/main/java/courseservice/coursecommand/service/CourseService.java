package courseservice.coursecommand.service;

import courseservice.NotFoundException;
import courseservice.coursecommand.dto.CourseDetailsView;
import courseservice.coursecommand.dto.CourseView;
import courseservice.coursecommand.dto.CreateCourseCommand;
import courseservice.coursecommand.dto.EnrollCommand;
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
        var course = Course.announceCourse(command);
        courseRepository.save(course);
        return courseMapper.toView(course);
    }

    public List<CourseView> findAllCourses() {
        return courseRepository.findAllView();
    }

    @Transactional(readOnly = true)
    public CourseDetailsView findCourseById(long id) {
        var course = courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Can not find course by id: %s".formatted(id)));
        return courseMapper.toDetailsView(course);
    }

    @Transactional
    public boolean enroll(EnrollCommand command) {
        var course = courseRepository.findById(command.getCourseId())
                .orElseThrow(() -> new NotFoundException("Can not find course by id: %s".formatted(command.getCourseId())));
        return course.enroll(command.getEmployeeId());
    }

}
