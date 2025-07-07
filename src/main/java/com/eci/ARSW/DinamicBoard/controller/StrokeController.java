package com.eci.ARSW.DinamicBoard.controller;

import com.eci.ARSW.DinamicBoard.model.Stroke;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/strokes")
@CrossOrigin
public class StrokeController {

    private List<Stroke> strokes = Collections.synchronizedList(new java.util.ArrayList<>());

    @GetMapping
    public List<Stroke> getStrokes() {
        return strokes;
    }

    @PostMapping
    public void addStroke(@RequestBody Stroke stroke) {
        strokes.add(stroke);
    }

    @DeleteMapping
    public void clearStrokes() {
        strokes.clear();
    }

}
