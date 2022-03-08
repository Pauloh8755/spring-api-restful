package br.com.alura.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;

@RestController
public class TopicosController {

    //ejetando repository
    @Autowired
    private TopicoRepository topicoRepository;
    //definindo mapeamento do  request
    @RequestMapping("/topicos")
    //Indicando que o retorno do método deve ser serializado e devolvido no corpo da resposta
    @ResponseBody
    public List<TopicoDto> lista(String nomeCurso){
        if(nomeCurso == null){
            //utilizando jpa para listar todos os registros
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDto.converter(topicos);
        } else {
            //filtrando por atributos:
            //relacionamentoo(findByEntidaderelacionamentoAtributo)
            //atributo da propri entidade (findByAtributo)
            List<Topico> topicos = topicoRepository.findByCurso_Nome(nomeCurso);
            return TopicoDto.converter(topicos);
        }
        
    }
}
