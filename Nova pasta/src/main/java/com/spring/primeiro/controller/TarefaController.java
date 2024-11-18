package com.spring.primeiro.controller;

import com.spring.primeiro.model.Tarefa;
import com.spring.primeiro.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;



    @PostMapping
    public Tarefa inserirTarefa(@RequestBody Tarefa tarefa){
       return tarefaService.inserirTarefa(tarefa);
    }

    @GetMapping
    public List<Tarefa> listaTarefas(){
        return tarefaService.buscarTodos();
    }
    @GetMapping("/{id}")
    public Tarefa listaPorId(@PathVariable int id){
        return tarefaService.buscarId(id);
    }

    @PutMapping("/{id}/mover")
    public Tarefa alterarStatus (@PathVariable int id){
        return tarefaService.alterarStatus(id);
    }
}

