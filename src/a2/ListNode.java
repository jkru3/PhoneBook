// Joseph "Joey" Krueger
// Assignment 2
// CS145
//
// This class implements a Linked List data structure using private and public methods
// I used an array rather than individual data types to represent the phonebook fields
// which saved alot of space in the methods
// [0] == First Name
// [1] == Last Name
// [2] == Phone Number
// [3] == Email Address
// [4] == Notes

package a2;

import java.util.Locale;

public class ListNode
{
    private final int      DATA_FIELDS = 5;
    private       ListNode head;
    private       String[] data;
    private       ListNode next;
    
    public ListNode() //constructs the head of the empty list
    {
        this.head = null;
    }
    
    public ListNode(String[] data) //constructs the first ListNode with no next element
    {
        this.data = data;
        this.next = null;
    }
    
    public ListNode(ListNode next,
                    String[] data) //constructs every ListNode after the first
    {
        this.data = data;
        this.next = next;
    }
    
    private ListNode nodeAt(int index) //private getter used only by this class
    {
        ListNode current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current;
    }
    
    public String[] stringAt(
            int index) //getter pulls array-element data from the specified node
    {
        return nodeAt(index).data;
    }
    
    public void add(String[] data) //setter adds a new ListNode at the end of the list
    {
        if(head == null) {
            head = new ListNode(data);
        } else {
            ListNode current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = new ListNode(data);
        }
    }
    
    public void add(int index,
                    String[] data) //setter adds a new ListNode anywhere in the list, but it's pretty trivial, and I didn't use it for this version.
    {
        if(index == 0) {
            head = new ListNode(data);
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = new ListNode(current.next, data);
        }
    }
    
    public void remove(int index) //setter removes a ListNode entry
    {
        if(index == 0) {
            head = head.next;
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }
    
    public void modify(int index, int selection,
                       String edit) //setter modifies a ListNode entry
    {
        ListNode current = nodeAt(index);
        current.data[selection] = edit;
    }
    
    public String get(int index,
                      int dataField) //getter retrieves information on just one ListNode at a specific spot
    {
        String contact = "";
        if(dataField == 2)
        {
            contact = "(" + (nodeAt(index).data[2]).substring(0, 3) + ")" +
                      (nodeAt(index).data[2]).substring(3, 6) + "-" +
                      (nodeAt(index).data[2]).substring(6, 10);
        } else {
            contact = nodeAt(index).data[dataField];
        }
        return contact;
    }
    
    public boolean contains(int index,
                            String search) //getter tests to see if a string is contained within the elements of any given ListNode
    {
        for(int i = 0; i < DATA_FIELDS; i++){
            if(((nodeAt(index).data[i]).toUpperCase()).contains(
                    search.toUpperCase(Locale.ROOT))) {
                return true;
            }
        }
        return false;
    }
    
    public int size() //getter checks the size of the entire Linked List
    {
        int      sizeCount = 0;
        ListNode current   = head;
        while(current != null){
            current = current.next;
            sizeCount++;
        }
        return sizeCount;
    }
    
    public boolean isEmpty() //getter checks to see if the Linked List contains any nodes.
    {
        if(size() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() //To string isn't used in this program, there is more customizablity with "get()"
    {
        String   result  = "";
        ListNode current = head;
        while(current != null){
            result += current.data[0] + ", " + current.data[1] + ", " + "(" +
                      (current.data[2]).substring(0, 3) + ")" +
                      (current.data[2]).substring(3, 6) + "-" +
                      (current.data[2]).substring(6, 10) + ", " + current.data[3] + ", " +
                      current.data[4] + "\n";
            current = current.next;
        }
        return (result);
    }
}