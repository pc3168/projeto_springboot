package com.pc.springboot.projeto_springboot.domain.service;

import com.pc.springboot.projeto_springboot.domain.model.Pessoa;
import com.pc.springboot.projeto_springboot.domain.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroPessoaService {

    @Autowired
    private PessoaRepository repositoryPessoa;

    public Pessoa salvar(Pessoa pessoa){
        return repositoryPessoa.save(pessoa);
    }

    public void excluir(Long id){
        repositoryPessoa.deleteById(id);
    }

}
