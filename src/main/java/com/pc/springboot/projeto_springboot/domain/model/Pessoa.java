package com.pc.springboot.projeto_springboot.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 60, nullable = false)
    private String nome;

    @Column(name = "dataNascimento", length = 60, nullable = false)
    private LocalDate dataNascimento;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "pessoa_endereco",
//        joinColumns = @JoinColumn(name = "pessoa_id"),
//        inverseJoinColumns = @JoinColumn(name = "endereco_id"))
//    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy = "pessoa")
    //@JsonIgnore
    private List<Endereco> enderecos = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public Pessoa setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Pessoa setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Pessoa setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

//    public List<Endereco> getEnderecos() {
//        return enderecos;
//    }
//
//    public Pessoa setEnderecos(List<Endereco> enderecos) {
//        this.enderecos = enderecos;
//        return this;
//    }


    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public Pessoa setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;

        Pessoa pessoa = (Pessoa) o;

        return Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", enderecos=" + enderecos +
                '}';
    }
}
