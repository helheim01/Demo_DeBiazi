package com.example.DeBiazi_Demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "libro")
@Audited
public class Libro extends Base {
    @Column(name="titulo")
    private String titulo;
    @Column(name="fecha")
    private int fecha;
    @Column(name="genero")
    private String genero;
    @Column(name="paginas")
    private int paginas;
    @ManyToMany(cascade = CascadeType.REFRESH)
    private List<Autor> autores;
}
