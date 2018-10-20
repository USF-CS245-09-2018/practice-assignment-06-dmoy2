
public class ArrayStack implements Stack {
    private Object[] arr;
    private int top;
    private int length;

    public ArrayStack() {
        this.length = 10;
        this.top = 0;
        this.arr = new Object[length];
    }

    @Override
    public void push(Object item) {
        if(top == length){
            resizeArr();
            //System.out.println(length);
        }
        arr[top] = item;
        top++;
    }

    @Override
    public Object pop() {
        if(top > 0){
            return arr[--top];
        }
        return null;
    }

    @Override
    public Object peek() {
        if(!empty()){
            return arr[top];
        }
        else{
            return null;
        }
    }

    @Override
    public boolean empty() {
        return top == 0;
    }

    private void resizeArr(){
        Object[] newArr = new Object[length*2];
        for(int i =0; i < length; i++){
            newArr[i] =  arr[i];
        }
        top = 0;
        length = length *2;
        arr = newArr;
    }
}
