package com.pc.springboot.projeto_springboot.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NegocioExeption extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public NegocioExeption(String mensagem){
        super(mensagem);
    }

    public NegocioExeption(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
