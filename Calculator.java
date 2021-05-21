import java.util.*;
public class Calculator {

    public static int findSymbol (String ex) {

        int [] positions = {ex.indexOf('+'), ex.indexOf('-'), ex.indexOf('*'), ex.indexOf('/'), ex.indexOf('('), ex.indexOf(')')};
        int min = ex.length();
        for (int t: positions) {
            if (t < min && t > -1)
                min = t;
        }
        return (min == ex.length()) ? -1 : min;
    }

    public static Double evaluate(String ex) {

        ArrayList <Double> numbers = new ArrayList<Double>();
        ArrayList <Character> symbols = new ArrayList<Character>();

        ex = ex.replaceAll(" ","");
        int plusneg = ex.indexOf("+-");

        while (plusneg != -1) {
            ex = ex.substring(0,plusneg) + "-" + ex.substring(plusneg+2);
            plusneg=ex.indexOf("+-");
        }

        int negneg = ex.indexOf("--");
        while (negneg != -1) {
            ex = ex.substring(0,negneg) + "+" + ex.substring(negneg+2);
            negneg=ex.indexOf("--");
        }

        if (ex.charAt(0) == '-') 
            ex = "0" + ex;

        int len = ex.length();
        int lastpar = ex.indexOf(')');

        for (int i = lastpar; i > 0; i --) {
            if (ex.charAt(i) == '(') {
                String sub = ex.substring(i + 1,lastpar);
                ex = ex.substring(0,i ) + evaluate(sub) + ex.substring(lastpar + 1);
            }
        }

        for (int i = 0; i < len; i ++) {
            int position = findSymbol(ex);
            if (position!= -1) {
                numbers.add(Double.parseDouble(ex.substring(0,position)));
                symbols.add(Character.valueOf(ex.charAt(position)));
            }
            else {
                numbers.add(Double.parseDouble(ex.substring(0)));
                break;
            }
            ex= ex.substring(position +1);
        }

        for (int t = 0; t < symbols.size(); t ++) {
            if (symbols.get(t) == '*') {
                double temp = numbers.remove(t)* numbers.get(t);
                numbers.set(t, temp);
                symbols.remove(t);
                t--;
            }
            else if (symbols.get(t) == '/') {
                double temp = numbers.remove(t)/ numbers.get(t);
                numbers.set(t, temp);
                symbols.remove(t);
                t--;
            }
        }

        for (int t = 0; t < symbols.size(); t ++) {
            if (symbols.get(t) == '+') {
                double temp = numbers.remove(t)+ numbers.get(t);
                numbers.set(t, temp);
                symbols.remove(t);
                t--;
            }
            else if (symbols.get(t) == '-') {
                double temp = numbers.remove(t)- numbers.get(t);
                numbers.set(t, temp);
                symbols.remove(t);
                t--;
            }
        }

        return numbers.get(0).doubleValue();
    }
    public static void main(String[] args) {
        System.out.println(evaluate("2 + (3 * 6)"));
    }
}