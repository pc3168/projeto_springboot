package com.pc.springboot.projeto_springboot.domain.service;

import com.pc.springboot.projeto_springboot.domain.exception.EnderecoNaoEncontraException;
import com.pc.springboot.projeto_springboot.domain.exception.EntidadeEmUsoException;
import com.pc.springboot.projeto_springboot.domain.exception.EntidadeNaoEncontraException;
import com.pc.springboot.projeto_springboot.domain.model.Endereco;
import com.pc.springboot.projeto_springboot.domain.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroEnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;


    public Endereco salvar(Endereco endereco){
        return  enderecoRepository.save(endereco);
    }
    
    public Endereco buscarOuFalhar(Long id){
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new EnderecoNaoEncontraException(id));
    }


    public void excluir(Long id){
        try {
            enderecoRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(
                    String.format("Endereço de código %d não pode ser removido, pois está em uso", id));
        }catch(EmptyResultDataAccessException e){
            throw new EnderecoNaoEncontraException(id);
        }
    }



}
