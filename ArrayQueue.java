import java.lang.*;
import java.util.*;

public class ArrayQueue implements Queue {
    private int tail;
    private int head;
    private Object[] arr;

    private int length = 10;


    public ArrayQueue() {
        this.tail = 0;
        this.head = 0;
        this.arr = new Object[10];
    }

    @Override
    public Object dequeue() {

        if(head == tail){
            return null;
        }

        Object obj = arr[head];
        head = (head+1) % arr.length;

        return obj;

    }

    @Override
    public void enqueue(Object item) {
        if((tail +1) % arr.length == head){
            resizeArr();
            System.out.println(arr.length);
        }
        arr[tail] = item;
        tail = (tail+1)% arr.length;

    }


    @Override
    public boolean empty() {
        return (head == tail);
    }

    private void resizeArr(){
        Object[] newArr = new Object[arr.length*2];

        for(int i =0; i < arr.length; i++){
            newArr[i] =  arr[i];
        }

        head = 0;
        tail = arr.length-1;

        arr = newArr;

    }
}
