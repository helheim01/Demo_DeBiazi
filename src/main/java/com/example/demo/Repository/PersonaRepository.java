package com.example.demo.Repository;

import com.example.demo.Entity.Persona;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {}

