package seminar3.module;

import seminar3.exceptions.dataExceptions.FewArgumentsException;
import seminar3.exceptions.dataExceptions.MyDataExceptions;
import seminar3.exceptions.dataExceptions.NullDataException;
import seminar3.extractingTools.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ParseData {
    private final List<String> raw;
    private String firstName;
    private String lastName;
    private String parentName;
    private String birthDate;
    private Integer phone;
    private String gender;
    private boolean readyTo = false;

    public ParseData(String rawData) throws MyDataExceptions {
        if(rawData == null || rawData.length() < 10) {
            throw new NullDataException("Wrong input data!!!");
        }
        this.raw = new LinkedList<>(Arrays.asList(rawData.split(" ")));
        if(raw.size() != 6) {
            throw new FewArgumentsException("Wrong quantity of arguments!", 6, raw.size());
        }
        extractData();
    }

    private void extractData() throws MyDataExceptions{
        this.gender = new ExtractGender().extractValue(raw);
        this.phone = Integer.parseInt(new ExtractPhone().extractValue(raw));
        this.birthDate = new ExtractBirthDate().extractValue(raw);
        this.parentName = new ExtractParentName().extractValue(raw);
        ExtractName name = new ExtractName();
        this.firstName = name.extractValue(raw);
        this.lastName = name.extractValue(raw);
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        String sp = " ";
        return lastName + sp +
                firstName + sp +
                parentName + sp +
                birthDate + sp +
                phone + sp + gender;
    }
}
