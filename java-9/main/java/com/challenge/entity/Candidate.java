package com.challenge.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "candidate")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = false, of = "key")
@EntityListeners(Candidate.class)
public class Candidate implements Serializable {
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @EmbeddedId
    private CandidateKey key = new CandidateKey();

    @Column(name = "status")
    @NotNull
    private Integer status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt;
}
