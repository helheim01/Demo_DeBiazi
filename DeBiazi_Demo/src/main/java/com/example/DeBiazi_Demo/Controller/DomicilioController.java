package com.example.DeBiazi_Demo.Controller;

import com.example.DeBiazi_Demo.Entity.Domicilio;
import com.example.DeBiazi_Demo.Service.IDomicilioServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/domicilios")
public class DomicilioController extends BaseControllerImpl<Domicilio, IDomicilioServiceImpl>{
}
