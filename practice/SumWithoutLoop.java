package practice;
import java.util.*;
class SumWithoutLoop {
    public static int add(int[] arr, int index){
        if(arr==null || index >= arr.length){
            return 0;
        }
        return arr[index]+ add(arr,index+1);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,8};
        Scanner scan = new Scanner(System.in);
        System.out.println("Size of an array is ");
        int n = scan.nextInt();
        int progress = n*(n+1)/2;
        int exclusion = add(arr,0);
        System.out.print("The array doesn't have "+ (progress-exclusion));
        scan.close();
    }
}