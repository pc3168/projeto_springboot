package com.pc.springboot.projeto_springboot.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public abstract class EntidadeNaoEncontraException extends NegocioExeption{

    private static final long serialVersionUID = 1L;

    public EntidadeNaoEncontraException(String mensagem) {
        super(mensagem);
    }

    public EntidadeNaoEncontraException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
