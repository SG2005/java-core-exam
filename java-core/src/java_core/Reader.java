package java_core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Reader {

    static List<String> readData(File file) {
        List<String> inputList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file.toString()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                inputList.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return inputList;
    }
}
