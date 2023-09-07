package seminar2;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
//        task1();
//        task2();
        task3();
//        task4();
    }

    /*
    ** Task 1
     */
    public static void task1() {
        System.out.println(getNumber());
    }

    public static Float getNumber() {
        Float num = null;
        while (num == null) {
            String temp = scanner.next();
            try {
                num = Float.parseFloat(temp);
            } catch (Exception e) {
                System.out.println("Only numbers!");
            }
        }
        return num;
    }

    /*
     ** Task 2
     * добавил блок catch (RuntimeException e) для остальных случаев
     */
    public static void task2() {
        int[] intArray = new int[10];
        fillArray(intArray);
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void fillArray(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt(10);
        }
    }



    /*
     ** Task 3
     * спустил блок catch (Throwable ex) на последнюю позицию так как он не даст ловить остальные exception
     *
     * в методе public static void printSum(Integer a, Integer b) заменил throws FileNotFoundException
     * на throws Throwable
     */
    public static void task3() {
            try {
                int a = 90;
                int b = 3;
                System.out.println(a / b);
                printSum(23, 234);
                int[] abc = { 1, 2 };
                abc[3] = 9;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Массив выходит за пределы своего размера!");
            } catch (NullPointerException ex) {
                System.out.println("Указатель не может указывать на null!");
            } catch (Throwable ex) {
                System.out.println("Что-то пошло не так...");
            }
        }

        public static void printSum(Integer a, Integer b) throws Throwable {
            System.out.println(a + b);
        }



        /*
     ** Task 4
     */

    public static void task4() {
        try {
            System.out.println(getString());
        } catch (EmptyStringException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException re) {
            re.getStackTrace();
        }
    }

    private static String getString() throws EmptyStringException{
        String str = null;
        while (str == null) {
            System.out.print("Enter a string: ");
            str = scanner.nextLine();
        }
        if (str.length() == 0) {
            throw new EmptyStringException("Empty string!");
        }
        return str;
    }
}