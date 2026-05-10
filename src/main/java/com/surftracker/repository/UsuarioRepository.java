package com.surftracker.repository;

import com.surftracker.entity.Opcion;
import com.surftracker.entity.Rol;
import com.surftracker.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Query("SELECT u FROM Usuario u WHERE u.login = :login AND u.password = :password")
    Optional<Usuario> login(@Param("login") String login, @Param("password") String password);

    @Query("SELECT p FROM Opcion p, RolHasOpcion ro, Rol r, UsuarioHasRol ur WHERE p.idOpcion = ro.opcion.idOpcion AND ro.rol.idRol = r.idRol AND r.idRol = ur.rol.idRol AND ur.usuario.idUsuario = :idUsuario")
    List<Opcion> traerEnlacesDeUsuario(@Param("idUsuario") Integer idUsuario);

    @Query("SELECT DISTINCT r FROM Rol r, UsuarioHasRol ur WHERE r.idRol = ur.rol.idRol AND ur.usuario.idUsuario = :idUsuario")
    List<Rol> traerRolesDeUsuario(@Param("idUsuario") int idUsuario);

    Optional<Usuario> findByLogin(String login);

}
