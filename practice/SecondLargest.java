package practice;
public class SecondLargest {
    public static int second(int[] arr){
        int Largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            if(arr[i] > Largest){
                secondLargest = Largest;
                Largest = arr[i];
            }else if(arr[i] > secondLargest && arr[i] != Largest){
                secondLargest = arr[i];
            }
        }
        
        return secondLargest;
    }
    public static void main(String[] args){
        int arr[] = {66,22,44,64,67,100};
        int result = second(arr);
        System.out.println("The second largest element is: " + result);
    }
}