import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

public class MagicSquares {
    public static int[] convertStringArrayToIntArray(String[] stringArray) {

        int [] intArray = new int[stringArray.length];
        for(int i=0; i<stringArray.length; i++){
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        
        return intArray;
    }

    public static boolean rowTest(ArrayList<int[]> matrix, int sum) {

        int rowSum = 0;
        for(int row[]: matrix){
            for(int number: row){
                rowSum += number;
            }
            if(rowSum!=sum){
                return false;
            }
            rowSum = 0;
        }
        return true; 
    }

    public static boolean columnTest(ArrayList<int[]> matrix, int sum){

        int size = matrix.get(0).length;
        ArrayList<int[]> transposedMatrix = new ArrayList<>();
        int[] colmun = new int[size];
        for (int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                colmun[j] = matrix.get(j)[i];
            }
            
            transposedMatrix.add(colmun);
        }

        return rowTest(transposedMatrix, sum);
    }

    public static boolean dialTest(ArrayList<int[]> matrix, int sum){

        int size = matrix.get(0).length;
        int dialSum = 0;
        for(int i = 0; i < size; i++){
            dialSum += matrix.get(i)[i];
        }
        return (dialSum == sum);
    }

    

    public static boolean testMagic(String pathName) throws IOException {
        // Open the file
        BufferedReader reader = new BufferedReader(new FileReader(pathName));

        boolean isMagic = true;
        int sum = 0;
        ArrayList<int[]> matrix = new ArrayList<>();
               
        // Build matrix.
        String line;
        while ((line = reader.readLine()) != null) {
            // ... sum each row of numbers
            if (line.isEmpty()){
                continue;
            }
            String[] parts = line.split("\t");

            matrix.add(convertStringArrayToIntArray(parts));
        }
        // Caculate sum.
        
        for(int number: matrix.get(0)){
            sum+=number;
        }
        
        //Verify magicsquare.
        isMagic = (rowTest(matrix, sum) && columnTest(matrix, sum) && dialTest(matrix, sum));

        
        reader.close();
        return isMagic;
    }

    public static void main(String[] args) throws IOException {
        String[] fileNames = { "Mercury.txt", "Luna.txt" };
        for (String fileName : fileNames) {
            System.out.println(fileName + " is magic? " + testMagic(fileName));
        }
    }
}
