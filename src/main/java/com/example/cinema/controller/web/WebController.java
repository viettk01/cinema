package com.example.cinema.controller.web;

import com.example.cinema.service.CityService;
import com.example.cinema.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class WebController {
    private final MovieService movieService;
    private final CityService cityService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute(
            "movies",
            movieService.getAllPublishMoviesOrderByReleaseDate()
        );
        return "/web/index";
    }

    @GetMapping("/movie/{slug}")
    public String infoMoviePage(@PathVariable("slug") String slug, Model model) {
        model.addAttribute(
            "movie",
            movieService.getPublishMovieBySlug(slug)
        );
        return "/web/movie/detail";
    }

    @GetMapping("/booking")
    public String getBookingPage(Model model) {
        model.addAttribute(
            "cities",
            cityService.getAllCities()
        );
        model.addAttribute(
            "movies",
            movieService.getAll()
        );
        return "/web/pages/booking";
    }
}
