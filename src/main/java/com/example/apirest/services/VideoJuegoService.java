package com.example.apirest.services;

import com.example.apirest.controllers.dto.VideoJuegoRequest;
import com.example.apirest.controllers.dto.VideoJuegoResponse;

import java.util.List;

public interface VideoJuegoService {

    VideoJuegoResponse crearVideoJuego(VideoJuegoRequest videoJuegoRequest);

    List<VideoJuegoResponse> obtenerTodosLosVideoJuegos();
}
