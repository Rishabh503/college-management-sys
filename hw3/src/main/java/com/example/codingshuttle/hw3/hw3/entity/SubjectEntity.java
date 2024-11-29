package com.example.codingshuttle.hw3.hw3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="subjects")
public class SubjectEntity {
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

    //
//    private ProfessorEntity professor;
//
//    private List<StudentEntity> students;
}
