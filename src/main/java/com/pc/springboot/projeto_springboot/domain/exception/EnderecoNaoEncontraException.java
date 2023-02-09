package com.pc.springboot.projeto_springboot.domain.exception;

public class EnderecoNaoEncontraException extends EntidadeNaoEncontraException{


    public EnderecoNaoEncontraException(String mensagem) {
        super(mensagem);
    }

    public EnderecoNaoEncontraException(Long id) {
        this(String.format("Não existe um cadastro de endereço com o código %d",id));
    }
}
