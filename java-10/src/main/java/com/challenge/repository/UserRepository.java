package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT DISTINCT u FROM User u WHERE u.id IN " +
            "(SELECT DISTINCT c.id.user.id FROM Candidate c WHERE c.id.acceleration.name LIKE :name)")
    List<User> findByAccelerationName(@Param("name") String name);


    @Query("SELECT DISTINCT u FROM User u WHERE u.id IN " +
            "(SELECT DISTINCT c.id.user.id FROM Candidate c WHERE c.id.company.id = :companyId)")
    List<User> findByCompanyId(@Param("companyId") Long companyId);
}
