
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day6 {
    public static void main(String[] args) {

        try {
            Path filePath = Path.of("./day_6/input.txt");
            String data = Files.readString(filePath);
            String[] newData = data.split("\n\n");

            // Part 1: Anyone answered "yes"
           //  System.out.println(anyone(newData));
            // Part 2: Everyone answered "yes"
           System.out.println(everyone(newData));

            // everyone(newData);




        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static int anyone(String[] newData){
        List<Integer> numUniques = new ArrayList<>();
        Pattern p = Pattern.compile("([a-z])");

        for (String el : newData){
            List<String> uniqueLetters = new ArrayList<>();
            Matcher m = p.matcher(el);
            while(m.find()){
                if(!uniqueLetters.contains(m.group())){
                    uniqueLetters.add(m.group());
                }
            }
            numUniques.add(uniqueLetters.size());
        }
        int sumUniques = 0;
        for (int un : numUniques){
            sumUniques += un;
        }
        return sumUniques;
    }

    public static int everyone(String[] newData) {
        List<Integer> numUniques = new ArrayList<>();
        int totalSum = 0;
        for ( String family : newData){
            int countUniques = 0;

            int countMembers = family.split("\n").length;
            System.out.println(countMembers);
            List<String> testedLetters = new ArrayList<>();
            for (int i = 0; i < family.length(); i++){
                if (!testedLetters.contains(family.substring(i,i+1))){
                    if (isAllYes(family.substring(i,i+1), family, countMembers)) {
                        countUniques++;
                    }
                }
                testedLetters.add(family.substring(i,i+1));
            }
            numUniques.add(countUniques);
        }

        for (int num : numUniques){
            totalSum += num;
        }

        return totalSum;
    }

    public static boolean isAllYes(String letter,  String allLetters, int subPassCount){
        int numOccurrences = 0;
        Pattern p = Pattern.compile("([a-z])");
        Matcher m = p.matcher(allLetters);
        while(m.find()){
            if (m.group().equals(letter)){
                numOccurrences++;
            }
        }
        if (numOccurrences == subPassCount) {
            return true;
        } else {
            return false;
        }

    }
}