package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceInterface service;

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    User findById(@PathVariable("id")  Long id) {
        Optional<User> user = service.findById(id);
        return user.isPresent() ? user.get() : null;
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    List<User>findByAccelerationNameOrCompanyId(HttpServletRequest request) {
        List<User> users = new ArrayList<>();

        if (request.getParameter("accelerationName") != null) {
            String accelerationName = request.getParameter("accelerationName");
            users = service.findByAccelerationName(accelerationName);
        } else if (request.getParameter("companyId") != null) {
            Long companyId = Long.valueOf(request.getParameter("companyId"));
            users = service.findByCompanyId(companyId);
        }

        return users;
    }
}
