package com.surftracker.controller;

import com.surftracker.dtos.LoginRequest;
import com.surftracker.dtos.LoginResponse;
import com.surftracker.entity.Usuario;
import com.surftracker.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        if (request.getLogin() == null || request.getPassword() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Debe ingresar login y password.");
        }

        Optional<Usuario> usuarioOptional = usuarioRepository.login(
                request.getLogin(),
                request.getPassword()
        );

        if (usuarioOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Credenciales incorrectas.");
        }

        Usuario usuario = usuarioOptional.get();

        String rol = usuario.getRol();

        if (rol == null || rol.isBlank()) {
            rol = "CLIENTE";
        }

        String tokenPlano = usuario.getLogin() + ":" + usuario.getPassword();

        String token = Base64.getEncoder()
                .encodeToString(tokenPlano.getBytes(StandardCharsets.UTF_8));

        LoginResponse response = new LoginResponse(
                usuario.getIdUsuario(),
                usuario.getNombres(),
                usuario.getApellidos(),
                usuario.getLogin(),
                usuario.getCorreo(),
                rol,
                token
        );

        return ResponseEntity.ok(response);
    }
}