package com.example.DeBiazi_Demo.Controller;
import com.example.DeBiazi_Demo.Entity.Libro;
import com.example.DeBiazi_Demo.Service.ILibroServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/libros")
public class LibroController extends BaseControllerImpl<Libro, ILibroServiceImpl>{
}
