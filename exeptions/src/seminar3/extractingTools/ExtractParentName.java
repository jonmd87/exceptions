package seminar3.extractingTools;

import seminar3.exceptions.dataExceptions.CanNotFIndParentName;
import seminar3.exceptions.dataExceptions.MyDataExceptions;

import java.util.List;

public class ExtractParentName implements Extracting{
    @Override
    public String extractValue(List<String> data) throws MyDataExceptions {
        String answer = null;
        for (String str : data) {
            if (str.contains("ich") || str.contains("na")) {
                answer = str;
                data.remove(str);
                break;
            }
        }
        if (answer == null) {
            throw new CanNotFIndParentName("Can't find Parent name!");
        }
        return answer;
    }
}
