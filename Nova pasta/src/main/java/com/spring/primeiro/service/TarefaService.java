package com.spring.primeiro.service;

import com.spring.primeiro.model.Tarefa;
import com.spring.primeiro.repository.TarefaRepository;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> buscarTodos(){
        return tarefaRepository.findAll();
    }

    public Tarefa inserirTarefa(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    public Tarefa buscarId(int id){
        Optional<Tarefa> consulta = tarefaRepository.findById(id);
        if(consulta.isPresent()){
            return consulta.get();
        }else{
            throw new RuntimeException("Tarefa nao encontrada");
        }
    }

    public Tarefa alterarStatus(int id){
         Tarefa tInteresse = buscarId(id);
            tInteresse.setStatus("Fazendo");
            return tarefaRepository.save(tInteresse);
    }

    public Tarefa alterarConcluida(int id){
        Tarefa tInteresse = buscarId(id);
        tInteresse.setStatus("Concluida");
        return tarefaRepository.save(tInteresse);
    }
}
