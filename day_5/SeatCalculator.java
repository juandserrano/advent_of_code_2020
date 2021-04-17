public class SeatCalculator {
    
    

    
    public static int searchRow(int firstRow, int lastRow, String positioning) {
        int[] temp_array = {firstRow, lastRow};
        for (int i = 0; i < positioning.length()-3; i++){

            
            
                if (positioning.charAt(i) == 'F'){
                    temp_array[1] = temp_array[1] - ((temp_array[1] - temp_array[0])/2);
                } else if (positioning.charAt(i) == 'B'){
                    temp_array[0] = temp_array[0] + ((temp_array[1] - temp_array[0])/2);
                } 
            System.out.println(positioning.charAt(i));
            System.out.println(temp_array[0]);
            System.out.println(temp_array[1]);
        }
        return temp_array[1];
        
    }
}
