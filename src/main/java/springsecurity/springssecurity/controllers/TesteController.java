package springsecurity.springssecurity.controllers;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springsecurity.springssecurity.entity.Usuario;
import springsecurity.springssecurity.repository.UsuarioRepository;
import springsecurity.springssecurity.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping( value = "/teste")
public class TesteController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;

//    @GetMapping
//    @PreAuthorize("hasRole('USER')")
//    public String teste (){
//        return "<h1 style: color: red;> teste <h1>";
//    }

    @PostMapping ("/cadastrar")
    public ResponseEntity cadastrar (@RequestBody Usuario usuario){

        String senhaEncriptada = new BCryptPasswordEncoder().encode(usuario.getPassword());

            this.usuarioRepository.save(usuario);
            return ResponseEntity.ok().build();
    }

    @GetMapping
//    @PreAuthorize("hasRole('USER')")
    public String acessoUsuario (){
        return "<h1> Autenticação executada </h1>";
    }
    @GetMapping ("/livre")
    public String testando (){
        return "<h1> Rota Livre </h1>";
    }

}
