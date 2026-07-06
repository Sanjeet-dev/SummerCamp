package practice;
class Frequency{
    public static int countElement(int[] arr, int target){
        if(arr==null || arr.length <= 0){
            return 0;
        }
        int counter = 0;
        for(int i=0; i<=arr.length-1; i++){
            if(arr[i] == target){
                counter++;
            }
        }
        return counter;
    }
    public static void main(String[] args){
        int[] arr = {5, 2, 8, 2, 10, 5, 2};
        int target = 2;
        int count = countElement(arr, target);
        System.out.println(target+" element repeated "+count+" times in an array");
    }
}