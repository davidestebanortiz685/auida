package edu.udea.main.service;

import edu.udea.main.model.usuario;

import java.util.List;

public interface GestorUsuarioInterface {
    public List<usuario> getUsuarios();

    public usuario getusuario(String id) throws Exception;

    public String setusuario(usuario usuario_parametro) throws Exception;

    public usuario updateUsuarioAll(usuario usuario_update, String id) throws Exception;

    public usuario updateUsuario(usuario usuario_update, String id) throws Exception;

    public String deleteUsuario(String id) throws Exception;
}
