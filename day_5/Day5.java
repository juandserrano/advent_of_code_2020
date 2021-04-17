public class Day5 {
    public static void main(String[] args) {

        final int FIRST_ROW = 0;
        final int LAST_ROW = 127;
    
        String positioning = "FFFFFFFRRR";
        int row = SeatCalculator.searchRow(FIRST_ROW, LAST_ROW, positioning);
        System.out.println(row);
    }

    
}