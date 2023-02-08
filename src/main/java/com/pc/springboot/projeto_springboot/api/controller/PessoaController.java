package com.pc.springboot.projeto_springboot.api.controller;

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
@RequestMapping("/pessoa")
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
    public Pessoa buscar(Long id){
        return pessoaRepository.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa adicionar(@RequestBody Pessoa pessoa){
        return cadastroPessoa.salvar(pessoa);
    }

    @PutMapping("{id}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @RequestBody Pessoa pessoa){
        Optional<Pessoa> pessoaAtual = pessoaRepository.findById(id);

        if (pessoaAtual.isPresent()){
            BeanUtils.copyProperties(pessoa, pessoaAtual.get(),"id");
            Pessoa pessoaSalva = cadastroPessoa.salvar(pessoaAtual.get());
            return ResponseEntity.ok(pessoaSalva);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(Long id){
        cadastroPessoa.excluir(id);
    }








}
