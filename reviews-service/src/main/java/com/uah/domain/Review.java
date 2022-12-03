package com.uah.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import jakarta.annotation.Nullable;

import javax.validation.constraints.NotNull;
import java.util.Date;

@MappedEntity(value = "reviews")
public class Review {

    @Id
    @GeneratedValue
    private String id;

    @Nullable
    private Usuario usuario;

    @NotNull
    private Long pelicula_id;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fecha;

    private Integer puntuacion;

    private String review;

    public Review(String id, Usuario usuario, Long pelicula_id, Date fecha, Integer puntuacion, String review) {
        this.id = id;
        this.usuario = usuario;
        this.pelicula_id = pelicula_id;
        this.fecha = fecha;
        this.puntuacion = puntuacion;
        this.review = review;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getPelicula_id() {
        return pelicula_id;
    }

    public void setPelicula_id(Long pelicula_id) {
        this.pelicula_id = pelicula_id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + this.id +
                ", usuario:" + this.usuario.toString() +
                ", pelicula_id:" + this.pelicula_id +
                ",fecha: " + this.fecha.toString() +
                "}";
    }
}
