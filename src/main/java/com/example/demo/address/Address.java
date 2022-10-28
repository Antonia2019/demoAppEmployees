package com.example.demo.address;


import javax.persistence.*;


@Entity // for hibernate
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "oras")
    private String oras;
    @Column(name = "strada")
    private String strada;
    @Column(name = "numar")
    private Integer numar;

    public Address() {
    }


    public Address(String oras, String strada, Integer numar) {
        this.oras = oras;
        this.strada = strada;
        this.numar = numar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public Integer getNumar() {
        return numar;
    }

    public void setNumar(Integer numar) {
        this.numar = numar;
    }

    @Override
    public String toString() {
        return "Address{" +
                "  id=" + id +
                ", oras='" + oras + '\'' +
                ", strada='" + strada + '\'' +
                ", numar=" + numar +
                '}';
    }
}
