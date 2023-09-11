package seminar3.extractingTools;

import seminar3.exceptions.dataExceptions.CanNotFIndPhone;
import seminar3.exceptions.dataExceptions.MyDataExceptions;

import java.util.List;

public class ExtractPhone implements Extracting{
    @Override
    public String extractValue(List<String> data) throws MyDataExceptions {
        String answer = null;
        for (String str : data) {
            if (checkIsPhone(str.toCharArray())) {
                answer = str;
                data.remove(str);
                break;
            }
        }
        if (answer == null) {throw new CanNotFIndPhone("Can not find phone!!");}
        return answer;
    }

    private boolean checkIsPhone(char[] array) {
        for(Character ch : array) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }
}
