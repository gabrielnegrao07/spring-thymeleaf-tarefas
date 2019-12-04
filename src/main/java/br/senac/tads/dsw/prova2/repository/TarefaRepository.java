package br.senac.tads.dsw.prova2.repository;

import br.senac.tads.dsw.prova2.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
}
