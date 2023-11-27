package com.api.cocoa.service.impl;

import com.api.cocoa.record.AlterPassword;
import com.api.cocoa.user.Usuario;
import com.api.cocoa.record.RequestUser;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface UserServiceInterface {



     Usuario register(RequestUser user);




    void deleteByid(Long id);

    List<Usuario> getAll();

     Usuario findById(Long id);



     Usuario atualizar(AlterPassword user);




    Usuario findByName(String nome);





}
