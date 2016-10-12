/**
 * Created by borisgrunwald on 03/09/2016.
 */
public class ListNode {

    public int data;
    public ListNode next;

    public ListNode() {
        this(0,null);
    }

    public ListNode(int data) {
        this(data,null);
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        if(next != null) {
            return data + " " + "(next: " + next.data + ".)";
        } else {
            return data + " " + "(next: null)";
        }
    }
}
