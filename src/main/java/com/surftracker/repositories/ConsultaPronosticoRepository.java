package com.surftracker.repositories;

import com.surftracker.entities.ConsultaPronostico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultaPronosticoRepository extends JpaRepository<ConsultaPronostico,Integer> {


    List<ConsultaPronostico>
    findByIdUsuario(Integer usuario);

}
