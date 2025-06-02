package com.example.DeBiazi_Demo.Controller;

import com.example.DeBiazi_Demo.Entity.Autor;
import com.example.DeBiazi_Demo.Service.IAutorServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/autores")
public class AutorController extends BaseControllerImpl<Autor, IAutorServiceImpl> {
}