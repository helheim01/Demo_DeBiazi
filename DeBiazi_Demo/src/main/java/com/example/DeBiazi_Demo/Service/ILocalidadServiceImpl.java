package com.example.DeBiazi_Demo.Service;

import com.example.DeBiazi_Demo.Entity.Localidad;
import com.example.DeBiazi_Demo.Repository.BaseRepository;
import com.example.DeBiazi_Demo.Repository.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ILocalidadServiceImpl extends IBaseServiceImpl<Localidad, Long> implements ILocalidadService {
    @Autowired
    private LocalidadRepository localidadRepository;
    public ILocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository, LocalidadRepository localidadRepository) {
        super(baseRepository);
        this.localidadRepository=localidadRepository;
    }
}
