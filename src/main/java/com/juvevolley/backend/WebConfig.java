/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juvevolley.backend;

/**
 *
 * @author lovex
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Le dice a Java: "Si alguien busca /imagenes/foto.webp, ve a buscarla a la carpeta imagenes_juve/"
        registry.addResourceHandler("/imagenes/**")
                .addResourceLocations("file:imagenes_juve/");
    }
}