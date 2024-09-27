package to_do_list.Todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import to_do_list.Todolist.models.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{


}
