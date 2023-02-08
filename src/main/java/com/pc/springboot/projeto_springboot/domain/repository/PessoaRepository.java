package com.pc.springboot.projeto_springboot.domain.repository;

import com.pc.springboot.projeto_springboot.domain.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


}
