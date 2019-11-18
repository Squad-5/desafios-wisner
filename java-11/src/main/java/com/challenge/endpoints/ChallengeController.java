package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {
    @Autowired
    private ChallengeServiceInterface service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    List<Challenge> findByAccelerationIdAndUserId(@RequestParam("accelerationId") Long accelerationId,
                                                  @RequestParam("userId") Long userId) {
        return service.findByAccelerationIdAndUserId(accelerationId, userId);
    }
//
//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    List<Challenge> findAll() {
//        return service.findAll();
//    }
}
