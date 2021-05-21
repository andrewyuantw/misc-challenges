public class Spiralizor {

    public static void right(int[][] array, int steps, int r, int c) {
        for(int i = 0; i < steps; i ++) 
            array[r][c+i+1] = 1;
    }
    public static void left(int[][] array, int steps, int r, int c) {
        for(int i = 0; i < steps; i ++) 
        array[r][c-1-i] = 1;
    }
    public static void down(int[][] array, int steps, int r, int c) {
        for(int i = 0; i < steps; i ++) 
            array[r+1+i][c] = 1;
    }
    public static void up(int[][] array, int steps, int r, int c) {
        for(int i = 0; i < steps; i ++) 
            array[r-1-i][c] = 1;
    }
    
    public static int[][] spiralize(int y) {
        int [] steps = new int [y];
        steps[0] = y;
        for(int i = 1; i < y; i += 2) {
            steps[i] = y - i;
            if ((i + 1) < y) 
                steps[i+1] = y-i;
        }

        int [] [] array = new int [y][y];
        int startingr =0;
        int startingc= -1;

        for (int c = 0; c < steps.length; c ++) {
            if (c % 4 == 0) {
                right(array, steps[c], startingr,startingc);
                startingc += steps[c];
            } else if (c% 4 == 1) {
                down(array, steps[c], startingr,startingc);
                startingr += steps[c];
            } else if (c% 4 == 2) {
                left(array, steps[c], startingr,startingc);
                startingc -= steps[c];
            } else {
                up(array, steps[c], startingr,startingc);
                startingr -= steps[c];
            }
        }
        return array;
    }
    public static void main(String[] args) {
        int [][] matrix = spiralize(10);
        for (int r = 0; r < matrix.length; r ++){
            for (int c = 0; c < matrix[0].length; c ++)
                System.out.print(matrix[r][c] + " ");
            System.out.println();
        }
    }

}