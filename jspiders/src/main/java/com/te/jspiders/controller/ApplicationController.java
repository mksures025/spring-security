package com.te.jspiders.controller;

import com.te.jspiders.dto.EmployeeDTO;
import com.te.jspiders.dto.StudentDTO;
import com.te.jspiders.dto.TrainerDTO;
import com.te.jspiders.response.ApiResponse;
import com.te.jspiders.service.EmployeeService;
import com.te.jspiders.service.StudentService;
import com.te.jspiders.service.TrainerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/public")
@RestController
public class ApplicationController {

    private final TrainerService trainerService;
    private final StudentService studentService;
    private final EmployeeService employeeService;

    @PostMapping(path = "/trainer/register")
    public ApiResponse<String> registerTrainer(@RequestBody TrainerDTO trainerDto) {
        log.info("TrainerController:registerTrainer execution start, {}", trainerDto);
        Optional<String> trainerId = trainerService.registerTrainer(trainerDto);
        if (trainerId.isPresent()) {
            return new ApiResponse<String>("Trainer registration successfull!", null, trainerId.get());
        }
        throw new RuntimeException("Trainer registration failed");
    }

    @PostMapping(path = "/student/register")
    public ApiResponse<String> registerStudent(@RequestBody StudentDTO studentDto) {
        log.info("StudentController:registerStudent execution start, {}", studentDto);
        Optional<String> stuId = studentService.registerStudent(studentDto);
        if (stuId.isPresent()) {
            return new ApiResponse<String>("Student registration successfull!", null, stuId.get());
        }
        throw new RuntimeException("Student registration failed");

    }

    @PostMapping(path = "/employee/register")
    public ApiResponse<String> registerEmployee(@RequestBody EmployeeDTO employeeDto) {
        log.info("EmployeeController:registerEmployee execution start, {}", employeeDto);
        Optional<String> empId = employeeService.registerEmployee(employeeDto);
        if (empId.isPresent()) {
            return new ApiResponse<String>("Employee registration successfull!", null, empId.get());
        }
        throw new RuntimeException("Employee registration failed");
    }
}