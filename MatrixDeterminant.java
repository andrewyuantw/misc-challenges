public class MatrixDeterminant {
    
    public static int standard(int[][]matrix) {
        int a = matrix[0][0];
        int b = matrix[0][1];
        int c = matrix[1][0];
        int d = matrix[1][1];
        return a*d - (b*c);
    }
    public static int[][][] sub(int [][] matrix){

        int size = matrix.length;
        int[][][] listOfSubarrays = new int[size][size-1][size-1];

        for (int i = 0; i < size; i ++) {
            for (int r = 1; r <size; r ++) {
                int index = 0;
                for (int c = 0; c < size; c ++) {
                    if (c != i) {
                    listOfSubarrays[i][r-1][index] =  matrix[r][c];
                    index ++;
                    }
                }
            }
        }
        return listOfSubarrays;
    }

    public static int determinant(int[][] matrix) {
        int size = matrix.length;
        if (size == 1) 
            return matrix[0][0];
        if (size == 2) 
            return standard(matrix);
            
        int answer = 0;
        int [][][] a = sub(matrix);
        for (int c = 0; c < a.length; c ++) {
            answer += matrix[0][c] * determinant(a[c]) * (int) (Math.pow(-1,c));
        }
        return answer;
    }
    public static void main(String[] args) {
        int [] [] matrix = {{2,5,3}, {1,-2,-1}, {1, 3, 4}};
        System.out.println(determinant(matrix));
    }
 }