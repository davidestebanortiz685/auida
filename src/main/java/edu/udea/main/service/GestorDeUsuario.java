package edu.udea.main.service;

import edu.udea.main.model.usuario;
import edu.udea.main.repositorio.UsuarioRepositorio;
import edu.udea.main.service.GestorUsuarioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class GestorDeUsuario implements GestorUsuarioInterface {
    @Autowired
    private UsuarioRepositorio repositorio;

    @Override
    public List<usuario> getUsuarios() {
        return repositorio.findAll();
    }

    @Override
    public usuario getusuario(String id) throws Exception {
        Optional <usuario> usariobd= repositorio.findById(id);
        if(usariobd.isPresent()) {
            return usariobd.get();
        }
            throw new Exception("Usuario no existe") ;


    }

    @Override
    public String setusuario(usuario usuario_parametro) {
         repositorio.save(usuario_parametro);
         return "Usuario creado exitosamente";
    }

    @Override
    public usuario updateUsuarioAll(usuario usuario_update, String id) throws Exception {
          repositorio.update(usuario_update.getNombre(),usuario_update.getPassword(), id);
    return getusuario(id);
    }

    @Override
    public usuario updateUsuario(usuario usuario_update, String id) {
        return null;
    }

    @Override
    public String deleteUsuario(String id) {
        repositorio.deleteById(id);
        return "Usuario eliminado exitosamente";
    }
}
