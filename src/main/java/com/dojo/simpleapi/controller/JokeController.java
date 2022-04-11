package com.dojo.simpleapi.controller;
import com.dojo.simpleapi.model.JokeModel;
import com.dojo.simpleapi.service.JokeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class JokeController {


    private final JokeService jokeService;

    @CrossOrigin
    @GetMapping("/joke")
    public ResponseEntity<JokeModel> getMeAJoke() {
        return ResponseEntity.ok().body(jokeService.getJoke());
    }

    @CrossOrigin
    @GetMapping("/jokes/{keyword}")
    public ResponseEntity<List<JokeModel>> getMeSomeJokes(@PathVariable String keyword) {
        List<JokeModel> jokeModels = client.searchJokes(keyword);
        return ResponseEntity.ok().body(jokeModels);
    }

}
