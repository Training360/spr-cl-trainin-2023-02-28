package careerservice.courseskills.service;

import careerservice.courseskills.model.CourseSkills;
import careerservice.courseskills.view.CourseSkillsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CourseSkillsRepository extends JpaRepository<CourseSkills, Long> {

    @Query(value = "select distinct s from CourseSkills s left join fetch s.skills")
    Optional<CourseSkills> findByCourseId(long courseId);

    @Query(value = "select distinct new careerservice.courseskills.view.CourseSkillsView(s.id, s.courseId, s.skills) from CourseSkills s left join s.skills")
    Optional<CourseSkillsView> findViewByCourseId(long courseId);

}
