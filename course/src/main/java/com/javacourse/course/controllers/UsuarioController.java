package com.javacourse.course.controllers;

import com.javacourse.course.dao.UsuarioDao;
import com.javacourse.course.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario= new Usuario();
        usuario.setId(id);
        usuario.setNombre("Jim");
        usuario.setApellido("Paz");
        usuario.setTelefono("99887766");
        usuario.setEmail("ejemplo@gmail.com");
        usuario.setPassword("123456");

        return usuario;
    }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(){
       return usuarioDao.getUsuarios();
    }
    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registerUsuarios(@RequestBody Usuario usuario){
        usuarioDao.register(usuario);
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id){
        Usuario usuario= new Usuario();
        usuarioDao.eliminar(id);
    }





    @RequestMapping(value= "usuario1235")
    public Usuario modificar(){
        Usuario usuario= new Usuario();
        usuario.setNombre("Jim");
        usuario.setApellido("Paz");
        usuario.setTelefono("99887766");
        usuario.setEmail("ejemplo@gmail.com");
        usuario.setPassword("123456");

        return usuario;
    }
    @RequestMapping(value= "usuario1020")
    public Usuario buscar(){
        Usuario usuario= new Usuario();
        usuario.setNombre("Jim");
        usuario.setApellido("Paz");
        usuario.setTelefono("99887766");
        usuario.setEmail("ejemplo@gmail.com");
        usuario.setPassword("123456");

        return usuario;
    }

}
