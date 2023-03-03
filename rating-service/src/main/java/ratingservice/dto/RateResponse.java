package ratingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateResponse {

    private Long id;

    private long employeeId;

    private long courseId;

    private int stars;
}
