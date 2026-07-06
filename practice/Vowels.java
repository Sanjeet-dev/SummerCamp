package practice;
class Vowels{
    static int countVowels(String str){
        if(str == null){
            return -1;
        }
        int count = 0;
        
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            switch(ch){
                case 'a','e','i','o','u','A','E','I','O','U' -> count++;
            }
        }
        return count;

    }
    public static void main(String[] args){
        String text = "Hello World I LOVE Programming";
        int total = countVowels(text);
        System.out.println("The number of vowels in a string is "+ total);

    }
}