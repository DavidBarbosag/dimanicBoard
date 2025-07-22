package com.eci.ARSW.DinamicBoard.service;

import com.eci.ARSW.DinamicBoard.model.Stroke;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class StrokeStorageService {

    private final List<Stroke> allStrokes = new CopyOnWriteArrayList<>();

    public void addStroke(Stroke stroke) {
        allStrokes.add(stroke);
    }

    public List<Stroke> getAllStrokes() {
        return allStrokes;
    }

    public void clear() {
        allStrokes.clear();
    }
}

