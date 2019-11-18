package com.challenge.service.interfaces;

import com.challenge.entity.Acceleration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface AccelerationServiceInterface extends ServiceInterface<Acceleration> {

    Optional<Acceleration> findById(Long id);

    List<Acceleration> findByCompanyId(Long companyId);

}
