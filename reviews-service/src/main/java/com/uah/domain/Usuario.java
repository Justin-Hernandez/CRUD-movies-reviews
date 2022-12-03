package com.uah.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.micronaut.data.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Date;

@MappedEntity(value = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue
    private String id;

    @NotNull
    private String nombre;

    @NotNull
    private String apellidos;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fecha_nacimiento;

    public Usuario(String id, String nombre, String apellidos, Date fecha_nacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + this.id +
                ",nombre:" + this.nombre +
                ", apellidos:" + this.apellidos +
                ",fecha_nacimiento: " + this.fecha_nacimiento.toString() +
                "}";
    }
}
