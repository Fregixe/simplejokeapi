package com.dojo.simpleapi.controller;
import io.chucknorris.client.ChuckNorrisClient;
import io.chucknorris.client.Joke;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class JokeController {
    private final static ChuckNorrisClient client = new ChuckNorrisClient();

    @CrossOrigin
    @GetMapping("/joke")
    public ResponseEntity<Joke> getMeAJoke() {
        Joke joke = client.getRandomJoke();
        return ResponseEntity.ok().body(joke);
    }

    @CrossOrigin
    @GetMapping("/jokes/{keyword}")
    public ResponseEntity<List<Joke>> getMeSomeJokes(@PathVariable String keyword) {
        List<Joke> jokes = client.searchJokes(keyword);
        return ResponseEntity.ok().body(jokes);
    }

}
