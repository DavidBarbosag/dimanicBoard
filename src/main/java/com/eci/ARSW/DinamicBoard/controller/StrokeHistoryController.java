package com.eci.ARSW.DinamicBoard.controller;

import com.eci.ARSW.DinamicBoard.model.Stroke;
import com.eci.ARSW.DinamicBoard.service.StrokeStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StrokeHistoryController {

    @Autowired
    private StrokeStorageService strokeStorageService;

    @GetMapping("/strokes")
    public List<Stroke> getAllStrokes() {
        return strokeStorageService.getAllStrokes();
    }
}
