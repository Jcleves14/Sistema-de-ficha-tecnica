package com.juvevolley.backend;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Jugador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // ==========================================
    // VARIABLES
    // ==========================================

    // Deportivos y Perfil
    private String nombre;
    private String apodo;
    private Integer numero;
    private Integer edad;
    private String categoria;
    private String foto;
    private String frase;
    
    // Físicos y Técnicos
    private String altura;
    private String peso;
    private String salto;
    private String manoDominante;
    private String posPrincipal;
    private String posSecundaria;
    private String coachDato;
    
    // Personales y Médicos
    private String tipoDocumento;
    private String documento;
    private String fechaNacimiento;
    private String eps;
    private String rh;



    // ==========================================
    // GETTERS Y SETTERS
    // ==========================================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // ---

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // ---

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    // ---

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    // ---

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    // ---

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // ---

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    // ---

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    // ---

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    // ---

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    // ---

    public String getSalto() {
        return salto;
    }

    public void setSalto(String salto) {
        this.salto = salto;
    }

    // ---

    public String getManoDominante() {
        return manoDominante;
    }

    public void setManoDominante(String manoDominante) {
        this.manoDominante = manoDominante;
    }

    // ---

    public String getPosPrincipal() {
        return posPrincipal;
    }

    public void setPosPrincipal(String posPrincipal) {
        this.posPrincipal = posPrincipal;
    }
      public String getPosSecundaria() {
        return posSecundaria;
    }

    public void setPosSecundaria(String posSecundaria) {
        this.posSecundaria = posSecundaria;
    }

    public String getCoachDato() {
        return coachDato;
    }

    public void setCoachDato(String coachDato) {
        this.coachDato = coachDato;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }
    
}