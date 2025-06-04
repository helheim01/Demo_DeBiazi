package com.example.demo.Service;
import com.example.demo.Entity.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IPersonaService extends IBaseService<Persona, Long>{
    List<Persona>search(String filtro) throws Exception;

    //Page
    Page search(String filtro, Pageable pageable) throws Exception;
}
