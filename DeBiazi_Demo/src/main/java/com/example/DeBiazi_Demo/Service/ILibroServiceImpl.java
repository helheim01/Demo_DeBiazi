package com.example.DeBiazi_Demo.Service;

import com.example.DeBiazi_Demo.Entity.Libro;
import com.example.DeBiazi_Demo.Repository.BaseRepository;
import com.example.DeBiazi_Demo.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ILibroServiceImpl extends IBaseServiceImpl<Libro, Long> implements ILibroService{
    @Autowired
    private LibroRepository libroRepository;

    public ILibroServiceImpl(BaseRepository<Libro, Long> baseRepository, LibroRepository libroRepository) {
        super(baseRepository);
        this.libroRepository = libroRepository;
    }
}
