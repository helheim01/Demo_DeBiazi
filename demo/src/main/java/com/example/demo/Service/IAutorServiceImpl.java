package com.example.demo.Service;

import com.example.demo.Entity.Autor;
import com.example.demo.Repository.AutorRepository;
import com.example.demo.Repository.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class IAutorServiceImpl extends IBaseServiceImpl<Autor, Long> implements IAutorService {

    private final AutorRepository autorRepository;

    public IAutorServiceImpl(BaseRepository<Autor, Long> baseRepository, AutorRepository autorRepository) {
        super(baseRepository);
        this.autorRepository = autorRepository;
    }
}
