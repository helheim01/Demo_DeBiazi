package com.example.DeBiazi_Demo.Controller;

import com.example.DeBiazi_Demo.Entity.Localidad;
import com.example.DeBiazi_Demo.Service.ILocalidadServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/localidades")
public class LocalidadController extends BaseControllerImpl<Localidad, ILocalidadServiceImpl> {
}
