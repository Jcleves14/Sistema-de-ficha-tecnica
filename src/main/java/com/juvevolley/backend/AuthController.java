package com.juvevolley.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Optional;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private JavaMailSender mailSender;

    // 1. ENDPOINT PARA REGISTRAR (Crea el usuario y envía el correo)
    @PostMapping("/registro")
    public String registrar(@RequestBody Usuario nuevoUsuario) {
        String token = UUID.randomUUID().toString();
        nuevoUsuario.setTokenVerificacion(token);
        nuevoUsuario.setVerificado(false);
        nuevoUsuario.setRol("ADMIN");

        usuarioRepo.save(nuevoUsuario);

        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(nuevoUsuario.getCorreo());
        mensaje.setSubject("Verifica tu cuenta en Juve Volley");
        mensaje.setText("Hola " + nuevoUsuario.getUsername() + ",\n\n"
                + "Haz clic en el siguiente enlace para activar tu cuenta de Administrador:\n"
                + "http://localhost:8081/api/auth/verificar?token=" + token);
        
        mailSender.send(mensaje);

        return "REGISTRO_EXITOSO";
    }

    // 2. ENDPOINT PARA VERIFICAR EL CLIC EN EL CORREO
    @GetMapping("/verificar")
    public String verificarCorreo(@RequestParam String token) {
        for (Usuario u : usuarioRepo.findAll()) {
            if (token.equals(u.getTokenVerificacion())) {
                u.setVerificado(true);
                u.setTokenVerificacion(null);
                usuarioRepo.save(u);
                return "<h1>¡Cuenta verificada con éxito!</h1><p>Ya puedes iniciar sesión en Juve Volley.</p>";
            }
        }
        return "<h1>Error: Enlace no válido o expirado.</h1>";
    }

    // 3. ÚNICO ENDPOINT DE LOGIN
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> credenciales) {
        String username = credenciales.get("username");
        String password = credenciales.get("password");

        Optional<Usuario> user = usuarioRepo.findByUsername(username);

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            if (!user.get().isVerificado()) {
                return "FALTA_VERIFICAR";
            }
            if (user.get().getRol().equals("ADMIN")) {
                return "EXITO";
            }
        }
        return "ERROR";
    }
}