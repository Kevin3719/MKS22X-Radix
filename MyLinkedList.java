class MyLinkedList<E>{
  class Node{
    // stores numbers
   public E data;
   // can connects to other nodes
   public Node next,prev;

   //node constructor with 3 elements
   public Node(Node a,E b,Node c) {
     prev = a;
     data = b;
     next = c;
   }
   //node contrusctor with a beginning
   public Node(E b,Node c) {
     data = b;
     next = c;
   }
   public Node(E b) {
     data = b;
   }
   //node constructor with an end
   public Node(Node a,E b) {
     prev = a;
     data = b;
   }
   // returns data
   public E getData() {
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
   public void setData(E i) {
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
 private int length;
 private Node start,end;
 public MyLinkedList() {
   length = 0;
 }
 // sets everything back to beginning
public void clear() {
  start = null;
  end = null;
  length = 0;
}
// returns length thats about it
 public int size() {
   return length;
 }
 // 2 cases 1. if there is an empty MyLinkedList 2 if there isnt
 // if there is
 public boolean add(E value) {
   if (length == 0) {
     Node input = new Node(value);
     end = input;
     start = input;
   } else {
     Node input = new Node(end, value);
     end.setNext(input);
     end = input;
   }
   length += 1;
   return true;
 }

 // throws error if input is greater than length; loops through until it finds the number;
private Node getNode(int index) {
  if (index >= length || index < 0) {
    throw new IndexOutOfBoundsException("index is out of range (index < 0 || index >= size())");
  }
  // couldve done it with a for loop not sure why i didn't
  int b = 0;
  Node current = start;
  while(b < index) {
    current = current.next();
    b += 1;
  }
  return current;
}

// reused code
public E get(int index) {
  return getNode(index).getData();
}

public E set(int index,E value) {
  if (index >= length) {
    throw new IndexOutOfBoundsException("index is out of range (index < 0 || index >= size())");
  }
  E output = get(index);
  getNode(index).setData(value);
  return output;
}

// rused code;
  public boolean contains(E value) {
  /*  Node current = start;
    for (int i = 0; i < length; i += 1) {
      if (current.getData() == value) {
        return true;
      }
      current = current.next();
    }
    return false;
    */
    return indexOf(value) > -1;
  }

// loops until it finds the right number
  public int indexOf(E value) {
    Node current = start;
      for (int i = 0; i < length; i += 1) {
        if (current.getData() == value) {
          return i;
        }
        current = current.next();
      }
      return -1;
  }


// a lot of different get and sets;
  public void add(int index,E a) {
    // if there isnt any elements or it is the last one, just use add;
    if (index == length) {
      add(a);
    } else {
    Node indexNode = getNode(index);
    Node current = new Node(a);
    //if it is the first element, need to redirect start
    if (index == 0) {
      start = current;
    } else {
      // current adopts the old prev. current becomes the prevois of indexNode
      current.setPrev(indexNode.prev());
      indexNode.prev().setNext(current);
    }
    // current's next is indexNode;
    current.setNext(indexNode);
    indexNode.setPrev(current);
    length += 1;
  }
  }

  public E removeLast() {
    E data = end.getData();
    if (length == 1) {
      clear();
    }
    else {
    Node newend = end.prev;
    end = newend;
    length -= 1;
  }
    return data;
  }
  public void merge() {




  }

// removes is more redirects. maybe shouldve used more variables
public E remove(int index) {
  Node indexNode = getNode(index);
  if (index == 0) {
    // needs to redirect start if it is the first element
    start = indexNode.next();
  } else {
    // otherwise the previous element needs to skip over the index value
    indexNode.prev().setNext(indexNode.next());
  }
  if (index == length - 1) {
    // if it is the last one then needs to redirect end
    end = indexNode.prev();
  } else {
    // otherwise the next element needs to adopt the previous of the currrent;
    indexNode.next().setPrev(indexNode.prev());
  }
  length -= 1;
  return indexNode.getData();
}


// creates a string in array format
 public String toString() {
   if (length == 0) {
     return "[]";
   }
   String output = "[";
   Node current = start;
   for (int i = 0; i < length - 1; i += 1) {
     output += current + ",";
     current = current.next();
   }
   output += current + "]";
   return output;
 }

// combine of indexOf and remove; literally copied and pasted parts of both code;
 public boolean remove(E value) {
   Node indexNode = start;
     for (int index = 0; index < length; index += 1) {
       if (indexNode.getData() == value) {
         if (index == 0) {
           start = indexNode.next();
         } else {
           indexNode.prev().setNext(indexNode.next());
         }
         if (index == length - 1) {
           end = indexNode.prev();
         } else {
           indexNode.next().setPrev(indexNode.prev());
         }
         length -= 1;
         return true;
       }
       indexNode = indexNode.next();
     }
     return false;
   }


//   Connecting two linked lists should be able to happen in constant time!
//New Method:
   public void extend(MyLinkedList<E> other){
     if (other.length == 0) {
       return;
     }
     if (length == 0) {
       start = other.start;
     } else {
     end.setNext(other.start);
     other.start.setPrev(end);}
     end = other.end;
     length += other.length;
     other.length = 0;

        //in O(1) runtime, move the elements from other onto the end of this
        //The size of other is reduced to 0
        //The size of this is now the combined sizes of both original lists
    }
}
