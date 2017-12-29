package java_core;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

    public class App {

        public static void main(String[] args) {
            Cinema cinema = new Cinema();
            cinema.printFilms(LocalDate.of(2017, Month.DECEMBER, 25), LocalTime.of(14, 0));
            System.out.println("Film by name");
            cinema.printFilmInfo("Predator");
        }
    }
