package ratingservice.service;

import ratingservice.dto.RateResponse;
import ratingservice.dto.RateRequest;
import ratingservice.dto.RatingAverage;
import ratingservice.model.Rating;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RatingService {

    private RatingRepository ratingRepository;

    private RatingMapper ratingMapper;

    public RateResponse createRating(RateRequest request) {
        var rating = new Rating(request.getEmployeeId(), request.getCourseId(), request.getStars());
        ratingRepository.save(rating);
        return ratingMapper.toDto(rating);
    }

    public RatingAverage findAverageByCourseId(long courseId) {
        return ratingRepository.findAverageByCourseId(courseId)
                .orElseGet(() -> new RatingAverage(courseId, 0, 0));
    }
}
