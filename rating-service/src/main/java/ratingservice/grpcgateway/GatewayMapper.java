package ratingservice.grpcgateway;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GatewayMapper {

    ratingservice.dto.RateRequest toDto(RateRequest request);

    RateResponse toGateway(ratingservice.dto.RateResponse response);

    RatingAverage toGateway(ratingservice.dto.RatingAverage average);
}
