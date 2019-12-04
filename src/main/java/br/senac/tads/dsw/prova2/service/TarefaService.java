package br.senac.tads.dsw.prova2.service;

import br.senac.tads.dsw.prova2.Tarefa;
import br.senac.tads.dsw.prova2.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;


    public List<Tarefa> buscar() {
        return repository.findAll();
    }

    public void atualizar(Tarefa tarefa, Integer idTarefa) {
        Tarefa tarefaDb = repository.findById(idTarefa).orElse(null);
        tarefaDb.setNome(tarefa.getNome());
        tarefaDb.setResponsavel(tarefa.getResponsavel());
        repository.save(tarefaDb);
    }

    public Tarefa burcarPorId(Integer idTarefa) {
        return repository.findById(idTarefa).orElse(null);
    }
}
