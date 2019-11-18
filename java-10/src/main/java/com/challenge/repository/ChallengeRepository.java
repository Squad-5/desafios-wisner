package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends CrudRepository<Challenge, Long> {

    @Query("SELECT DISTINCT c FROM Challenge c WHERE c.id IN " +
            "(SELECT DISTINCT a.challenge.id FROM Acceleration a WHERE a.id = :accelerationId) " +
            "AND c.id IN " +
            "(SELECT DISTINCT s.id.challenge.id FROM Submission s WHERE s.id.user.id = :userId)")
    List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId") Long accelerationId, @Param("userId") Long userId);
}
