package com.challenge.service.impl;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SubmissionService implements SubmissionServiceInterface {
    @Autowired
    @Getter
    private SubmissionRepository repository;

    @Override
    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
        List<BigDecimal> result = repository.findHigherScoreByChallengeId(challengeId);

        BigDecimal max = result.size() > 0 ? result.stream().max(BigDecimal::compareTo).get() : BigDecimal.ZERO;
        return max;
    }

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return repository.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }

    @Override
    @Transactional
    public Submission save(Submission object) {
        return repository.save(object);
    }
}
