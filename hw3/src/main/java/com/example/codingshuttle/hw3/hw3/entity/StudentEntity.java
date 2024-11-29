package com.example.codingshuttle.hw3.hw3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

import static org.apache.tomcat.util.net.openssl.OpenSSLStatus.getName;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String studentname;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StudentEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getStudentname(), that.getStudentname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStudentname());
    }

    //    private List<ProfessorEntity> professors;
//
//    private List<SubjectEntity> subjects;
}