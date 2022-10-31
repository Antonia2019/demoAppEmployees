package com.example.demo.employee;

import com.example.demo.address.Address;
import lombok.*;


import javax.persistence.*;

@Entity // for hibernate
@Table(name = "employees")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private Long id;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "salary")
    @Getter
    @Setter
    private Long salary;

    @Column(name = "designation")
    @Getter
    @Setter
    private String designation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @Getter
    @Setter
    private Address address;

    public Employee(String name, Long salary, String designation, Address address) {
        this.name = name;
        this.salary = salary;
        this.designation = designation;
        this.address = address;
    }
}
