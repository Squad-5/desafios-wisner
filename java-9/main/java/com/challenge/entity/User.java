package com.challenge.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = false, of = "id")
@EntityListeners(User.class)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "key.user", targetEntity = Submission.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Submission> submissions;

    @OneToMany(mappedBy = "key.user", targetEntity = Candidate.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Candidate> candidates;

    @Column(name = "full_name", length = 100, nullable = false)
    @Size(max = 100)
    @NotNull
    private String fullName;

    @Column(name = "email", length = 100, nullable = false)
    @Size(max = 100)
    @Email
    @NotNull
    private String email;

    @Column(name = "nickname", length = 50, nullable = false)
    @Size(max = 50)
    @NotNull
    private String nickname;

    @Column(name = "password", length = 255, nullable = false)
    @Size(max = 255)
    @NotNull
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt;
}
