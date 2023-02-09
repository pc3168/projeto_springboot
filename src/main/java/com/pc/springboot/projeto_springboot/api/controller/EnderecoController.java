package com.pc.springboot.projeto_springboot.api.controller;

import com.pc.springboot.projeto_springboot.domain.model.Endereco;
import com.pc.springboot.projeto_springboot.domain.repository.EnderecoRepository;
import com.pc.springboot.projeto_springboot.domain.service.CadastroEnderecoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private CadastroEnderecoService cadastroEndereco;


    @GetMapping
    public List<Endereco> listar(){
        return enderecoRepository.findAll();
    }

    @GetMapping("{nome}")
    public Endereco buscarPorNome(String nome){
        return enderecoRepository.findByNome(nome);
    }

    @GetMapping("{id}")
    public Endereco buscar(@PathVariable Long id){
        return cadastroEndereco.buscarOuFalhar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco adicionar(@RequestBody Endereco endereco){
        return cadastroEndereco.salvar(endereco);
    }

    @PutMapping("{id}")
    public Endereco atualizar(@PathVariable Long id, @RequestBody Endereco endereco){
        Endereco enderecoAtual = cadastroEndereco.buscarOuFalhar(id);

        BeanUtils.copyProperties(endereco, enderecoAtual, "id");
        return cadastroEndereco.salvar(enderecoAtual);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        cadastroEndereco.excluir(id);
    }



}
