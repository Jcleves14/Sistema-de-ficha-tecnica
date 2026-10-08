/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.juvevolley.backend;

/**
 *
 * @author lovex
 */
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
    
    // Quitamos el ", Integer" que sobraba dentro de los corchetes angulares
    List<Jugador> findByNombreContainingIgnoreCaseOrApodoContainingIgnoreCase(String nombre, String apodo);
}
