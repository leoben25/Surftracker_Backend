package com.example.tb1.Service;

import com.example.tb1.Entity.Preferencia;
import com.example.tb1.Repository.PreferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenciaServiceImpl implements PreferenciaService {

    @Autowired
    private PreferenciaRepository repository;

    @Override
    public Preferencia inserta(Preferencia preferencia) {
        return repository.save(preferencia);
    }

    @Override
    public List<Preferencia> listaTodos() {
        return repository.findAll();
    }

    @Override
    public List<Preferencia> listaPorUsuario(int idUsuario) {
        return repository.findByIdUsuario(idUsuario);
    }

    @Override
    public List<Preferencia> listaPorTema(String tema) {
        return repository.findByTema(tema);
    }

    @Override
    public List<Preferencia> listaPorNotificacionesActivas(boolean recibirAlertas) {
        return repository.findByRecibirAlertas(recibirAlertas);
    }
}