package ratingservice.service;

import ratingservice.dto.RateResponse;
import ratingservice.model.Rating;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RatingMapper {

    RateResponse toDto(Rating rating);

}
