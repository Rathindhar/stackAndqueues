class stackImpUsingArray{
    int size = 3;
    int top = -1;
    int[] stack = new int[size];
    public static void main(String[] args) {
        stackImpUsingArray st = new stackImpUsingArray();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println(st.size());
        System.out.println(st.peek());
        //st.pop();
    }
    public void push(int n){        
        if(top < size-1){
            top++;
            stack[top] = n;
        }
        else{
            System.out.println("stack overflow");
        }
    }
    public int pop(){
        if(top == -1) return -1;
        return stack[top--];
    }
    public int peek(){
        if(top == -1) return -1;
        return stack[top];
    }
    public int size(){
        return top+1;
    }
}