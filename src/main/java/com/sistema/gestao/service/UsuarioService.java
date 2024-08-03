package com.sistema.gestao.service;


import com.sistema.gestao.model.Usuario;
import com.sistema.gestao.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNome(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return User.withUsername(usuario.getNome())
                .password(usuario.getSenha())
                .roles(usuario.getPapel())
                .build();
    }

	public Object listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario encontrarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deletar(Long id) {
		// TODO Auto-generated method stub
		
	}
}
