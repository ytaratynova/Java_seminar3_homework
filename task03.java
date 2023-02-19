//Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое этого списка.

package seminar03_homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class task03 {


    public static int inputNumber(Scanner iScanner) {             // Пользователь вводит размер массива
        System.out.printf("Введите число элементов в массиве: ");
        String number = iScanner.nextLine();
        return Integer.parseInt(number);
        }
    public static void main(String[] args){
        Scanner iScanner = new Scanner(System.in);
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int size = inputNumber(iScanner);

        for (int i = 0; i < size; i++) {        // рандомно заполняем
            arr.add((int)(Math.random()*100));
        }
        System.out.printf("Задан массив: %s\n", arr);

        int min = arr.get(0);
        int max = arr.get(0);
        int sum = 0;

        for (int item: arr){
            if (item > max){
                max = item;
            } else if (item < min){
                min = item;
            }
            sum += item;
        }
        float avr_el = (float) sum / size;
        System.out.printf("Минимальный элемент: %d\n", min);
        System.out.printf("Максимальный элемент: %d\n", max);
        System.out.printf("Среднее арифметическое массива: %f\n", avr_el);
        iScanner.close();
    }


    
}
