package to_do_list.Todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import to_do_list.Todolist.models.Usuario;
import to_do_list.Todolist.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> listarUsuariosPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public Usuario salvarUsuario(Usuario novoUsuario){
        usuarioRepository.save(novoUsuario);

        return novoUsuario;
    }

    public void deletarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
}
