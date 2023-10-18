package com.api.cocoa.service.impl;

import com.api.cocoa.model.Usuario;
import com.api.cocoa.DTO.UsuarioDTO;
import com.api.cocoa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.beans.Encoder;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.crossstore.ChangeSetPersister.*;

@Service
public class UserService implements UserServiceInterface{

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UsuarioDTO register(UsuarioDTO usuarioDTO){
        Usuario user = new Usuario();
        user.setName(usuarioDTO.getName());
        user.setEmail(usuarioDTO.getEmail());
        user.setPassword(usuarioDTO.getPassword());
        userRepository.save(user);
        usuarioDTO.setId(user.getId());

        return usuarioDTO;

    }



    public void deleteByid(Long id){
       userRepository.deleteById(id);

    }

    @Override
    public List<Usuario> getAll() {

        List<Usuario> getall = new ArrayList<>();
        if(!userRepository.findAll().isEmpty()){
            userRepository.findAll().stream().forEach(usuario ->{getall.add(usuario);});
        }
        return getall;
    }

    public Usuario findByIduser(Long id) {
        Usuario usuario = new Usuario();
        var usuarioFound =  userRepository.findById(id);

        usuario.setId(usuarioFound.get().getId());
        usuario.setName(usuarioFound.get().getName());
        usuario.setPassword(usuarioFound.get().getPassword());
        usuario.setEmail(usuarioFound.get().getEmail());
        return usuario;


    }

    @Override
    public UsuarioDTO findById(Long id) {
        UsuarioDTO user = new UsuarioDTO();
        var dados = userRepository.findById(id);
        user.setEmail(dados.get().getEmail());
        user.setName(dados.get().getName());
        user.setPassword(dados.get().getPassword());
        user.setId(dados.get().getId());

        return user;
    }

    @Override
    public boolean usuarioExistente(Long id) {
         if(userRepository.findById(id).isPresent()){
             return true;
         }else{
             return false;
         }

    }


    public Usuario atualizar(Long id, Usuario user) {


        Usuario usuario = findByIduser(id);




        usuario.setName(user.getName());
        usuario.setEmail(user.getEmail());
        usuario.setPassword(user.getPassword());


        return userRepository.save(usuario);


    }




}
