package br.com.alura.forum.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.modelo.Topico;

public class TopicoDto {
    private long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    public TopicoDto(Topico topico){
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
    }

    public long getId(){
        return this.id;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getMensagem(){
        return this.mensagem;
    }

    public LocalDateTime getDataCriacao(){
        return this.dataCriacao;
    }

    //convertend topicos em dto
    public static List<TopicoDto> converter(List<Topico> topicos){
        //percorrendo list de topicos, criando TopicoDto e armazanando em uma lista
        return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
    }
        
}
