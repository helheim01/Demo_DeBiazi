package com.example.DeBiazi_Demo.Service;

import com.example.DeBiazi_Demo.Entity.Domicilio;
import com.example.DeBiazi_Demo.Repository.BaseRepository;
import com.example.DeBiazi_Demo.Repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IDomicilioServiceImpl extends IBaseServiceImpl<Domicilio, Long> implements IDomicilioService{
    @Autowired
    private DomicilioRepository domicilioRepository;

    public IDomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository, DomicilioRepository domicilioRepository) {
        super(baseRepository);
        this.domicilioRepository = domicilioRepository;
    }
}
