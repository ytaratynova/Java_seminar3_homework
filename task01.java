// Реализовать алгоритм сортировки слиянием

package seminar03_homework;

import java.util.Arrays;
import java.util.Scanner;

public class task01 {

    public static int inputNumber(Scanner iScanner) {             // Пользователь вводит размер массива
        
        System.out.printf("Введите число элементов в массиве: ");
        String number = iScanner.nextLine();
        return Integer.parseInt(number);
        }

    public static int[] sortArray(int[] arr) {
        if (arr == null){
            return null;
        }
        
        if (arr.length < 2){
            return arr;
        }
        int [] left = new int[arr.length / 2];
        System.arraycopy(arr, 0, left, 0, arr.length / 2);
        
        int [] right = new int[arr.length - arr.length / 2];
        System.arraycopy(arr, left.length , right, 0, arr.length - left.length);
                
        left = sortArray(left);
        right = sortArray(right);
                 
        return mergeArray(left, right);
    } 
    
    public static int[] mergeArray(int[] arr_left, int[] arr_right){
        
        int[] arr = new int[arr_left.length + arr_right.length];
        
        int position_left = 0;
        int position_right = 0;

        for (int i = 0; i < arr.length; i++) {
            
            if (position_left < arr_left.length && position_right < arr_right.length) {
                if (arr_left[position_left] < arr_right[position_right]) {
                    arr[i] = arr_left[position_left];
                    position_left++;
                } else {
                    arr[i] = arr_right[position_right];
                    position_right++;
                }
            } else if (position_left == arr_left.length && position_right < arr_right.length) {
                arr[i] = arr_right[position_right];
                position_right++;
            } else if (position_left < arr_left.length && position_right == arr_right.length) {
                arr[i] = arr_left[position_left];
                position_left++;
            } else {
                arr[i] = 0;
            }
        }
            
            return arr;
    }

    public static void main(String[] args){
        Scanner iScanner = new Scanner(System.in);
        
        int size = inputNumber(iScanner);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {        // рандомно заполняем массив
            array[i] = ((int)(Math.random()*100));
        }
        System.out.printf("Задан массив: %s\n", Arrays.toString(array));

        System.out.printf("Отсортированный массив: %s\n", Arrays.toString(sortArray(array)));
        iScanner.close();
}
}
