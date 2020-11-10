/***************************************
 * Sauman Das
 * November 9th, 2020
 * TJCT Long 1
 * Problem A: Amrita's Ice Cream Business
 * All Correct! :)
 ****************************************/
import java.util.*;
public class ProblemA {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ;i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        if (arr[n-1]-arr[0] <= 17) {
            System.out.println(0);
            return;
        }
        int minP = Integer.MAX_VALUE;
        for (int i = arr[0]; i <= arr[n-1]-17; i++){
            int min = i;
            int max = i+17;
            int price = 0;
            for (int a: arr){
                if (a < min){
                    price += (min-a)*(min-a);
                }
                else if (a > max){
                    price += (max-a)*(max-a);
                }
            }
            minP = Math.min(minP, price);
        }
        System.out.println(minP);

        sc.close();
    }
}
