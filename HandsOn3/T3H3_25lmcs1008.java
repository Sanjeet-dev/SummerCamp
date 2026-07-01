package HandsOn3;
import java.util.*;
class T3H3_25lmcs1008{
    public static void main(String[] args){
        ArrayList<String> students = new ArrayList<>(); // no need to assign size of array, dynamic in nature
        HashMap<String, Integer> map = new HashMap<>(); // key value pair,key is student name and value is marks,
    // adding student to arraylist
        students.add("Rajyavardhan");
        students.add("Rohit");
        students.add("Roshni");
        students.add("Shreya");
        students.add("Nikhil");
    // assigning marks to students using hashmap funtion put
        map.put("Rajyavardhan",33);
        map.put("Rohit",55);
        map.put("Roshni",65);
        map.put("Shreya",73);
        map.put("Nikhil",95);

        // enhanced for loop to iterate through the arrayList
        for (String student : students) {

            int marks = map.get(student);

            String grade;
    //remark based on marks
            if (marks >= 90) {
                grade = "Excellent";
            } else if (marks >= 50) {
                grade = "Pass";
            } else {
                grade = "Fail";
            }

            System.out.println(student + " -> Marks: " + marks + " -> " + grade);
        }
    }
}
