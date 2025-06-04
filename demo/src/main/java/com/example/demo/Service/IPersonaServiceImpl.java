package com.example.demo.Service.impl;

import com.example.demo.Entity.Persona;
import com.example.demo.Entity.Libro;
import com.example.demo.Entity.Localidad;
import com.example.demo.Repository.PersonaRepository;
import com.example.demo.Repository.LibroRepository;
import com.example.demo.Repository.LocalidadRepository;
import com.example.demo.Repository.BaseRepository;
import com.example.demo.Service.IBaseServiceImpl;
import com.example.demo.Service.IPersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IPersonaServiceImpl extends IBaseServiceImpl<Persona, Long> implements IPersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private LocalidadRepository localidadRepository;

    @Autowired
    private LibroRepository libroRepository;

    public IPersonaServiceImpl(BaseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    @Transactional
    public Persona save(Persona persona) throws Exception {
        try {
            // Cargar localidad
            if (persona.getDomicilio() != null && persona.getDomicilio().getLocalidad() != null) {
                Long localidadId = persona.getDomicilio().getLocalidad().getId();
                Localidad localidad = localidadRepository.findById(localidadId)
                        .orElseThrow(() -> new Exception("Localidad no encontrada con id: " + localidadId));
                persona.getDomicilio().setLocalidad(localidad);
            }

            // Cargar libros
            if (persona.getLibros() != null && !persona.getLibros().isEmpty()) {
                List<Long> libroIds = persona.getLibros().stream()
                        .map(libro -> libro.getId())
                        .collect(Collectors.toList());

                List<Libro> libros = libroRepository.findAllById(libroIds);

                if (libros.size() != libroIds.size()) {
                    throw new Exception("Uno o más libros no encontrados con los ids enviados");
                }
                persona.setLibros(libros);
            }

            return personaRepository.save(persona);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }
}
