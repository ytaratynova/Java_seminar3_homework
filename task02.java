// 2.Пусть дан произвольный список целых чисел, удалить из него четные числа

package seminar03_homework;

import java.util.ArrayList;
import java.util.Scanner;

public class task02 {
    
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
        
        for (int i = 0; i < arr.size(); i++){   // удаляем все четные элементы
            if (arr.get(i) % 2 ==0){
                arr.remove(arr.get(i));
                i -= 1;
            }
        }
        System.out.printf("Заданный массив после удаления четных чисел: %s\n", arr);;
        iScanner.close();
}
}