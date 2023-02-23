package PC;
import java.util.LinkedList;
public class PC{
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 2;
    public void produce() throws InterruptedException{
        int value = 1;
        while(true){
            synchronized(this){
                int capacity=0;
                while(list.size() == capacity){
                    wait();
                }
                System.out.println("Produced data "+value);
                list.add(value);
                value++;
                notify();
                Thread.sleep(500);
            }
        }
    }
    public void consume() throws InterruptedException{
        while(true){
            synchronized(this){
                while(list.size() == 0){
                    wait();
                }
                int value = list.removeFirst();
                System.out.println("Consumer" + value);
                notify();
                Thread.sleep(500);
            }        }    }
}
