package com.example.codingshuttle.hw3.hw3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="professor")
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Column(nullable = false)
    private String title;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProfessorEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle());
    }
    @OneToMany(mappedBy = "professor_of_this_subject",fetch = FetchType.EAGER)
    private Set<SubjectEntity> subjectsbyproffesor;

    @ManyToMany
    @JoinTable(name="students_by_proff",joinColumns = @JoinColumn(name="professor_id"),
                            inverseJoinColumns = @JoinColumn(name="student_id"))
    private Set<StudentEntity> StudentsTaughtByProffesor;
}
