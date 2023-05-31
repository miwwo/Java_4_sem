package com.example.java_14.controller;

import com.example.java_14.Game;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private List<Game> games = new ArrayList<>();


    @PostMapping
    public void createGame(@RequestBody Game game) {
        games.add(game);
    }

    @GetMapping
    public List<Game> getAllGames() {
        return games;
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable int id) {
        if (id >= 0 && id < games.size()) {
            games.remove(id);
        }
    }
}
