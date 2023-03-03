package ratingservice.service;

import org.springframework.data.repository.query.Param;
import ratingservice.dto.RatingAverage;
import ratingservice.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("select new ratingservice.dto.RatingAverage(r.courseId, avg(r.stars), count(r.id)) from Rating r where r.courseId = :courseId group by r.courseId")
    Optional<RatingAverage> findAverageByCourseId(@Param("courseId") long courseId);

}
