package com.challenge.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "acceleration")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = false, of = "id")
@EntityListeners(Acceleration.class)
public class Acceleration implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "key.acceleration", targetEntity = Candidate.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Candidate> candidates;

    @JoinColumn(name = "challenge_id", unique = true, nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Challenge challenge;

    @Column(name = "name", length = 100, nullable = false)
    @Size(max = 100)
    @NotNull
    private String name;

    @Column(name = "slug", length = 50, nullable = false)
    @Size(max = 50)
    @NotNull
    private String slug;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt;
}
