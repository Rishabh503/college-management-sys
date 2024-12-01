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
@Table(name="subjects")
public class SubjectEntity extends AuditableEntity {
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SubjectEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getSubtitle(), that.getSubtitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSubtitle());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String subtitle;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="professor_subject_id",referencedColumnName = "id")
    @JsonIgnore
    private ProfessorEntity professor_of_this_subject;

    @ManyToMany(mappedBy = "subjects")
//    @JsonIgnore
    private Set<StudentEntity> students;
}


