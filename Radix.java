import java.util.*;
public class Radix{
  public static void radixsort(int[] data) {
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for(int i = 0;i < 20; i++) {
      buckets[i] = new MyLinkedList();
    }
    int max = 0;
    MyLinkedList<Integer> temp = new MyLinkedList<Integer>();
    int holder = 0;
    for(int i = 0; i < data.length;i ++) {
      holder = data[i];
      if (Math.abs(holder) > max) {
        max = Math.abs(holder);
      }

      if (holder >= 0) {
        buckets[10 + (holder % 10)].add(holder);
      } else {
        buckets[9 + (holder % 10)].add(holder);
      }
    }
    for (int k = 0; k < buckets.length;k ++) {
      temp.extend(buckets[k]);
    }
    int digits = 1;
    while(max / (int)(Math.pow(10,digits)) > 0) {
      digits += 1;
    }
    for (int j = 1; j < digits; j++) {
    for(int i = 0; i < data.length;i++) {
      //System.out.println("bob");
      holder = temp.remove(0);
      if (holder >= 0) {
        buckets[10 + ((holder / (int)Math.pow(10,j)) % 10)].add(holder);
      } else {
        buckets[9 + ((holder / (int)Math.pow(10,j) % 10))].add(holder);
      }
    }
    for (int k = 0; k < buckets.length;k ++) {
      temp.extend(buckets[k]);
    }
  }
  for (int i = 0; i < data.length; i++) {
    data[i] = temp.remove(0);
  }
  }
  public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        radixsort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}
}
