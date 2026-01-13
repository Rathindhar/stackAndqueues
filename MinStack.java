import java.util.Stack;

public class MinStack {
    private Stack<Long> s;
    private long mini;
    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        long value = (long) val;
        if(s.empty()){
            s.push(value);
            mini =value;
        }
        else{
            if(value < mini){
                s.push(2*value-mini);
                mini =value;
            }
            else{
                s.push(value);
            }
        }
    }
    
    public void pop() {
        if(s.empty()){
            return ;
        }
        long curr = s.pop();
        if(curr < mini){
             mini = 2 * mini - curr;
        }
        
    }
    
    public int top() {
        if(s.empty()) return -1;
            long curr = s.peek();
            if(curr < mini){
                return (int)mini;
            }
            else return (int)curr;
    }
    
    public int getMin() {
        if(s.empty()) return -1;
            return (int)mini;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

