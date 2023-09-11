package seminar3.extractingTools;

import seminar3.exceptions.dataExceptions.MyDataExceptions;

import java.util.List;

public interface Extracting {
    public String extractValue(List<String> data) throws MyDataExceptions;

}
