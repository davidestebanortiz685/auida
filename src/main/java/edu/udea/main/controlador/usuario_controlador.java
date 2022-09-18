package edu.udea.main.controlador;

import edu.udea.main.service.GestorUsuarioInterface;
import edu.udea.main.model.ObjetoRespuesta;
import edu.udea.main.model.usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
 public class usuario_controlador {

    @Autowired

    private GestorUsuarioInterface gestorDeUsuario;
  //  private GestorDeUsuarioLIST gestorDeUsuario;
        //= new gestor_de_usuario();

    @GetMapping("/usuarios")
   // public ResponseEntity<ArrayList<usuario>> getUsuario() {
    public ResponseEntity<List<usuario>> getUsuario() {
        return new ResponseEntity<>(gestorDeUsuario.getUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/usuario")

    public ResponseEntity<Object> getUsuarios(@RequestParam String id) {

        try {
            usuario usuario = gestorDeUsuario.getusuario(id);
            return new ResponseEntity<>(usuario, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @GetMapping("/usuario/{id}")

    public ResponseEntity<String> getUsuariospath(@PathVariable String id) {
        return new ResponseEntity<>(id, HttpStatus.OK);

    }

    @PostMapping("/usuario")
    public ResponseEntity<String> postusuario(@RequestBody usuario usuario_parametro) {
        try {
            String mensaje = gestorDeUsuario.setusuario(usuario_parametro);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/usuario/{id}")
    public ResponseEntity<ObjetoRespuesta> putUsuario(@RequestBody usuario usuario_update,@PathVariable String id){
        try {
            usuario usuario_bdts = gestorDeUsuario.updateUsuarioAll(usuario_update, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualizacion existosa",usuario_bdts),HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage() ,null), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PatchMapping("/usuario/{id}")
    public ResponseEntity<ObjetoRespuesta> patchUsuario(@RequestBody usuario usuario_update, @PathVariable String id){
        try {
            usuario usuario_bdts = gestorDeUsuario.updateUsuario(usuario_update, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualizacion existosa",usuario_bdts),HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage() ,null), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<ObjetoRespuesta> deleteUsuario(@PathVariable String id){

        try {
            String mensaje = gestorDeUsuario.deleteUsuario(id);

            return new ResponseEntity<>(new ObjetoRespuesta(mensaje,null),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }





}