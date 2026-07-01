package practice;
class IsSortedArray{
    static boolean isSorted(int arr[]){
        for(int i=0;i<arr.length-1; i++){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        int arr[] = {2,3,5,6,7,10};
        boolean ans = isSorted(arr);
        System.out.println(ans);


    }
}