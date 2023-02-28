package courseservice.coursecommand.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseView {

    private Long id;

    private String name;

    private int limit;
}
