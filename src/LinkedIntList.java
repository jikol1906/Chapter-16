


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by borisgrunwald on 03/09/2016.
 */
public class LinkedIntList implements Intlist{

    private ListNode front;
    private ListNode last;

    public LinkedIntList() {
        front = null;
    }

    //Precondition: list is in sorted order.
    public int countDuplicates() {

        int count = 0;

        ListNode prev = front;
        ListNode current = front.next;

        while(current != null) {

            if(prev.data == current.data) {
                count++;
            }
            current = current.next;
            prev = prev.next;
        }

        return count;

    }

    public void switchPairs() {

        if(front.next == null) {
            throw new NullPointerException("Must contain 2 or more integers");
        }

        //Dummy node is placed before front
        ListNode current = new ListNode(0,front);

        while(current.next != null && current.next.next != null) {
            int temp = current.next.data;
            current.next.data = current.next.next.data;
            current.next.next.data = temp;
            current = current.next.next;
        }


    }

    public void stutter() {

        ListNode current = front;

        while(current != null) {

            current.next = new ListNode(current.data, current.next);
            current = current.next.next;

        }

    }

    public boolean notEquals (LinkedIntList l) {

        if(this.size() != l.size()) {
            return true;
        }

        NodeIterator n = new NodeIterator(l);
        NodeIterator n2 = new NodeIterator(this);

        while(n2.hasNext()) {
            if(n.next().data != n2.next().data) {
                return true;
            }
        }

        return false;


    }

    public void transferFrom(LinkedIntList l) {

        this.setLastNode();

        last.next = l.front;
        l.front = null;
    }

    public void stretch(int n) {

        if(n <= 0) {
            front = null;
        }

        ListNode current = front;

        while(current != null) {
            for(int i = 1; i < n; i++) {
                current.next = new ListNode(current.data,current.next);
                current = current.next;
            }
            current = current.next;
        }

    }

    public void compress() {

        //Dummy node is placed before front

        ListNode current = new ListNode(0,front);

        while(current.next != null && current.next.next != null) {

            current.next.data = current.next.data + current.next.next.data;
            current.next.next = current.next.next.next;
            current = current.next;

        }


    }

    public void set(int index, int value) {

        ListNode current = nodeAt(index);

        current.data = value;

    }

    public int deleteBack() {

        if(front == null) {
            throw new  NoSuchElementException();
        }

        ListNode current = front;

        while(current.next.next != null) {
            current = current.next;
        }

        ListNode lastVal = current.next;
        current.next = null;

        return lastVal.data;


    }

    public void split() {

        this.setLastNode();


        //Makes sure that the first node in the list contains a negative value.
        while(front.data > 0) {
            makeFrontTheLast();
        }

        ListNode current = front;

        for(int i = 0; i < this.size()-1; i++) {
            if(current.next.data > 0) {
                makeLastNode(current.next);
            }
            if(current.next.data < 0) {
                current = current.next;
            }
        }




    }

    public boolean hasTwoConsecutive(){

        ListNode prev = front;
        ListNode current = front.next;

        while(current != null) {
            if(current.data - prev.data == 1) {
                return true;
            }

            prev = prev.next;
            current = current.next;

        }

        return false;

    }

    public int lastIndexOf(int value) {

        ListNode current = front;
        int count = 0;
        int lastIndex = -1;

        while (current != null) {

            if (current.data == value) {
                lastIndex = count;
            }

            current = current.next;
            count++;

        }

        if(lastIndex == -1) {
            return -1;
        } else {
            return lastIndex;
        }
    }

    public int max() throws NoSuchElementException{

        if(front == null) {
            throw new NoSuchElementException("List is empty");
        }

        int max = 0;

        ListNode current = front;

        while(current != null) {
            if(current.data > max) {
                max = current.data;
            }

            current = current.next;
        }

        return max;

    }

    public int size() {
        int count = 0;

        ListNode current = front;

        while(current != null) {
            current = current.next;
            count++;
        }

        return count;
    }

    public boolean isSorted() {

        if(front == null) {
            return true;
        }

        ListNode prev = front;
        ListNode current = front.next;

        while(current != null) {

            if(current.data < prev.data) {

                return false;

            }

            prev = prev.next;
            current = current.next;

        }

        return true;


    }

    public void add(int index, int value) {
        if(index == 0) {
            front = new ListNode(value, front);
        } else {
            ListNode current = nodeAt(index-1);
            current.next = new ListNode(value, current.next);
        }
    }

    public void add(int value) {
        if(front == null) {
            front = new ListNode(value);
        } else {
            ListNode current = front;
            while(current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }

    public void remove(int index) {

        if(index == 0) {
            front = front.next;
        }

        ListNode current = nodeAt(index-1);

        current.next = current.next.next;

    }

    public int indexOf(int value) {

        int index = 0;

        ListNode current = front;

        while(current != null) {
            if(current.data == value) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1;

    }

    public int get(int index) {

        ListNode current = nodeAt(index);

        return current.data;
    }

    public int getLast() {

        setLastNode();
        return last.data;

    }

    public void addSorted(int value) {

        if(front == null || value < front.data) {
            front = new ListNode(value, front);
        } else {
            ListNode current = front;

            while (current.next != null && current.next.data < value) {
                current = current.next;
            }
            current.next = new ListNode(value, current.next);

        }

    }

    private ListNode nodeAt(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;

    }

    private void setLastNode() {

        ListNode current = front;

        while(current.next != null) {
            current = current.next;
        }

        last = current;

    }

    private void makeFrontTheLast() {

        ListNode current = front;
        front = front.next;
        current.next = null;
        last.next = current;
        last = current;



    }

    /*Insert node before the one that needs to be removed, unless it is the front node that
    needs removing.*/

    private void removeNode(ListNode prev) {

        if(prev == front) {
           front = front.next;
        } else if (prev.next.next == null) {
            prev.next = null;
        } else {
            prev.next = prev.next.next;
        }


    }

    //Cannot make front node the last
    private void makeLastNode(ListNode toBeLast) {


        ListNode prev = front;

        while(prev.next != toBeLast) {
            prev = prev.next;
        }

        ListNode ahead = toBeLast.next;
        prev.next = null;
        toBeLast.next = null;
        last.next = toBeLast;
        prev.next = ahead;
        last = toBeLast;



    }

    public String toString() {
        if(front == null) {
            return "[]";
        }
        String result = "[" + front.data;
        ListNode current = front.next;
        while(current != null) {
            result += ", " + current.data;
            current = current.next;
        }
        result += "]";
        return result;
    }


    //-------------------------Iterator----------------------------//

    public Iterator<Integer> iterator() {
        return new IntListIterator();
    }

    private class IntListIterator implements Iterator<Integer> {

        private ListNode cursor;

        public IntListIterator() {
            this.cursor = LinkedIntList.this.front;
        }

        public boolean hasNext() {
            return cursor != null;
        }

        public Integer next() {

            int current = cursor.data;
            cursor = cursor.next;
            return current;
        }

    }

    private class NodeIterator {

        private ListNode cursor;
        private ListNode prevCursor;

        public NodeIterator(LinkedIntList l) {
            this.cursor = l.front;
            this.prevCursor = new ListNode(0,l.front);
        }

        public boolean hasNext() {

            return cursor != null;

        }

        public ListNode next() {

            ListNode current = cursor;
            cursor = cursor.next;
            prevCursor = prevCursor.next;

            return current;




        }






    }







}
