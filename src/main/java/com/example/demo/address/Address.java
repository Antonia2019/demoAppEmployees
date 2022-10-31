package com.example.demo.address;


import lombok.*;

import javax.persistence.*;


@Entity // for hibernate
@Table(name = "address")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Getter
    @Setter
    private Long id;
    @Column(name = "oras")
    @Getter
    @Setter
    private String oras;
    @Column(name = "strada")
    @Getter
    @Setter
    private String strada;
    @Column(name = "numar")
    @Getter
    @Setter
    private Integer numar;

    public Address(String oras, String strada, Integer numar) {
        this.oras = oras;
        this.strada = strada;
        this.numar = numar;
    }
}
