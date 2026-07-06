package practice;
import java.util.Arrays;
class FrequencyMap{
    public static void frequencyElement(int[] arr){
        Arrays.sort(arr);
        // edge cases
        if(arr == null || arr.length == 0){
            return;
        }
        int count = 1;
        for (int i=1; i<arr.length; i++){
            if(arr[i]==arr[i-1]){
                count++;
            }else{
                System.out.println(arr[i-1]+" --> "+ count);
                count = 1;

            }
        }
        System.out.println(arr[arr.length-1]+" --> "+count);
        
    }
    public static void main(String[] args){
        int[] arr = {2, 5, 2, 8, 2, 10, 5, 2};
        frequencyElement(arr);

    }
}