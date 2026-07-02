package practice;
class StringReverse{
    static void reverse(String str){
        if(str == null || str.length() == 0){
            return;
        }
        for(int i=str.length()-1; i>=0; i--){
            System.out.print(str.charAt(i));
        }
    }
    public static void main(String[] args){
        String str = "java";
        reverse(str);
    }
}