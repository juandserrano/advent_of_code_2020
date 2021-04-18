import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5 {
    public static void main(String[] args) throws IOException {

        final int FIRST_ROW = 0;
        final int LAST_ROW = 127;
        int highestSeatId = 0;

       // List<String> mainArray = new ArrayList<String>();
        List<Integer> occupiedRows = new ArrayList<Integer>();
        List<Integer> possibleIds = new ArrayList<Integer>();

        
        
        try {
            Path filePath = Path.of("./day_5/input.txt");
            String data = Files.readString(filePath);
            String regex = "([FBLR]{10})";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(data);
            while (m.find()){
                
                String ticket = m.group();
                int row = SeatCalculator.searchRow(FIRST_ROW, LAST_ROW, ticket);
                int column = SeatCalculator.searchColumn(ticket);
                int id = row * 8 + column;
                
                occupiedRows.add(id);
                if (id > highestSeatId){
                    highestSeatId = id;
                }

            }
           
            
            System.out.printf("The highest seat ID is: %d", highestSeatId);
            Collections.sort(occupiedRows);
            System.out.println(occupiedRows);

            for (int i = 70; i <= 826; i++){
                if(!occupiedRows.contains(i)){
                    System.out.println(i);
                }
            }

           
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    
}