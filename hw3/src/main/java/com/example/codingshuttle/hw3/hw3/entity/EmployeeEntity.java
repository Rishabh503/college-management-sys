package com.example.codingshuttle.hw3.hw3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Entity
//@Data isko hatana pdega bcoz ye issue create creaga many to many me instead we add
@Getter
@Setter
//and also we add hash and equals method for id and name
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employees")
@ToString
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

//    @Override
//    public String toString() {
//        return "name "+ name +" "+"id="+id;
//    }


//    @OneToOne(mappedBy = "manager")
//    @JsonIgnore
//    private DepartmentEntity departmentManagedBy;
//
//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof EmployeeEntity that)) return false;
//        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getName());
//    }
////

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="worker_department_id",referencedColumnName = "id")
//    @JsonIgnore
//    private DepartmentEntity workerDepartment;
//
//
//    @ManyToMany
//    @JoinTable(name="freelancer_department_mapping",
//                joinColumns = @JoinColumn(name="employee_id"),
//                inverseJoinColumns =@JoinColumn(name="department_id")
//    )@JsonIgnore
//    private Set<DepartmentEntity> freelanceDepartments;
}
