public class SeatCalculator {
    
    

    
    public static int searchRow(int firstRow, int lastRow, String positioning) {
        int[] temp_array = {firstRow, lastRow};
        for (int i = 0; i < positioning.length()-3; i++){

            
            
                if (positioning.charAt(i) == 'F'){
                    temp_array[1] = temp_array[1] - ((temp_array[1] - temp_array[0])/2) - 1;
                } else if (positioning.charAt(i) == 'B'){
                    temp_array[0] = temp_array[0] + ((temp_array[1] - temp_array[0])/2) + 1;
                } 
         
        }
        return temp_array[1];
        
    }

    public static int searchColumn(String positioning) {
        int[] cols = {0 ,7};
        for (int i = 7; i < positioning.length(); i++){
                if (positioning.charAt(i) == 'L'){
                    cols[1] = cols[1] - ((cols[1] - cols[0])/2) - 1;
                } else if (positioning.charAt(i) == 'R'){
                    cols[0] = cols[0] + ((cols[1] - cols[0])/2) + 1;
                } 
            
        }
        return cols[1];
        
    }
}
