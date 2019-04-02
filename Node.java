class Node{
  // stores numbers
 private int data;
 // can connects to other nodes
 private Node next,prev;

 //node constructor with 3 elements
 public Node(Node a,int b,Node c) {
   prev = a;
   data = b;
   next = c;
 }
 //node contrusctor with a beginning
 public Node(int b,Node c) {
   data = b;
   next = c;
 }
 public Node(int b) {
   data = b;
 }
 //node constructor with an end
 public Node(Node a,int b) {
   prev = a;
   data = b;
 }
 // returns data
 public int getData() {
   return data;
 }
 // sets next as something else
 public void setNext(Node other) {
   next = other;
 }
 // sets previous as something
 public void setPrev(Node other) {
   prev = other;
 }
 // sets data as a different value
 public void setData(int i) {
   data = i;
 }
 // returns the next node
 public Node next() {
   return next;
 }
 //returns the previous node
 public Node prev() {
   return prev;
 }
 //returns the data in string form
 public String toString() {
   return "" + data;
 }
}
