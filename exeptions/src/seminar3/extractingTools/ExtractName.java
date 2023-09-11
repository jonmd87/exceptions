package seminar3.extractingTools;

import seminar3.exceptions.dataExceptions.CanNotFindFirstnameOrLastName;
import seminar3.exceptions.dataExceptions.MyDataExceptions;

import java.util.List;

public class ExtractName implements Extracting{
    @Override
    public String extractValue(List<String> data) throws MyDataExceptions {
        String answer = data.get(0);
        data.remove(0);
        if (answer == null) {
            throw new CanNotFindFirstnameOrLastName("Can't find firstname or lastname!");
        }
        return answer;
    }
}
