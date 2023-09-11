package seminar3;


import seminar3.exceptions.dataExceptions.*;
import seminar3.module.MyFileReaderWriter;
import seminar3.module.ParseData;

import java.io.FileWriter;

/**
 * Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
 * Фамилия Имя Отчество датарождения номертелефона пол
 * Форматы данных:
 * фамилия, имя, отчество - строки
 * датарождения - строка формата dd.mm.yyyy
 * номертелефона - целое беззнаковое число без форматирования
 * пол - символ латиницей f или m.
 * Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки,
 * обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
 * Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
 * Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
 * Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
 * пользователю выведено сообщение с информацией, что именно неверно.
 * Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
 * в него в одну строку должны записаться полученные данные, вида
 * <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
 * Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
 * Не забудьте закрыть соединение с файлом.
 * При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
 */
public class Main {

    public static void main(String[] args) {
        String data = "arsenii arsenievich 03.03.1944 4554 ivanov m";
        try {
            ParseData parseData = new ParseData(data);
            MyFileReaderWriter myFileReaderWriter = new MyFileReaderWriter(parseData.getLastName());
            myFileReaderWriter.writeDataInFile(parseData.toString());

        } catch (NullDataException |
                 CanNotFindGender |
                 CanNotFIndPhone |
                 CanNotFindDate |
                 CanNotFIndParentName |
                 CanNotFindFirstnameOrLastName |
                 IncorrectDateFormat e ) {
            System.out.println(e.getMessage());
        } catch (FewArgumentsException f) {
            System.out.println(f.getMessage() + " supposed " + f.getSupposed() + " received " + f.getReceived());
        } catch (MyDataExceptions e) {
            throw new RuntimeException(e);
        }
    }
}
