import java.util.Stack;

public class InfixToPrefixConversion {
    public static void main(String[] args) {
        String str ="(A+B)*C-D+E";
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(')
                sb.setCharAt(i, ')');
            else if (sb.charAt(i) == ')')
                sb.setCharAt(i, '(');
        }
        str = sb.toString();

        StringBuilder res = new StringBuilder();
        int i=0;
        Stack<Character> st = new Stack<>();
        while(i<str.length()){
            char ch = str.charAt(i);
            if((ch>='A' && ch<='Z') || (ch>='a' && ch<='z') || (ch>='0' && ch<='9')){
                res.append(ch);
            }
            else if(ch == '(') st.push(ch);
            else if(ch == ')'){
                while(!st.empty() && !(st.peek()== '(')){
                    res.append(st.peek());
                    st.pop();
                }
                st.pop();
            }
            else{
                if(ch == '^'){
                    while(!st.empty() && priority(ch) <= priority(st.peek())){
                        res.append(st.peek());
                        st.pop();
                    }
                }
                else{
                    while(!st.empty() && priority(ch) < priority(st.peek())){
                        res.append(st.peek());
                        st.pop();
                    }
                }
                st.push(ch);
            }
            i++;
        }
        while(!st.empty()){
            res.append(st.peek());
            st.pop();
        }
        System.out.println(res.reverse().toString());


    }
    public static int priority(char ch){
        if(ch=='^') return 3;
        else if(ch=='/' || ch=='*') return 2;
        else if(ch=='-' || ch=='+') return 1;
        else return -1;
    }
}
