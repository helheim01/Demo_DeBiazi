package com.example.DeBiazi_Demo.Repository;

import com.example.DeBiazi_Demo.Entity.Libro;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends BaseRepository<Libro, Long> {}