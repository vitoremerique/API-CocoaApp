package com.api.cocoa.service.impl;

import com.api.cocoa.model.Usuario;
import com.api.cocoa.DTO.UsuarioDTO;

import java.util.List;

public interface UserServiceInterface {



     UsuarioDTO register(UsuarioDTO usuarioDTO);


     void deleteByid(Long id);

     List<Usuario> getAll();

     UsuarioDTO findById(Long id);

     boolean usuarioExistente (Long id);

     Usuario atualizar(Long id, Usuario user);

     Usuario findByIduser(Long id);




}
