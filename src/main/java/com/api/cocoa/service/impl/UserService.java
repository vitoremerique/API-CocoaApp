package com.api.cocoa.service.impl;

import com.api.cocoa.record.AlterPassword;
import com.api.cocoa.user.Usuario;
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



    @Override
    public void deleteByid(Long id) {
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




    public Usuario atualizar(AlterPassword user) {
        Usuario usuario = userRepository.findByName(user.nome());
        if(usuario.getPassword().equals(user.senhaAntiga())){
            usuario.setEmail(usuario.getEmail());
            usuario.setName(usuario.getName());
            usuario.setPassword(user.novaSenha());
        }

        return userRepository.save(usuario);
    }






}
