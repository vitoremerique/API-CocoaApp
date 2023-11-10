package com.api.cocoa.service.impl;

import com.api.cocoa.user.Usuario;
import com.api.cocoa.DTO.UsuarioDTO;
import com.api.cocoa.record.RequestUser;

import java.util.List;

public interface UserServiceInterface {



     Usuario register(RequestUser user);


     void deleteByid(Long id);

    List<Usuario> getAll();

     Usuario findById(Long id);

     boolean usuarioExistente (Long id);

     Usuario atualizar(RequestUser user);

     Usuario findByIduser(Long id);



    Usuario findByName(String nome);





}
