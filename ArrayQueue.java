import java.lang.*;
import java.util.*;

public class ArrayQueue implements Queue {
    private int tail;
    private int head;
    private Object[] arr;

    private int length;


    public ArrayQueue() {
        this.arr = new Object[10];

        this.length = 10;
        this.tail = 0;
        this.head = 0;
        }

    @Override
    public Object dequeue() {

        if(head == tail){
            return null;
        }

        Object obj = arr[head];
        head = ((head+1)%length);
        return obj;

    }

    @Override
    public void enqueue(Object item) {
        if((tail +1) % length == head){
            resizeArr();
            //System.out.println(arr.length);
        }
        arr[tail] = item;

        tail =((tail+1)%length);
    }


    @Override
    public boolean empty() {
        return head == tail;
    }

    private void resizeArr(){
        int currentIndex = 0;
        Object newArr[] = new Object[length * 2];
        if (head > tail) {
            for (int i = head; i < length; i++) {
                newArr[currentIndex++] = arr[i];
            }
            for (int j = 0; j < tail; j++) {
                newArr[currentIndex++] = arr[j];
            }
            head = 0;
            tail = arr.length - 1;
        } else {
            for (; currentIndex < length; currentIndex++)
                newArr[currentIndex] = arr[currentIndex];

        }
        arr = newArr;
        length = length * 2;

        

    }
}
