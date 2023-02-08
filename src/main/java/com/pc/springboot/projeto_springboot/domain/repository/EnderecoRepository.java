package com.pc.springboot.projeto_springboot.domain.repository;

import com.pc.springboot.projeto_springboot.domain.model.Endereco;
import com.pc.springboot.projeto_springboot.domain.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query("From Endereco where nome like %:nome%")
    Endereco findByNome(String nome);
}
