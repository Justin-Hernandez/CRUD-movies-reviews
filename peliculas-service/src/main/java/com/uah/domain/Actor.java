package com.uah.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "actores", schema = "peliculas_schema")
public class Actor {

    @Id
    @SequenceGenerator(name = "actores_id_gen", sequenceName = "actores_id_seq", schema = "peliculas_schema", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actores_id_gen")
    private Long id;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Column(name = "fecha_nacimiento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date fecha_nacimiento;

    @NotNull
    @Column(name = "pais")
    private String pais;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + this.id +
                ",nombre:" + this.nombre +
                ",fecha_nacimiento: " + this.fecha_nacimiento.toString() +
                ",pais:" + this.pais +
                "}";
    }
}
