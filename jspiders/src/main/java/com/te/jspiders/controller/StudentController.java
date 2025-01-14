package com.te.jspiders.controller;

import com.te.jspiders.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(path = "/api/student")
@RestController
public class StudentController {

    @PutMapping(path = "/update")
    public ApiResponse<String> updateStudent() {
        return new ApiResponse<String>("Student update successfull!", null, "Update api being used");
    }

    @DeleteMapping(path = "/delete")
    public ApiResponse<String> deleteStudent() {
        return new ApiResponse<String>("Student delete successfull!", null, "Delete api being used");
    }

    @PutMapping(path = "/changePassword")
    public ApiResponse<String> changePassword() {
        return new ApiResponse<String>("Student change password successfull!", null, "Change password api being used");
    }
}
