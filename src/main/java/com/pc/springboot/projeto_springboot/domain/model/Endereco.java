package com.pc.springboot.projeto_springboot.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "logradouro", length = 80, nullable = false)
    private String logradouro;
    @Column(name = "cep", length = 9, nullable = false)
    private String cep;

    @Column(name = "numero", length = 5, nullable = false)
    private int numero;

    @Column(name = "cidade", length = 50, nullable = false)
    private String cidade;


    //@JsonIgnoreProperties("hibernateLazyInitializer")
    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(nullable = false)
    @JsonIgnore
    private Pessoa pessoa;


    public Long getId() {
        return id;
    }

    public Endereco setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Endereco setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public Endereco setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public int getNumero() {
        return numero;
    }

    public Endereco setNumero(int numero) {
        this.numero = numero;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public Endereco setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Endereco setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco)) return false;

        Endereco endereco = (Endereco) o;

        return id.equals(endereco.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

//    @Override
//    public String toString() {
//        return "Endereco{" +
//                "id=" + id +
//                ", logradouro='" + logradouro + '\'' +
//                ", cep='" + cep + '\'' +
//                ", numero=" + numero +
//                ", cidade='" + cidade + '\'' +
//                '}';
//    }


    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", logradouro='" + logradouro + '\'' +
                ", cep='" + cep + '\'' +
                ", numero=" + numero +
                ", cidade='" + cidade + '\'' +
                ", pessoa=" + pessoa +
                '}';
    }
}
