package com.example.apirest.services;

import com.example.apirest.controllers.dto.VideoJuegoRequest;
import com.example.apirest.controllers.dto.VideoJuegoResponse;
import com.example.apirest.persistence.entities.Category;
import com.example.apirest.persistence.entities.VideoJuego;
import com.example.apirest.persistence.repositories.CategoryJpaRepository;
import com.example.apirest.persistence.repositories.VideoJuegoJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoJuegoServiceImpl implements VideoJuegoService {

    private final VideoJuegoJpaRepository videoJuegoJpaRepository;
    private final CategoryJpaRepository categoryJpaRepository;

    public VideoJuegoServiceImpl(VideoJuegoJpaRepository videoJuegoJpaRepository, CategoryJpaRepository categoryJpaRepository, CategoryJpaRepository categoryJpaRepository1) {
        this.videoJuegoJpaRepository = videoJuegoJpaRepository;
        this.categoryJpaRepository = categoryJpaRepository1;
    }

    @Override
    public VideoJuegoResponse crearVideoJuego(VideoJuegoRequest videoJuegoRequest) {

        VideoJuego videoJuego = new VideoJuego();
        videoJuego.setPlataforma(videoJuegoRequest.getPlataforma());
        videoJuego.setTitulo(videoJuegoRequest.getTitulo());
        videoJuego.setPrecio(videoJuegoRequest.getPrecio());
        videoJuego.setStock(videoJuegoRequest.getStock());

        Optional<Category> category = categoryJpaRepository.
                findByNombre(videoJuegoRequest.getCategoria());
        if (category.isPresent()) {
            videoJuego.setCategory(category.get());
        }
        else{
            throw new RuntimeException("La categoría no existe");
        }

        videoJuegoJpaRepository.save(videoJuego);

        return mapToVideoJuegoResponse(videoJuego);
    }

    @Override
    public List<VideoJuegoResponse> obtenerTodosLosVideoJuegos() {
        return videoJuegoJpaRepository.findAll().stream()
                .map(this::mapToVideoJuegoResponse)
                .toList();
    }

    private VideoJuegoResponse mapToVideoJuegoResponse(VideoJuego videoJuego) {
        VideoJuegoResponse response = new VideoJuegoResponse();
        response.setId(videoJuego.getId());
        response.setTitulo(videoJuego.getTitulo());
        response.setPlataforma(videoJuego.getPlataforma());
        response.setPrecio(videoJuego.getPrecio());
        response.setStock(videoJuego.getStock());
        response.setCategoria(videoJuego.getCategory().getNombre());
        return response;
    }


}
