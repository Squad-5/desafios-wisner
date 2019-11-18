package com.challenge.repository;

import com.challenge.entity.Submission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface SubmissionRepository extends CrudRepository<Submission, Long> {

    @Query("SELECT DISTINCT s.score FROM Submission s WHERE s.id.challenge.id = :challengeId")
    List<BigDecimal> findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);

    @Query("SELECT DISTINCT s FROM Submission s WHERE s.id.challenge.id = :challengeId " +
            "AND s.id.challenge.id IN " +
            "(SELECT DISTINCT a.challenge.id FROM Acceleration a WHERE a.id = :accelerationId)")
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId, @Param("accelerationId") Long accelerationId);
}
