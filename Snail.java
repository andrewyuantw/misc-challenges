import java.util.ArrayList;
public class Snail {

    public static ArrayList<Integer> add(ArrayList<Integer> a, int [] b) {
        for (int i = 0; i <b.length; i ++) 
            a.add(Integer.valueOf(b[i]));
        return a;
    }

    public static int[] right(int[][] array, int steps, int r, int c) {
        int [] answer = new int [steps];
        for (int i = 0; i < answer.length; i ++) 
            answer[i] = array[r][c+i+1];
        return answer;
    }

    public static int[] left(int[][] array, int steps, int r, int c) {
        int [] answer = new int [steps];
        for(int i = 0; i < answer.length; i ++) 
            answer[i] = array[r][c-1-i];
        return answer;
    }

    public static int[] down(int[][] array, int steps, int r, int c) {
        int [] answer = new int [steps];
        for(int i = 0; i < answer.length; i ++) 
            answer[i] = array[r+1+i][c];
        return answer;
    }
    public static int[] up(int[][] array, int steps, int r, int c) {
        int [] answer = new int [steps];
        for(int i = 0; i < answer.length; i ++) 
            answer[i] = array[r-1-i][c];
        return answer;
    }

    public static int[] snail(int[][] array) {
        int x = array.length;
        if (x == 1 && array[0].length == 0) 
            return new int [0];
        
        int [] steps = new int [2 * x - 1];
        
        for(int i = 0; i < steps.length; i ++) 
            steps[i] = (int) (x - (i * 0.5));
        
        ArrayList <Integer> ans = new ArrayList<Integer>();
        int startingr =0;
        int startingc= -1;

        for (int c = 0; c < steps.length; c ++) {
            if (c % 4 == 0) {
                ans = new ArrayList<Integer>(add(ans,right(array, steps[c], startingr,startingc) ));
                startingc += steps[c];
            } else if (c % 4 == 1) {
                ans = new ArrayList<Integer>(add(ans,down(array, steps[c], startingr,startingc) ));
                startingr += steps[c];
            } else if (c % 4 == 2) {
                ans = new ArrayList<Integer>(add(ans,left(array, steps[c], startingr,startingc) ));
                startingc -= steps[c];
            } else {
                ans = new ArrayList<Integer>(add(ans,up(array, steps[c], startingr,startingc) ));
                startingr -= steps[c];
            }
        }
        
        int [] answer = new int [x * x];
        for (int q = 0; q < ans.size(); q++) 
            answer[q] = ans.get(q).intValue();

        return answer;
    } 
     public static void main(String[] args) {
        int[][] array
        = {{1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}};

        for (int i: snail(array))
            System.out.println(i);
        
        
    }
}