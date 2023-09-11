package seminar3.extractingTools;
import seminar3.exceptions.dataExceptions.CanNotFindGender;
import seminar3.exceptions.dataExceptions.MyDataExceptions;

import java.util.List;

public class ExtractGender implements Extracting{
    @Override
    public String extractValue(List<String> data) throws MyDataExceptions {
        String answer = null;
        for (String str : data) {
            if (str.length() == 1 && (str.equals("m") || str.equals("f"))) {
                answer = str;
                data.remove(str);
                break;
            }
        }
        if (answer == null) {
            throw new CanNotFindGender("Can not find gender!!!");
        }
        return answer;
    }
}
