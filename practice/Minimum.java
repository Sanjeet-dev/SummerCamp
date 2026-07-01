package practice;
class Minimum {
    static int min(int [] arr){
        if (arr.length == 0 || arr == null){
            return -1;
        }
        
            int min = arr[0];
            for(int i = 1; i< arr.length; i++){
                if(arr[i] < min){
                    min = arr[i];
            
        }
    }
        return min;
    }
    public static void main(String[] args){
        int arr[] = {14,-22, 44, 55, 107};
        int ans = min(arr);
        System.out.println(ans);

    }
}