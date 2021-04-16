import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) {
        String data;
        int[] numbers;

        try {
            File myFile = new File("./day_1/input.py");
            Scanner myScanner = new Scanner(myFile);
            data = myScanner.nextLine();
            String[] splitString = (data.split(" = \\["));
            String array = splitString[1];
            String new_array = array.substring(0,array.length()-1);

            String[] stringArray = new_array.split(",");
            int[] finalArray = new int[stringArray.length];

           for (int i = 0; i < stringArray.length; i++){
               finalArray[i] = Integer.parseInt(stringArray[i]);
           }

           for (int i = 0; i < finalArray.length; i++){
               for (int j = 0; j < finalArray.length; j++){
                   for (int k = 0; k < finalArray.length; k++){
                       if(finalArray[i] + finalArray[j] + finalArray[k] == 2020){
                           System.out.println(finalArray[i] * finalArray[j] * finalArray[k]);
                       }
                   }
               }
           }

        } catch (Exception n){
            n.printStackTrace();
        }



    }





}