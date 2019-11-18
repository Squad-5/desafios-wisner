package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    @Query("SELECT DISTINCT c FROM Company c WHERE c.id IN " +
            "(SELECT DISTINCT ca.id.company.id FROM Candidate ca WHERE ca.id.acceleration.id = :accelerationId)")
    List<Company> findByAccelerationId(@Param("accelerationId") Long accelerationId);

    @Query("SELECT DISTINCT c FROM Company c WHERE c.id IN " +
            "(SELECT DISTINCT ca.id.company.id FROM Candidate ca WHERE ca.id.user.id = :userId)")
    List<Company> findByUserId(@Param("userId") Long userId);
}
