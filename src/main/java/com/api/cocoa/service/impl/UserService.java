package com.api.cocoa.service.impl;

import com.api.cocoa.user.Usuario;
import com.api.cocoa.DTO.UsuarioDTO;
import com.api.cocoa.record.RequestUser;
import com.api.cocoa.repository.UserRepository;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class UserService implements UserServiceInterface{

    private final UserRepository userRepository;



    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Usuario register(RequestUser usuario){
        Usuario user = new Usuario(usuario);

        userRepository.save(user);
        return user;

    }



    public void deleteByid(Long id){
       userRepository.deleteById(id);

    }

    @Override
    public List<Usuario> getAll() {

        List<Usuario> getall = new ArrayList<>();
        if(!userRepository.findAll().isEmpty()){
            userRepository.findAll().forEach(usuario ->{getall.add(usuario);});
        }
        return getall;
    }

    public Usuario findByIduser(Long id) {

        var usuarioFound =  userRepository.findById(id);
        Usuario usuario = new Usuario();
        usuario.setId(usuarioFound.get().getId());
        usuario.setName(usuarioFound.get().getName());
        usuario.setEmail(usuarioFound.get().getEmail());
        usuario.setPassword(usuarioFound.get().getPassword());

        return usuario;


    }


    public Usuario findByName(String nome) {
    return userRepository.findByName(nome);

    }




    @Override
    public Usuario findById(Long id) {
        Usuario user = new Usuario();
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


    public Usuario atualizar(RequestUser user) {
        Usuario usuario = userRepository.getReferenceById(user.id());
        usuario.setName(user.name());
        usuario.setEmail(user.email());
        usuario.setPassword(user.password());


        return userRepository.save(usuario);
    }






}
