package c.c.service;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.entity.User;
import com.challenge.repository.CandidateRepository;
import com.challenge.service.interfaces.CandidateServiceInterface;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService implements CandidateServiceInterface {
    @Autowired
    @Getter
    private CandidateRepository repository;

    @Override
    public Optional<Candidate> findById(CandidateId id) {
        return repository.findByCandidateId(id);
    }

    @Override
    public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
        return repository.findByCandidateId(userId, companyId, accelerationId);
    }

    @Override
    public List<Candidate> findByCompanyId(Long companyId) {
        return repository.findByCompanyId(companyId);
    }

    @Override
    public List<Candidate> findByAccelerationId(Long accelerationId) {
        return repository.findByAccelerationId(accelerationId);
    }

    @Override
    @Transactional
    public Candidate save(Candidate object) {
        return repository.save(object);
    }


}
