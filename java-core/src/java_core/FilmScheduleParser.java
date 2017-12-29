package java_core;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilmScheduleParser implements Parser<Schedule> {

    @Override
    public Schedule mapToItem(String line) {
        String[] data = line.split("\\|");
        Schedule item = new Schedule();
        item.setId(Integer.parseInt(data[0].trim()));
        item.setFilmId(Integer.parseInt(data[1].trim()));
        for (Hall hall : Hall.values()) {
            if (data[2].trim().equalsIgnoreCase(hall.name())) {
                item.setHall(hall);
                break;
            }
        }
        item.setCost(BigDecimal.valueOf(Double.parseDouble(data[3].trim())));
        item.setDate(LocalDate.parse(data[4].trim(), DateTimeFormatter.ISO_LOCAL_DATE));
        item.setStart(parseTime(data[5].trim().split(",")));
        item.setFormat(data[6].trim());
        return item;
    }

    private List<LocalTime> parseTime(String[] timeStrings) {
        List<LocalTime> timesList = new ArrayList<>();
        for (String timeString : timeStrings) {
            if (timeString.charAt(0) == '[') {
                timeString = timeString.substring(1);
            } else if (timeString.charAt(timeString.length() - 1) == ']') {
                timeString = timeString.substring(0, timeString.length() - 1);
            }
            timesList.add(LocalTime.parse(timeString.trim(), DateTimeFormatter.ISO_LOCAL_TIME));
        }
        return timesList;
    }
}
