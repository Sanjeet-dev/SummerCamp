package practice;
class ZeroesToEnd{
    public static void zeroesToEnd(int[] arr){
        if(arr==null || arr.length==0){
            return;
        }
        int pos = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=0){
                arr[pos]=arr[i];
                pos++;
            }
        }
        for(int i=pos; i<arr.length; i++){
            arr[i]=0;
        }
        

    }
    public static void main(String[] args){
        int[] arr = {3,4,0,6,0,2,0,10};
        zeroesToEnd(arr);
        System.out.print("{");
        for(int i=0; i<arr.length; i++){
            
            System.out.print(arr[i]+",");
            
        }
        System.out.print("}");
    }
}