package practice;
class BinarySearch{
    public static int binary(int[] arr, int target){
        int low = 0;
        int high= arr.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] arr =  {2, 5, 8, 12, 16, 20};
        int target = 12;
        int result = binary(arr, target);
        if(result != -1){
            System.out.println(target+" element found at index "+ result);
        }else{
            System.out.println("Target element not found");
        }
    }
}