package careerservice.enrollment.controller;

import careerservice.enrollment.saga.EnrollSaga;
import careerservice.enrollment.view.EnrollmentView;
import careerservice.enrollment.model.EnrollCommand;
import careerservice.enrollment.service.EnrollmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private EnrollmentService enrollmentService;

    private EnrollSaga enrollSaga;

    @GetMapping
    public List<EnrollmentView> findAllByEmployee(@RequestParam long employeeId) {
        return enrollmentService.findAllByEmployee(employeeId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EnrollmentView enrollToCourse(@RequestBody EnrollCommand command) {
        return enrollSaga.enroll(command);
    }
}
