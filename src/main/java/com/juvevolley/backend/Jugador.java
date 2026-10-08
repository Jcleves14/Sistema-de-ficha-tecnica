/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juvevolley.backend;

/**
 *
 * @author lovex
 */
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Jugador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apodo;
    private Integer numero;
    private String altura;
    private Integer edad;
    private String salto;
    private String categoria;
    private String posPrincipal;
    private String posSecundaria;
    private String foto;
    private String frase;
    private String coachDato;


    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getAltura() {
        return altura;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getSalto() {
        return salto;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getPosPrincipal() {
        return posPrincipal;
    }

    public String getPosSecundaria() {
        return posSecundaria;
    }

    public String getFoto() {
        return foto;
    }

    public String getFrase() {
        return frase;
    }

    public String getCoachDato() {
        return coachDato;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setSalto(String salto) {
        this.salto = salto;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPosPrincipal(String posPrincipal) {
        this.posPrincipal = posPrincipal;
    }

    public void setPosSecundaria(String posSecundaria) {
        this.posSecundaria = posSecundaria;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public void setCoachDato(String coachDato) {
        this.coachDato = coachDato;
    }
}

