package com.surftracker.config;

import com.surftracker.entity.Usuario;
import com.surftracker.repository.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                        // Endpoints públicos
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers("/api/clientes/registro").permitAll()
                        .requestMatchers("/api/usuarios/registrarUsuario").permitAll()
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                        // Administración de usuarios, roles y opciones
                        .requestMatchers("/api/usuarios/**").hasRole("ADMIN")
                        .requestMatchers("/api/roles/**").hasRole("ADMIN")
                        .requestMatchers("/api/opciones/**").hasRole("ADMIN")
                        .requestMatchers("/usuario-has-rol/**").hasRole("ADMIN")
                        .requestMatchers("/rol-has-opcion/**").hasRole("ADMIN")
                        .requestMatchers("/api/solicitudes-rol/**").hasRole("ADMIN")

                        // Registros que solo debe hacer ADMIN
                        .requestMatchers(HttpMethod.POST, "/api/localizaciones/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/localizaciones/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/localizaciones/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST, "/api/pronosticos/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/pronosticos/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/pronosticos/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST, "/api/observacionReal/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/observacionReal/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/observacionReal/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST, "/api/reportepresicion/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/reportepresicion/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/reportepresicion/**").hasRole("ADMIN")

                        // Todo lo demás requiere iniciar sesión
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UsuarioRepository usuarioRepository) {
        return login -> {
            Usuario usuario = usuarioRepository.findByLogin(login)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + login));

            String rol = usuario.getRol();

            if (rol == null || rol.isBlank()) {
                rol = "CLIENTE";
            }

            rol = rol.replace("ROLE_", "").toUpperCase();

            return User
                    .withUsername(usuario.getLogin())
                    .password("{noop}" + usuario.getPassword())
                    .roles(rol)
                    .build();
        };
    }
}