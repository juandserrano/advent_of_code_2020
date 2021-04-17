import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5 {
    public static void main(String[] args) throws IOException {

        final int FIRST_ROW = 0;
        final int LAST_ROW = 127;
        int highestSeatId = 0;

        List<String> mainArray = new ArrayList<String>();
        
        try {
            Path filePath = Path.of("./day_5/input.txt");
            String data = Files.readString(filePath);
            String regex = "([FBLR]{10})";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(data);
            while (m.find()){
                mainArray.add(m.group());
            }
           
            for (String ticket : mainArray) {
                //String positioning = ticket;
                int row = SeatCalculator.searchRow(FIRST_ROW, LAST_ROW, ticket);
                int column = SeatCalculator.searchColumn(ticket);
                int id = row * 8 + column;
                System.out.println(row);
                System.out.println(column);
                System.out.println(id);
                if (id > highestSeatId){
                    highestSeatId = id;
                }
                
            }
            
            
            System.out.printf("The highest seat ID is: %d", highestSeatId);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    
}