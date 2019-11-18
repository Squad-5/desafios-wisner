package com.challenge.entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class CandidateKey implements Serializable {

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @JoinColumn(name = "acceleration_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Acceleration acceleration;

    @JoinColumn(name = "company_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;
}
