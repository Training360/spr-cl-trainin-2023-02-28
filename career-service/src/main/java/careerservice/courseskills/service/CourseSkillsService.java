package careerservice.courseskills.service;

import careerservice.NotFoundException;
import careerservice.courseskills.model.AssignSkillsToCourseCommand;
import careerservice.courseskills.model.CourseSkills;
import careerservice.courseskills.view.CourseSkillsView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CourseSkillsService {

    private CourseSkillsRepository repository;

    private CourseSkillsMapper mapper;

    public CourseSkillsView findViewByCourseId(long courseId) {
//        return repository.findViewByCourseId(courseId)
        var skills = repository.findByCourseId(courseId)
                .orElseThrow(() -> new NotFoundException("Skills not found for course %d".formatted(courseId)));
        return mapper.toView(skills);
    }

    @Transactional
    public CourseSkillsView assignSkills(AssignSkillsToCourseCommand command) {
        var skills = repository.findByCourseId(command.getCourseId());
        CourseSkills result;
        if (skills.isEmpty()) {
            result = CourseSkills.create(command);
            repository.save(result);
        }
        else {
            result = skills.get();
            result.addSkills(command.getSkills());
        }
        return mapper.toView(result);
    }
}
