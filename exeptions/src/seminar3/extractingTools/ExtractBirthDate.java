package seminar3.extractingTools;

import seminar3.exceptions.dataExceptions.CanNotFindDate;
import seminar3.exceptions.dataExceptions.MyDataExceptions;
import seminar3.exceptions.dataExceptions.IncorrectDateFormat;

import java.util.List;

public class ExtractBirthDate implements Extracting{
    @Override
    public String extractValue(List<String> data) throws MyDataExceptions {
        String answer = null;
        for (String str : data) {
            if (str.contains(".") && validDate(str.toCharArray())) {
                answer = str;
                data.remove(str);
                break;
            }
        }
        if (answer == null) {
            throw new CanNotFindDate("Can't find date!!!");
        }
        return answer;
    }

    private boolean validDate(char[] arr) throws IncorrectDateFormat{
        int point = 2;
        for (char ch : arr) {
            if (ch == '.') {
                point--;
            }
        }
        if (point != 0) {
            throw new IncorrectDateFormat("Incorrect date format!!!");
        }
        return true;
    }
}
