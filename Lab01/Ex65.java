package Lab01;

import java.util.Arrays;
import java.util.Scanner;

public class Ex65 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter numbers of array: ");
        int n = sc.nextInt();
        double[] arr = new double[n];

        for (int i = 0; i < n; i++){
            System.out.print("arr[" + i + "] = ");
            arr[i] = sc.nextDouble();
        }

        Arrays.sort(arr);

        double sum = 0;
        for (double x : arr) {
            sum += x;
        }

        double avg = sum / n;

        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + avg);

        sc.close();
    }
}