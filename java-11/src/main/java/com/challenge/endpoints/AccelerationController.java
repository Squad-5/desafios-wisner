package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {
    @Autowired
    private AccelerationServiceInterface service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    Acceleration findById(@PathVariable("id") Long id) {
        Optional<Acceleration> acceleration = service.findById(id);

        return acceleration.isPresent() ? acceleration.get() : null;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    List<Acceleration> findByCompanyId(HttpServletRequest request) {
        return service.findByCompanyId(Long.valueOf(request.getParameter("companyId")));
    }
}
