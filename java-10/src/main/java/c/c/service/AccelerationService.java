package c.c.service;

import com.challenge.entity.Acceleration;
import com.challenge.entity.Candidate;
import com.challenge.entity.Challenge;
import com.challenge.repository.AccelerationRepository;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AccelerationService implements AccelerationServiceInterface {

    @Autowired
    @Getter
    private AccelerationRepository repository;

    @Override
    public Optional<Acceleration> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Acceleration> findByCompanyId(Long companyId) { return repository.findByCompanyId(companyId); }

    @Override
    @Transactional
    public Acceleration save(Acceleration object) {
        return repository.save(object);
    }
}
