package com.example.demo.Service;

import com.example.demo.Entity.Domicilio;
import com.example.demo.Repository.BaseRepository;
import com.example.demo.Repository.DomicilioRepository;
import com.example.demo.Service.IBaseServiceImpl;
import com.example.demo.Service.IDomicilioService;
import org.springframework.stereotype.Service;

@Service
public class IDomicilioServiceImpl extends IBaseServiceImpl<Domicilio, Long> implements IDomicilioService {

    private final DomicilioRepository domicilioRepository;

    public IDomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository,
                                 DomicilioRepository domicilioRepository) {
        super(baseRepository);
        this.domicilioRepository = domicilioRepository;
    }
}
