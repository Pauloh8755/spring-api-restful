package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

    //busca pelo nome do curso
    List<Topico> findByCurso_Nome(String nomeCurso);

    // @Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
    // List<Topico> laodByCurseName(@Param("nomeCurso")String nomeCurso);
    
}
