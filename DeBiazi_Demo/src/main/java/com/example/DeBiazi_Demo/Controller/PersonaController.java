package com.example.DeBiazi_Demo.Controller;
import com.example.DeBiazi_Demo.Entity.Persona;
import com.example.DeBiazi_Demo.Service.IPersonaServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/personas")
public class PersonaController extends BaseControllerImpl<Persona, IPersonaServiceImpl>{}

