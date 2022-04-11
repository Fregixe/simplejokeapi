package com.dojo.simpleapi;
import io.chucknorris.client.ChuckNorrisClient;
import io.chucknorris.client.Joke;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class Controller {
    private final static ChuckNorrisClient client = new ChuckNorrisClient();

    @CrossOrigin
    @GetMapping("/joke")
    public ResponseEntity<String> getMeAJoke() {
        Joke joke = client.getRandomJoke();
        return ResponseEntity.ok().body(joke.getValue());
    }

    @CrossOrigin
    @GetMapping("/jokes/{keyword}")
    public ResponseEntity<List<String>> getMeSomeJokes(@PathVariable String keyword) {
        List<Joke> jokes = client.searchJokes(keyword);
        List<String> jokeText = new ArrayList<>();
        for(Joke joke : jokes){
            jokeText.add(joke.getValue());
        }
        return ResponseEntity.ok().body(jokeText);
    }

}
