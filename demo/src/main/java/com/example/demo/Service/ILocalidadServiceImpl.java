package com.example.demo.Service;

import com.example.demo.Entity.Localidad;
import com.example.demo.Repository.BaseRepository;
import com.example.demo.Repository.LocalidadRepository;
import org.springframework.stereotype.Service;

@Service
public class ILocalidadServiceImpl extends IBaseServiceImpl<Localidad, Long> implements ILocalidadService {

    private final LocalidadRepository localidadRepository;

    public ILocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository,
                                 LocalidadRepository localidadRepository) {
        super(baseRepository);
        this.localidadRepository = localidadRepository;
    }
}
