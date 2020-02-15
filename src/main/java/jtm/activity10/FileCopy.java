package jtm.activity10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileCopy {

    /*
        TODO
        Implement method that takes path to file as a parameter
        And copies whole contents of the file to the same location
        but with a new file name: <old_file_name>_backup e.g.
        if file is data.txt copy should be named data.txt_backup
     */
    public void copyFile(String filePath) {
        try {
            List<String> linesInList = Files.readAllLines(Paths.get(filePath));
            Files.write(Paths.get(filePath + "_backup"), linesInList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
