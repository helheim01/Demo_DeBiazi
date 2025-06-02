package com.example.DeBiazi_Demo.Service;

import com.example.DeBiazi_Demo.Entity.Autor;
import com.example.DeBiazi_Demo.Repository.AutorRepository;
import com.example.DeBiazi_Demo.Repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IAutorServiceImpl extends IBaseServiceImpl<Autor, Long> implements IAutorService {

    @Autowired
    private AutorRepository autorRepository;

    public IAutorServiceImpl(BaseRepository<Autor, Long> baseRepository, AutorRepository autorRepository) {
        super(baseRepository);
        this.autorRepository=autorRepository;
    }
}
