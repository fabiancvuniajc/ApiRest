package com.example.apirest.controllers;

import com.example.apirest.controllers.dto.VideoJuegoRequest;
import com.example.apirest.controllers.dto.VideoJuegoResponse;
import com.example.apirest.services.VideoJuegoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/videojuegos")
public class VideoJuegoController {

    private final VideoJuegoService videoJuegoService;

    public VideoJuegoController(VideoJuegoService videoJuegoService) {
        this.videoJuegoService = videoJuegoService;
    }

    @PostMapping
    public ResponseEntity<VideoJuegoResponse> crearVideoJuego(
            @RequestBody VideoJuegoRequest videoJuegoRequest
    ) {
        // Lógica para crear un videojuego
        return ResponseEntity.ok
                (videoJuegoService.crearVideoJuego(videoJuegoRequest));
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodosLosVideoJuegos() {
        return ResponseEntity.ok(videoJuegoService.obtenerTodosLosVideoJuegos());
    }
}
