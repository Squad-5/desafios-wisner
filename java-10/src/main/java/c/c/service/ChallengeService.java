package c.c.service;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChallengeService implements ChallengeServiceInterface {
    @Autowired
    @Getter
    private ChallengeRepository repository;

    @Override
    public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
        return repository.findByAccelerationIdAndUserId(accelerationId, userId);
    }

    @Override
    @Transactional
    public Challenge save(Challenge object) {
        return repository.save(object);
    }
}
