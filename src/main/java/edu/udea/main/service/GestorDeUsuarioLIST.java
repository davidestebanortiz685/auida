package edu.udea.main.service;

import edu.udea.main.model.usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GestorDeUsuarioLIST{

    private ArrayList<usuario> usuarios;

    public GestorDeUsuarioLIST(){

        this.usuarios=new ArrayList<>();


       this.usuarios.add(new usuario("david ortiz","davidortiz685","osovanidoso"));

        this.usuarios.add(new usuario("Alejandro noguera","RAMA123","mercenario"));
    }
    public usuario getusuario(String nombreUsuario) throws  Exception{
        for (usuario usuario: this.usuarios){
             if(usuario.getNombre_usuario().equals(nombreUsuario))
              {
                 return usuario;
}
        }
        throw new Exception("Usuario no existe");
    }

    public String setusuario(usuario usuario_parametro) throws Exception {

      try {
          //Consulta de existencia del usuario
            getusuario(usuario_parametro.getNombre_usuario());
      } catch (Exception e) {
          //Creacion del usuario
        this.usuarios.add(usuario_parametro);
        return "Creacion del usuario exitosa";
      }
      //Error si el usuario ya existe
        throw new Exception("Usuario existe");
}




    public usuario updateUsuario(usuario usuario_update, String id) throws Exception {
    try {
       usuario usuario_bdts = getusuario(id);

       if(usuario_update.getNombre_usuario() != null && !usuario_update.getNombre_usuario().equals("")){
           usuario_bdts.setNombre_usuario(usuario_update.getNombre_usuario());
       }

       if(usuario_update.getNombre() != null && !usuario_update.getNombre().equals("")) {
           usuario_bdts.setNombre(usuario_update.getNombre());
       }
       if(usuario_update.getPassword() != null && !usuario_update.getPassword().equals("")) {
           usuario_bdts.setPassword(usuario_update.getPassword());
       }

       return usuario_bdts;

    } catch (Exception e) {
        throw new Exception("Usuario no existe, fallo actualizacion");
    }


}
    public usuario updateUsuarioAll(usuario usuario_update,String id) throws Exception {
        try {
            usuario  usuario_bdts  = getusuario(id);

            usuario_bdts.setNombre_usuario(usuario_update.getNombre_usuario());
            usuario_bdts.setNombre(usuario_update.getNombre());
            usuario_bdts.setPassword(usuario_update.getPassword());

            return usuario_bdts;


        } catch (Exception e) {
            throw new Exception("Usuario no existe, fallo actualizacion de datos");
        }
    }
    public ArrayList<usuario> getUsuarios() {
        return usuarios;
    }


    public void setUsuarios(ArrayList<usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String deleteUsuario(String id) throws Exception {
        try {
            usuario usuario = getusuario(id);

            this.usuarios.remove(usuario);

            return "Eliminado exitoso";
        } catch (Exception e) {
            throw new Exception("Usuario NO Existe para Eliminar");
        }

    }
}

