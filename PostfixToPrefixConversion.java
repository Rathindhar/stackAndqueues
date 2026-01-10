import java.util.Stack;

public class PostfixToPrefixConversion {
    public static void main(String[] args) {
        String str = "AB-DE+F*/";
        Stack<String> st = new Stack<>();
        int i=0; 
        while(i<str.length()){
            char ch = str.charAt(i);
            if((ch >='a' && ch<='z')||(ch >='A' && ch<='Z')||(ch >='0' && ch<='9')){
                st.push(ch+"");
            }
            else{
                String top1 = st.pop();
                String top2 = st.pop();
                st.push(ch+top2+top1);
            }
            i++;
        }
        System.out.println(st.peek());
    }
}
