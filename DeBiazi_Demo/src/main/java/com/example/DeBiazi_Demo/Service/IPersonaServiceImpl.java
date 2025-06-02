package com.example.DeBiazi_Demo.Service;
import com.example.DeBiazi_Demo.Entity.Libro;
import com.example.DeBiazi_Demo.Entity.Localidad;
import com.example.DeBiazi_Demo.Entity.Persona;
import com.example.DeBiazi_Demo.Repository.BaseRepository;
import com.example.DeBiazi_Demo.Repository.LibroRepository;
import com.example.DeBiazi_Demo.Repository.LocalidadRepository;
import com.example.DeBiazi_Demo.Repository.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IPersonaServiceImpl extends IBaseServiceImpl<Persona, Long> implements IPersonaService {
    //Tuve que poner esto, porque me daba problemas en la relacion N:1, y como en el video no hace todas las tablas, asumo q es necesario
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private LocalidadRepository localidadRepository;

    @Autowired
    private LibroRepository libroRepository;
    public IPersonaServiceImpl(BaseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
    }

    //De esta manera, tengo q crear una localidad, luego la persona, y cuando creo que la persona, tengo que crear también el domicilio que tenga el id de la localidad creada
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


// Comento el codigo que me hizo hacer el pelotudo del video, porque me hizo hacer toda esta garcha para despues borrarlo

//    @Override
//    @Transactional
//    public List<Persona> findAll() throws Exception {
//        try {
//            List<Persona>entities=personaRepository.findAll();
//            return entities;
//        }catch (Exception e){
//            throw new Exception((e.getMessage()));
//        }
//
//    }
//
//    @Override
//    @Transactional
//    public Persona findById(Long id) throws Exception {
//        try {
//            Optional<Persona>entityOptional=personaRepository.findById(id);
//            return entityOptional.get();
//        }catch (Exception e){
//            throw new Exception((e.getMessage()));
//        }
//
//    }
//
//    @Override
//    @Transactional
//    public Persona save(Persona entity) throws Exception {
//        try {
//            entity=personaRepository.save(entity);
//            return entity;
//        }catch (Exception e){
//            throw new Exception((e.getMessage()));
//        }
//    }
//
//    @Override
//    @Transactional
//    public Persona update(Long id, Persona entity) throws Exception {
//        try {
//            Optional<Persona>entityOptional=personaRepository.findById(id);
//            Persona persona=entityOptional.get();
//            persona=personaRepository.save(persona);
//            return persona;
//        }catch (Exception e){
//            throw new Exception((e.getMessage()));
//        }
//    }
//
//    @Override
//    @Transactional
//    public boolean delete(Long id) throws Exception {
//        try {
//            if (personaRepository.existsById(id)){
//                personaRepository.deleteById(id);
//                return true;
//            }else{
//                throw new Exception();
//            }
//        }catch (Exception e){
//            throw new Exception((e.getMessage()));
//        }
//    }
