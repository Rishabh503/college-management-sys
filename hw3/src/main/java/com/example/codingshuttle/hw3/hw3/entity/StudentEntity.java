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

import static org.apache.tomcat.util.net.openssl.OpenSSLStatus.getName;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="student")
public class StudentEntity extends AuditableEntity{

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
    @OneToOne
    @JoinColumn(name="student_fees_record",referencedColumnName = "id")
    private AdmissionRecordEntity feesSlip;

    @ManyToMany(mappedBy = "StudentsTaughtByProffesor")
    @JsonIgnore
    private Set<ProfessorEntity> ProfessorTeachingStudent;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name="subject_to_students)",
    joinColumns = @JoinColumn(name = "subject_id"),
    inverseJoinColumns = @JoinColumn(name="student_id"))
    private Set<SubjectEntity> subjects;
}
