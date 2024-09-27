package to_do_list.Todolist.service;

import org.springframework.stereotype.Service;

import to_do_list.Todolist.models.StatusTarefa;
import to_do_list.Todolist.models.Tarefa;
import to_do_list.Todolist.repository.TarefaRepository;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Tarefa criarTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public Tarefa atualizarStatus(Long id, StatusTarefa novoStatus) {
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        tarefa.setStatus(novoStatus);
        return tarefaRepository.save(tarefa);
    }

    public void deletarTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }
}
