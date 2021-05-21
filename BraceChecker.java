
// checks for valid use of (), [], {} 


public class BraceChecker {

    public static boolean isValid(String braces) {

        int par = braces.indexOf("()");
        int curly = braces.indexOf("{}");
        int bracket = braces.indexOf("[]");
        
        while (par != -1 || curly != -1 || bracket != -1) {
            if (par != -1){
                braces = braces.replace("()","");
            }
            if (curly != -1) {
                braces = braces.replace("{}", "");
            }
            if (bracket != -1) {
                braces = braces.replace("[]", "");
            }

            par = braces.indexOf("()");
            curly = braces.indexOf("{}");
            bracket = braces.indexOf("[]");
        }
        return (braces.length() != 0) ?  false : true;
    }
    public static void main(String[] args) {
        System.out.println(isValid("([{}])"));
    }

}