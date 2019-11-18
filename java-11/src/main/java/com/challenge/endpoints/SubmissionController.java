package com.challenge.endpoints;

import com.challenge.dto.SubmissionDTO;
import com.challenge.entity.Submission;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController {
    @Autowired
    private SubmissionServiceInterface service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    List<Submission> findByChallengeIdAndAccelerationId(HttpServletRequest request) {
        return service.findByChallengeIdAndAccelerationId(Long.valueOf(request.getParameter("challengeId")), Long.valueOf(request.getParameter("accelerationId")));
    }
}
