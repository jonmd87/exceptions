package seminar3.module;

import seminar3.exceptions.dataExceptions.NullDataException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyFileReaderWriter {
    private String dir = "/home/evghen/prog/exceptions/exeptions/src/seminar3/people_data/";
    private String extension = ".txt";
    private String path;

    public MyFileReaderWriter(String fileName) throws NullDataException{
        makePath(fileName);
    }

    private void makePath(String fileName) throws NullDataException {
        if (fileName == null || fileName.isEmpty()) {
            throw new NullDataException("Wrong input data!!!");
        }
        if (!Files.isDirectory(Paths.get(this.dir))) {
            new File(this.dir).mkdir();
        }
        path = this.dir + fileName + this.extension;
    }

    public void writeDataInFile(String data) {
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            fileWriter.write(data);
            fileWriter.append("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

