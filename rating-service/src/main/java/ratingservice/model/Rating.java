package ratingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long employeeId;

    private long courseId;

    private int stars;

    public Rating(long employeeId, long courseId, int stars) {
        this.employeeId = employeeId;
        this.courseId = courseId;
        this.stars = stars;
    }
}
