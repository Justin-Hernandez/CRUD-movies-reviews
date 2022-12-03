package com.uah.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name="peliculas", schema="peliculas_schema")
public class Pelicula {

    @Id
    @SequenceGenerator(name = "peliculas_id_seq", schema = "peliculas_schema", sequenceName = "peliculas_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "peliculas_id_seq")
    private Long id;
    @NotNull
    @Column(name = "titulo")
    private String titulo;
    @NotNull
    @Column(name = "ano")
    private Integer ano;
    @NotNull
    @Column(name = "duracion")
    private Integer duracion;
    @NotNull
    @Column(name = "pais")
    private String pais;
    @NotNull
    @Column(name = "sinopsis")
    private String sinopsis;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="id_director")
    private Director director;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name="reparto",
            schema="peliculas_schema",
            joinColumns = @JoinColumn(name="id_pelicula"),
            inverseJoinColumns = @JoinColumn(name="id_actor"))
    private Set<Actor> reparto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Set<Actor> getReparto() {
        return reparto;
    }

    public void setReparto(Set<Actor> reparto) {
        this.reparto = reparto;
    }

    @Override
    public String toString() {
        return "{" +
                "id: " + this.id +
                ",ano:" + this.ano +
                ",duracion:" + this.duracion +
                ",pais:" + this.pais +
                ",sinopsis:" + this.sinopsis +
                ",director:" + this.director.toString() +
                ",reparto:" + this.reparto.toString() +
                "}";
    }
}
