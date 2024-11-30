package com.example.codingshuttle.hw3.hw3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name="Admission_Records")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AdmissionRecordEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getFees(), that.getFees());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFees());
    }

    @Column(nullable = false)
    private Integer fees;

    @OneToOne(mappedBy = "feesSlip")
    @JsonIgnore
    private StudentEntity student;

}
