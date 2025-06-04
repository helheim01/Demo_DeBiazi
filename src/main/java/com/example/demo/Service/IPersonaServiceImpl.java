package com.example.demo.Service;

import com.example.demo.Entity.Persona;
import com.example.demo.Entity.Libro;
import com.example.demo.Entity.Localidad;
import com.example.demo.Repository.PersonaRepository;
import com.example.demo.Repository.LibroRepository;
import com.example.demo.Repository.LocalidadRepository;
import com.example.demo.Repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IPersonaServiceImpl extends IBaseServiceImpl<Persona, Long> implements IPersonaService {

    //Esto no está en el video, pero quise hacerlo para poder ingresar todo en la base de datos, y sin esto, no pude hacerlo.
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
            // Cargo la localidad
            if (persona.getDomicilio() != null && persona.getDomicilio().getLocalidad() != null) {
                Long localidadId = persona.getDomicilio().getLocalidad().getId();
                Localidad localidad = localidadRepository.findById(localidadId)
                        .orElseThrow(() -> new Exception("Localidad no encontrada con id: " + localidadId));
                persona.getDomicilio().setLocalidad(localidad);
            }

            // Cargo los libros
            if (persona.getLibros() != null && !persona.getLibros().isEmpty()) {
                List<Long> libroIds = persona.getLibros().stream()
                        .map(Libro::getId)
                        .collect(Collectors.toList());

                List<Libro> libros = libroRepository.findAllById(libroIds);

                if (libros.size() != libroIds.size()) {
                    throw new Exception("Uno o más libros no encontrados con los ids enviados");
                }

                persona.setLibros(libros);
            }

            // Guardo la persona
            Persona savedPersona = super.save(persona);

            // Inicialicé los libros y sus autores
            savedPersona.getLibros().forEach(libro -> libro.getAutores().size());

            return savedPersona;

        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }


    @Override
    public List<Persona> search(String filtro) throws Exception {
        try {
            return personaRepository.searchNativo(filtro);
        } catch (Exception e) {
            throw new Exception("Error al buscar personas: " + e.getMessage(), e);
        }
    }

    @Override
    public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
        try {
            return personaRepository.searchNativo(filtro, pageable);
        } catch (Exception e) {
            throw new Exception("Error al buscar personas paginadas: " + e.getMessage(), e);
        }
    }

}