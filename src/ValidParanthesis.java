import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args){
        String s="({[]()})";
        if(isValid(s))
            System.out.println("Valid paranthesis");
        else
            System.out.println("Not a valid parathesis");
    }

    public static boolean isValid(String s){
        Stack<Character> stack= new Stack<Character>();
        for(int i=0; i<s.length();i++){
            char ch1=s.charAt(i);
            if(ch1=='{' || ch1=='(' || ch1=='[')
                stack.push(ch1);
            else if(ch1=='}' || ch1==')' || ch1==']'){
                if(stack.isEmpty()) return false;
                else{
                    char ch2=stack.pop();
                    if(!isPair(ch2,ch1))
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isPair(char ch1, char ch2){
        if(ch1=='{' && ch2=='}' || ch1=='[' && ch2==']' || ch1=='(' && ch2==')')
            return true;
        return false;
    }
}