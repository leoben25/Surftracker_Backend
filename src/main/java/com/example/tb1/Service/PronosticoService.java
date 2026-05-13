package com.example.tb1.Service;


import com.example.tb1.Entity.Pronostico;
import java.time.LocalDate;
import java.util.List;

public interface PronosticoService {

    public abstract Pronostico inserta(Pronostico pronostico);
    public abstract List<Pronostico> listaTodos();
    public abstract List<Pronostico> listaPorLocalizacion(int idLocalizacion);
    public abstract List<Pronostico> listaPorFecha(LocalDate fecha);
    public abstract List<Pronostico> listaPorRangoTemperaturas(double min, double max);

}