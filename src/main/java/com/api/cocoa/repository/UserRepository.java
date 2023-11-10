package com.api.cocoa.repository;

import com.api.cocoa.user.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

    Usuario findByName(String nome);
}
