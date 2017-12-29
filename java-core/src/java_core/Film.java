package java_core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Film {

    private static File PATH_TO_CSV = new File("./resources/film-details.txt");
    private static List<Film> FILMS = readFilms(new FilmParser());

    public static List<Film> getFILMS() {
        return FILMS;
    }

    private int id;
    private String name;
    private String country;
    private String year;
    private List<String> genres;
    private List<String> actors;
    private String budget;
    private String minutes;
    private int rating;
    private String description;

    private static List<Film> readFilms(FilmParser parser) {
        List<String> filmStrings = Reader.readData(PATH_TO_CSV);
        List<Film> filmsList = new ArrayList<>();
        for (String filmString : filmStrings) {
            filmsList.add(parser.mapToItem(filmString));
        }
        return filmsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", year='" + year + '\'' +
                ", genres=" + genres +
                ", actors=" + actors +
                ", budget='" + budget + '\'' +
                ", minutes='" + minutes + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                '}';
    }
}
