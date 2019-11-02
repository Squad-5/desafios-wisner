package com.challenge.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "submission")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = false, of = "key")
@EntityListeners(Submission.class)
public class Submission implements Serializable {

    @EmbeddedId
    private SubmissionKey key = new SubmissionKey();

    @Column(name = "score", nullable = false)
    @NotNull
    private Float score;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt;
}
