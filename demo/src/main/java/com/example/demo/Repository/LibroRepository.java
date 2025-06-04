package com.example.demo.Repository;

import com.example.demo.Entity.Libro;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends BaseRepository<Libro, Long> {}