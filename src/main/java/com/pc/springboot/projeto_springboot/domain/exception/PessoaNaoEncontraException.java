package com.pc.springboot.projeto_springboot.domain.exception;

public class PessoaNaoEncontraException extends EntidadeNaoEncontraException{

    public PessoaNaoEncontraException(String mensagem){
        super(mensagem);
    }

    public PessoaNaoEncontraException(Long id) {
        this(String.format("Não existe um cadastro de pessoa com o código %d",id));
    }
}
