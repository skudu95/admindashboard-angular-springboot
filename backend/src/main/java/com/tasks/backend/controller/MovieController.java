package com.tasks.backend.controller;

import com.tasks.backend.exception.ResourceNotFoundException;
import com.tasks.backend.model.Movie;
import com.tasks.backend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping(value = "/movies")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    //    searching by ID... may not be needed in the front end
    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getEmployeeById(@PathVariable Integer id) {
        Movie employee = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie does not exist with id :" + id));
        return ResponseEntity.ok(employee);
    }


    //    adding a new movie....
    @PostMapping(value = "/movies")
    public Movie createMovie(@RequestBody Movie movie) {

        return movieRepository.save(movie);
    }

}
