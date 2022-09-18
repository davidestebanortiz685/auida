package edu.udea.main.repositorio;

import edu.udea.main.model.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<usuario,String> {
    @Query("UPDATE usuario u SET u.nombre= :nombre, u.password= :password WHERE u.nombre_usuario= :id")
    public int update(String nombre, String password, String id);



}
