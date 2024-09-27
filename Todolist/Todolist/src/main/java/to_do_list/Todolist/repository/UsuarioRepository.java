package to_do_list.Todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import to_do_list.Todolist.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{


}