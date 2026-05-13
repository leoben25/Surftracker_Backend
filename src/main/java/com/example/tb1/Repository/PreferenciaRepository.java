package com.example.tb1.Repository;

import com.example.tb1.Entity.Preferencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreferenciaRepository extends JpaRepository<Preferencia, Integer> {

    public abstract List<Preferencia> findByIdUsuario(int idUsuario);

    public abstract List<Preferencia> findByTema(String tema);

    public abstract List<Preferencia> findByRecibirAlertas(boolean recibirAlertas);

}