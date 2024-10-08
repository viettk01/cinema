package com.example.cinema.controller.admin;

import com.example.cinema.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
    private final ActorService actorService;
    private final MovieService movieService;
    private final DirectorService directorService;
    private final CountryService countryService;
    private final GenreService genreService;


    @GetMapping("")
    public String getDashBoardPage() {
        return "admin/index";
    }

    @GetMapping("/user-details")
    public String getUserDetailsPage() {
        return "admin/user/detail";
    }

    @GetMapping("/movies")
    public String getAdminMoviePage(
        Model model
    ) {
        model.addAttribute(
            "movies",
            movieService.getAll()
        );
        return "admin/movie/index";
    }

    @GetMapping("/movie/{id}")
    public String getAdminInfoMoviePage(
        Model model,
        @PathVariable
        int id) {
        model.addAttribute(
            "movie",
            movieService.findById(id)
        );
        return "admin/movie/detail";
    }

    @GetMapping("/movie/create")
    public String getAdminMovieCreatePage(
        Model model
    ) {
        model.addAttribute("countries", countryService.getAllCountries());
        model.addAttribute("directors", directorService.getAllDirectors());
        model.addAttribute("actors", actorService.getAllActors());
        model.addAttribute("genres", genreService.getAllGenres());
        return "admin/movie/create";
    }


}
