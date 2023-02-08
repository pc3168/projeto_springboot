package com.pc.springboot.projeto_springboot.domain.service;

import com.pc.springboot.projeto_springboot.domain.model.Endereco;
import com.pc.springboot.projeto_springboot.domain.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroEndereco {

    @Autowired
    private EnderecoRepository enderecoRepository;


    public Endereco salvar(Endereco endereco){
        return  enderecoRepository.save(endereco);
    }

    public Endereco buscarPorNome(String nome){
        return enderecoRepository.findByNome(nome);
    }

    public void remover(Long id){
        enderecoRepository.deleteById(id);
    }



}
