package ratingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RateRequest {

    private long employeeId;

    private long courseId;

    private int stars;

}
