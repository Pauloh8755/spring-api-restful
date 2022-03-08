package br.com.alura.forum.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;


@RestController
//definindo mapeamento do  request
@RequestMapping("/topicos")
public class TopicosController {

    //ejetando repository
    @Autowired
    private TopicoRepository topicoRepository;

    //ejetando repository
    @Autowired
    private CursoRepository cursoRepository;
    
    //definindo verbo http
    @GetMapping
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

    //definindo verbo http
    @PostMapping
    //@requestBody para indicar que os parametros serão recebidos pelo body do request
    //ResponseEntity<> para definir um response personalizado
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody TopicoForm form, UriComponentsBuilder uriBuilder){
        //converter form em topico
        Topico topico = form.converter(cursoRepository);
        //gravando topico no banco de dados
        topicoRepository.save(topico);
        /*Response 201: Ao enviar um codigo 201 ao cliente, devemos devolver 2 elementos.
         *  1° cabeçalho http chamado location com a url do recurso criado
         *  2° Uma representação desse recurso no body do response 
         */
        //Criando uri por meio do uriBuilder
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri)
    }
}
