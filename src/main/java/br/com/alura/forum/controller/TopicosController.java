package br.com.alura.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;

@RestController
public class TopicosController {
    //definindo mapeamento do  request
    @RequestMapping("/topicos")
    //Indicando que o retorno do método deve ser serializado e devolvido no corpo da resposta
    @ResponseBody
    public List<TopicoDto> lista(){
        Topico topico = new Topico("Dúvida", "Dúvida com Spring", new Curso("SpringBoot", "Programação"));
        return TopicoDto.converter(Arrays.asList(topico, topico, topico));
    }
}
