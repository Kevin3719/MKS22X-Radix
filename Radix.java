import java.util.*;
public class Radix{
  public static void Radix(int[] data) {
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
    while(max / (Math.pow(10,digits)) > 0) {
      digits += 1;
    }
    for (int j = 1; j < digits; j++) {
    for(int i = 0; i < data.length;i++) {
      holder = temp.removeLast();
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
    data[i] = temp.removeLast();
  }
  }
  public static void main(String[] args) {
    int[] a = {2,3,1,5,23,5,3,-7,8};
    Radix(a);
    for(int i = 0; i < a.length; i++) {
      System.out.print(a[i]);
      System.out.print(" ");
    }
  }
}
