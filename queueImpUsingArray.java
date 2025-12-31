public class queueImpUsingArray {
    int size = 3;
    int[] queue = new int[size];
    int currsize = 0;
    int start = -1;
    int end = -1;
    public static void main(String[] args) {
        queueImpUsingArray q = new queueImpUsingArray();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println(q.peek());
        System.out.println(q.size());
        System.out.println(q.pop());
        System.out.println(q.size());
        System.out.println(q.peek());
        q.push(5);
        System.out.println(q.peek());
        System.out.println(q.size());
    }

    public void push(int n){
        if(currsize == size){
            System.out.println("Queue is full");
            return;
        }
        if(currsize == 0){
            start = end = 0;
        }
        else{
            end = (end+1)%size;
        }
        currsize++;
        queue[end] = n;
    }
    public int pop(){
        if(currsize == 0) return -1;
        int el = queue[start];
        if(currsize == 1){
            start = end = -1;
        }
        else{
            start = (start+1)%size;
        }
        currsize--;
        return el;
    }
    public int size(){
        return currsize;
    }
    public int peek(){
        if(currsize == 0) return -1;
        return queue[start];
    }
}
