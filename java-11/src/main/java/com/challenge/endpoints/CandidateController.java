package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.service.interfaces.CandidateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateServiceInterface service;

    @GetMapping("/{userId}/{accelerationId}/{companyId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    Candidate findById(@PathVariable("userId") Long userId,
                       @PathVariable("accelerationId") Long accelerationId,
                       @PathVariable("companyId") Long companyId) {

        Optional<Candidate> candidate = service.findById(userId, companyId, accelerationId);
        return candidate.isPresent() ? candidate.get() : null;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    List<Candidate> findByCompanyIdOrAccelerationId(HttpServletRequest request) {
        List<Candidate> candidates = new ArrayList<>();

        if (request.getParameter("companyId") != null) {
            Long companyId = Long.valueOf(request.getParameter("companyId"));
            candidates = service.findByCompanyId(companyId);
        } else if (request.getParameter("accelerationId") != null) {
            Long accelerationId = Long.valueOf(request.getParameter("accelerationId"));
            candidates = service.findByAccelerationId(accelerationId);
        }
        return candidates;

    }
}
