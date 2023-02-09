package com.pc.springboot.projeto_springboot.api.controller;

import com.pc.springboot.projeto_springboot.domain.exception.EnderecoNaoEncontraException;
import com.pc.springboot.projeto_springboot.domain.exception.NegocioExeption;
import com.pc.springboot.projeto_springboot.domain.model.Endereco;
import com.pc.springboot.projeto_springboot.domain.model.Pessoa;
import com.pc.springboot.projeto_springboot.domain.repository.PessoaRepository;
import com.pc.springboot.projeto_springboot.domain.service.CadastroPessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository  pessoaRepository;

    @Autowired
    private CadastroPessoaService cadastroPessoa;

    @GetMapping
    public List<Pessoa> listar(){
        return pessoaRepository.findAll();
    }

    @GetMapping("{id}")
    public Pessoa buscar(@PathVariable Long id){
        return cadastroPessoa.buscarOuFalhar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa adicionar(@RequestBody Pessoa pessoa){
        try{
            return cadastroPessoa.salvar(pessoa);
        } catch (EnderecoNaoEncontraException e){
            throw new NegocioExeption(e.getMessage(), e);
        }

    }

    @PutMapping("{id}")
    public Pessoa atualizar(@PathVariable Long id, @RequestBody Pessoa pessoa){
        Pessoa pessoaAtual = cadastroPessoa.buscarOuFalhar(id);

        BeanUtils.copyProperties(pessoa, pessoaAtual,"id");

        try{
            return cadastroPessoa.salvar(pessoaAtual);
        } catch (EnderecoNaoEncontraException e){
            throw new NegocioExeption(e.getMessage(), e);
        }
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        cadastroPessoa.excluir(id);
    }








}
