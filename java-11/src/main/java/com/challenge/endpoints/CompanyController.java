package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.interfaces.CompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyServiceInterface service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    Company findById(@PathVariable("id") Long id) {
        Optional<Company> company = service.findById(id);

        return company.isPresent() ? company.get() : null;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    List<Company> findByAccelerationIdOrUserId(HttpServletRequest request) {

        List<Company> companies = new ArrayList<>();

        if (request.getParameter("accelerationId") != null) {
            Long accelerationId = Long.valueOf(request.getParameter("accelerationId"));
            companies = service.findByAccelerationId(accelerationId);
        } else if (request.getParameter("userId") != null) {
            Long userId = Long.valueOf(request.getParameter("userId"));
            companies = service.findByUserId(userId);
        }
        return companies;
    }
}
