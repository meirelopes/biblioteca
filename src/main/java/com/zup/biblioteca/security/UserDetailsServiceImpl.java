package com.zup.biblioteca.security;

import com.zup.biblioteca.model.UsuarioModel;
import com.zup.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository uSuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioModel usuarioModel = uSuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Esse usuário não foi encontrado!"));

        return usuarioModel;
    }
}
