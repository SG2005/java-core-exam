package java_core;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private static File PATH_TO_CSV = new File("./resources/film-schedule.txt");
    private static List<Schedule> filmSchedule = readSchedules(new FilmScheduleParser());

    private int id;
    private int filmId;
    private Hall hall;
    private BigDecimal cost;
    private LocalDate date;
    private List<LocalTime> start;
    private String format;

    private static List<Schedule> readSchedules(FilmScheduleParser parser) {
        List<String> filmStrings = Reader.readData(PATH_TO_CSV);
        List<Schedule> filmsList = new ArrayList<>();
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

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<LocalTime> getStart() {
        return start;
    }

    public void setStart(List<LocalTime> start) {
        this.start = start;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public static List<Schedule> getFilmSchedule() {
        return filmSchedule;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", filmId=" + filmId +
                ", hall=" + hall +
                ", cost=" + cost +
                ", date=" + date +
                ", start=" + start +
                ", format='" + format + '\'' +
                '}';
    }
}
