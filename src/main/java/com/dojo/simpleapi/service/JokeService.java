package com.dojo.simpleapi.service;

import com.dojo.simpleapi.model.JokeModel;
import io.chucknorris.client.ChuckNorrisClient;
import io.chucknorris.client.Joke;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JokeService {
    private final static ChuckNorrisClient client = new ChuckNorrisClient();

    public JokeModel getJoke(){
        return new JokeModel(client.getRandomJoke().getValue());
    }

    public List<JokeModel> getJokes(String keyword){
        List<JokeModel> jokes = new ArrayList<>();
        for(Joke joke : client.searchJokes(keyword)){
            jokes.add(new JokeModel(joke.getValue()));
        }
        return jokes;
    }
}
