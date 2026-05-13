package com.example.tb1.Service;

import com.example.tb1.Entity.ReportePrecision;
import com.example.tb1.Repository.ReportePrecisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportePrecisionServiceImpl implements ReportePrecisionService {

    @Autowired
    private ReportePrecisionRepository repository;

    @Override
    public ReportePrecision inserta(ReportePrecision reporte) {
        return repository.save(reporte);
    }

    @Override
    public List<ReportePrecision> listaTodos() {
        return repository.findAll();
    }

    @Override
    public List<ReportePrecision> listaPorFechaReporte(LocalDate fecha) {
        return repository.findByFechaReporte(fecha);
    }

    @Override
    public List<ReportePrecision> listaPorMinimaPrecision(double precisionMinima) {
        return repository.findByPorcentajePrecisionGreaterThanEqual(precisionMinima);
    }

    @Override
    public List<ReportePrecision> listaPorPronostico(int idPronostico) {
        return repository.findByPronosticoIdPronostico(idPronostico);
    }
}