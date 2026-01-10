import java.util.Stack;

public class InfixToPostfixConversion{
    public static void main(String[] args){
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i=0;
        String str ="a+b*(c^d-e)";

        while(i < str.length()){
            char ch = str.charAt(i);
            //Operands
            if((ch>='A' && ch<='Z') || (ch>='a' && ch<='z') || (ch>='0' && ch<='9')){
                sb.append(ch);
            }
            //Opening Brackets
            else if(ch=='('){
                st.push(ch);
            }
            //Closing Brackets
            else if(ch == ')'){
                while(!st.empty() && !(st.peek() == '(')){
                    sb.append(st.peek());
                    st.pop();
                }
                st.pop();
            }
            else{
                while(!st.empty() && priority(ch) <= priority(st.peek())){
                    sb.append(st.peek());
                    st.pop();
                }
                st.push(ch);
            }
            i++;
        }
        while(!st.empty()){
            sb.append(st.peek());
            st.pop();
        }
        System.out.println(sb.toString());
    }
    public static int priority(char ch){
        if(ch == '^') return 3;
        else if(ch == '*' || ch == '/') return 2;
        else if(ch == '+' || ch == '-') return 1;
        else return -1;
    }
}