/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juvevolley.backend;

/**
 *
 * @author lovex
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/jugadores")
@CrossOrigin(origins = "*") // Esto es clave para que tu HTML pueda pedir datos sin bloqueos de seguridad
public class JugadorController {

    @Autowired
    private JugadorRepository repository; // Aquí llamamos a tu repositorio mágico

    // 1. Método para ver todos los jugadores (Cuando entras a la página)
    @GetMapping
    public List<Jugador> obtenerTodos() {
        return repository.findAll(); // Busca todos los registros en MySQL
    }

    // 2. Método para guardar un jugador nuevo (Cuando le das al botón en el formulario)
    @PostMapping
    public Jugador guardarJugador(@ModelAttribute Jugador nuevo, @RequestParam(value = "archivo", required = false) MultipartFile archivo) {
        try {
            if (archivo != null && !archivo.isEmpty()) {
                // 1. Creamos una carpeta llamada "imagenes_juve" en la raíz de tu proyecto
                Path directorio = Paths.get("imagenes_juve");
                if (!Files.exists(directorio)) {
                    Files.createDirectories(directorio);
                }

                // 2. Generamos un nombre único para que no se sobreescriban fotos
                String nombreArchivo = UUID.randomUUID().toString() + ".webp";
                Path rutaCompleta = directorio.resolve(nombreArchivo);

                // 3. Guardamos el archivo físicamente en la carpeta
                Files.write(rutaCompleta, archivo.getBytes());

                // 4. Guardamos solo el nombre de la foto en la base de datos
                nuevo.setFoto(nombreArchivo);
            } else {
                nuevo.setFoto("default.webp");
            }
            return repository.save(nuevo);
        } catch (Exception e) {
            throw new RuntimeException("Error guardando la imagen", e);
        }
    }
    // 3. Método para borrar un jugador por su ID
    @DeleteMapping("/{id}")
    public void eliminarJugador(@PathVariable Integer id) {
        repository.deleteById(id); // Busca el ID en MySQL y lo destruye
    }
    // 4. Método para Actualizar (Editar)
    @PostMapping("/editar/{id}")
    public Jugador editarJugador(@PathVariable Integer id, @ModelAttribute Jugador actualizacion, @RequestParam(value = "archivo", required = false) MultipartFile archivo) {
        // 1. Buscamos el jugador original en la base de datos
        Jugador existente = repository.findById(id).get();

        // 2. Reemplazamos sus datos con los nuevos textos
        existente.setNombre(actualizacion.getNombre());
        existente.setApodo(actualizacion.getApodo());
        existente.setNumero(actualizacion.getNumero());
        existente.setAltura(actualizacion.getAltura());
        existente.setEdad(actualizacion.getEdad());
        existente.setSalto(actualizacion.getSalto());
        existente.setCategoria(actualizacion.getCategoria());
        existente.setPosPrincipal(actualizacion.getPosPrincipal());
        existente.setPosSecundaria(actualizacion.getPosSecundaria());
        existente.setFrase(actualizacion.getFrase());
        existente.setCoachDato(actualizacion.getCoachDato());

        // 3. Solo guardamos foto nueva SI el usuario subió una
        try {
            if (archivo != null && !archivo.isEmpty()) {
                String nombreArchivo = java.util.UUID.randomUUID().toString() + ".webp";
                java.nio.file.Path ruta = java.nio.file.Paths.get("imagenes_juve").resolve(nombreArchivo);
                java.nio.file.Files.write(ruta, archivo.getBytes());
                existente.setFoto(nombreArchivo); // Pisamos la foto vieja
            }
        } catch (Exception e) {}

        // 4. Guardamos los cambios
        return repository.save(existente);
    }

    // Ruta para buscar deportistas
    @GetMapping("/buscar")
    public List<Jugador> buscarJugadores(@RequestParam("query") String query) {
        return repository.findByNombreContainingIgnoreCaseOrApodoContainingIgnoreCase(query, query);
    }
    // Este método atrapa automáticamente cuando alguien sube una foto muy pesada
    @org.springframework.web.bind.annotation.ExceptionHandler(org.springframework.web.multipart.MaxUploadSizeExceededException.class)
    public org.springframework.http.ResponseEntity<String> manejarErrorDeTamaño(org.springframework.web.multipart.MaxUploadSizeExceededException exc) {
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.BAD_REQUEST)
                .body("Error: La imagen supera el límite permitido de 2MB.");
    }
}
