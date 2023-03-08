package com.pc.springboot.projeto_springboot.domain.service;

import com.pc.springboot.projeto_springboot.domain.exception.EnderecoNaoEncontraException;
import com.pc.springboot.projeto_springboot.domain.exception.EntidadeEmUsoException;
import com.pc.springboot.projeto_springboot.domain.exception.NegocioExeption;
import com.pc.springboot.projeto_springboot.domain.exception.PessoaNaoEncontraException;
import com.pc.springboot.projeto_springboot.domain.model.Endereco;
import com.pc.springboot.projeto_springboot.domain.model.Pessoa;
import com.pc.springboot.projeto_springboot.domain.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CadastroPessoaService {

    @Autowired
    private PessoaRepository repositoryPessoa;

    @Autowired
    private CadastroEnderecoService cadastroEndereco;


    public Pessoa salvar(Pessoa pessoa){
        List<Endereco> listaEnderecos = pessoa.getEnderecos();
        List<Endereco> addEnderecosValidos = new ArrayList<>();

        for (Endereco end : listaEnderecos) {
            Endereco endereco = cadastroEndereco.buscarOuFalhar(end.getId());
            addEnderecosValidos.add(endereco);
        }

        pessoa.setEnderecos(addEnderecosValidos);

        return repositoryPessoa.save(pessoa);

    }

    public Pessoa buscarOuFalhar(Long id){
        return repositoryPessoa.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontraException(id));
    }

    public void excluir(Long id){
        try{
            repositoryPessoa.deleteById(id);
        }catch (EmptyResultDataAccessException e ){
            throw new PessoaNaoEncontraException(id);
        }catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(
                    String.format("Pessoa de código %d não pode ser removido, pois está em uso", id));
        }
    }

}
