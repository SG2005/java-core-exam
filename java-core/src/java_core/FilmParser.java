package java_core;

import java.util.*;

public class FilmParser implements Parser<Film> {

    @Override
    public Film mapToItem(String line) {
        String[] data = line.split("\\|");
        Film item = new Film();
        item.setId(Integer.parseInt(data[0].trim()));
        item.setName(data[1].trim());
        item.setCountry(data[2].trim());
        item.setYear(data[3].trim());
        item.setGenres(parseArray(data[4].trim().split(",")));
        item.setActors(parseArray(data[5].trim().split(",")));
        item.setBudget(data[6].trim());
        item.setMinutes(data[7].trim());
        item.setRating(Integer.parseInt(data[8].trim()));
        item.setDescription(data[9].trim());
        return item;
    }

    private List<String> parseArray(String[] stringsArray) {
        List<String> stringsList = new ArrayList<>();
        for (String timeString : stringsArray) {
            if (timeString.charAt(0) == '[') {
                timeString = timeString.substring(1);
            } else if (timeString.charAt(timeString.length() - 1) == ']') {
                timeString = timeString.substring(0, timeString.length() - 1);
            }
            stringsList.add(timeString.trim());
        }
        return stringsList;
    }
}

