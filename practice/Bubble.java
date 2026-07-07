package practice;
class Bubble{
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        if(arr == null || n == 0) return;

        for(int i=0; i<n; i++){
            for(int j=1; j<n-i; j++){
                if(arr[j-1]>arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }
    public static void main(String[] args){
        int[] arr = {7, 2, 9, 4, 1};
        bubbleSort(arr);
        for(int num: arr){
            System.out.print(num+" ");
        }
    }
}