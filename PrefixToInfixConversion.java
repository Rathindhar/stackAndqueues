import java.util.Stack;

public class PrefixToInfixConversion {
    public static void main(String[] args) {
        String str ="*+PQ-MN";
        Stack<String> st = new Stack<>();
        int i =str.length()-1;
        while(i >= 0){
            char ch = str.charAt(i);
            if((ch >='a' && ch<='z')||(ch >='A' && ch<='Z')||(ch >='0' && ch<='9')){
                st.push(ch+"");
            }
            else{
                String top1 = st.pop();
                String top2 = st.pop();
                st.push("("+top1+ch+top2+")");
            }
            i--;
        }
        System.out.println(st.peek());
    }
}
