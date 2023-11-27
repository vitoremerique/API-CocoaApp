package com.api.cocoa.controller;


import com.api.cocoa.record.AlterPassword;
import com.api.cocoa.record.LoginRequest;
import com.api.cocoa.record.RequestUserDelete;
import com.api.cocoa.user.Usuario;

import com.api.cocoa.record.RequestUser;
import com.api.cocoa.service.impl.UserServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserServiceInterface userService;







    @GetMapping
    @Operation(summary = "Retorna todos os usuários do banco")
    public ResponseEntity<List<Usuario>> getAll(){
        List<Usuario> usuarios = userService.getAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna o usuário especificado através do id")
    public ResponseEntity<Usuario> findById( @PathVariable Long id){
        var usuario = userService.findById(id);

        return ResponseEntity.ok(usuario);
    }


    @PostMapping
    @Operation(summary = "Cria usuário no banco de dados com sua determinadas informações")
    public ResponseEntity<Usuario> save(@RequestBody RequestUser usuario){


        var user = userService.register(usuario);
        URI location  = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(location).body(user);
    }


    @DeleteMapping
    @Operation(summary = "Deleta usuário através do id")
    public ResponseEntity<Usuario> DeleteUser(@RequestBody RequestUserDelete user){
       Usuario u = userService.findByName(user.name());
        if(u.getName().equals(user.name()) && u.getPassword().equals(user.password()) && u.getEmail().equals(user.email())){
           userService.deleteByid(u.getId());
       }

    return ResponseEntity.ok().build();
    }


    @PutMapping
    @Operation(summary = "Altera dados de ususário através do id")
    public ResponseEntity<Usuario> update(@RequestBody AlterPassword userUpdate){

        var update = userService.atualizar(userUpdate);

        return ResponseEntity.ok(update);

    }




}
