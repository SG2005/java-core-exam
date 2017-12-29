
package java_core;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class Cinema {

    public void printFilms(LocalDate date, LocalTime time) {
        Duration duration = Duration.ZERO;
        for (Schedule schedule : getAvailableSchedules(date, time)) {
            for (Film film : Film.getFILMS()) {
                if (schedule.getFilmId() == film.getId()) {
                    System.out.print("Name - " + film.getName() + ", ");
                    duration = Duration.ofMinutes(Long.parseLong(film.getMinutes()));
                    break;
                }
            }
            System.out.print("start - " + time.format(DateTimeFormatter.ISO_LOCAL_TIME) + ", ");
            printInfo(schedule, duration);
            System.out.println();
        }
    }

    private List<Schedule> getAvailableSchedules(LocalDate date, LocalTime time) {
        return Schedule.getFilmSchedule().stream()
                .filter(schedule -> schedule.getDate().equals(date) && schedule.getStart().contains(time))
                .collect(Collectors.toList());
    }

    void printFilmInfo(String name) {
        Duration duration = Duration.ZERO;
        for (Film someFilm : Film.getFILMS()) {
            if (someFilm.getName().equalsIgnoreCase(name)) {
                System.out.println("description - " + someFilm.getDescription());
                for (Schedule schedule : Schedule.getFilmSchedule()) {
                    if (schedule.getFilmId() == someFilm.getId()) {
                        System.out.print("name - " + someFilm.getName() + ", ");
                        printInfo(schedule, Duration.ofMinutes(Long.parseLong(someFilm.getMinutes())));
                        break;
                    }
                }
            }
        }
    }

    private void printInfo(Schedule schedule, Duration duration) {
        System.out.print("duration - " + duration.toMinutes() + ", " +
                "date - " + schedule.getDate() + ", " +
                "hall - " + schedule.getHall().name() + ", " +
                "size of hall - " + schedule.getHall().getSize());
    }
}
