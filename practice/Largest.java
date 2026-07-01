package practice;
// import java.util.*;

public class Largest {
    public int largestElement(int arr[]){
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if (arr[i]> max){
                max = arr[i];
            }
        }
        return max;
    
    }
    public static void main(String[] args){
        int arr[] = {1,2,3,55,6,7};
        Largest main = new Largest();
        int result = main.largestElement(arr);
        System.out.println("The largest element is: " + result);
    
        




    }
}