package com.example.demo.Service;

import com.example.demo.Entity.Libro;
import com.example.demo.Repository.BaseRepository;
import com.example.demo.Repository.LibroRepository;
import org.springframework.stereotype.Service;

@Service
public class ILibroServiceImpl extends IBaseServiceImpl<Libro, Long> implements ILibroService {

    private final LibroRepository libroRepository;

    public ILibroServiceImpl(BaseRepository<Libro, Long> baseRepository,
                             LibroRepository libroRepository) {
        super(baseRepository);
        this.libroRepository = libroRepository;
    }
}
