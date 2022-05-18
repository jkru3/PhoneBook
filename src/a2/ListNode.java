// Joseph "Joey" Krueger
// CS145
//
// This class implements a Linked List data structure using private and public methods
// I used an array rather than individual data types to represent the phonebook fields
// which saved alot of space for the methods
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
    
    //private getter used only by this class
    //POST: returns the node at an index for the convenience of other methods in this class
    private ListNode nodeAt(int index)
    {
        ListNode current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current;
    }
    
    //getter that pulls array-element data from the specified node.
    //used when the node isn't needed but the data in the node is -> (phonebook.(get))
    public String[] stringAt(int index)
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
                    String[] data) //setter adds a new ListNode anywhere in the list.
    {
        if(index == 0) {
            head = new ListNode(head, data);
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
    
    //getter; give it an index and a datafield
    //POST: it returns the array value that represents the element of that particular index
    public String get(int index, int dataField)
    {
        String contact = "";
        if(dataField == 2) {
            contact = "(" + (nodeAt(index).data[2]).substring(0, 3) + ")" +
                      (nodeAt(index).data[2]).substring(3, 6) + "-" +
                      (nodeAt(index).data[2]).substring(6, 10);
        } else {
            contact = nodeAt(index).data[dataField];
        }
        return contact;
    }
    
    //getter; tests to see if a string is contained within the elements of any given ListNode
    public boolean contains(int index, String search)
    {
        for(int i = 0; i < DATA_FIELDS; i++){
            if(((nodeAt(index).data[i]).toUpperCase()).contains(
                    search.toUpperCase(Locale.ROOT))) {
                return true;
            }
        }
        return false;
    }
    
    public int size() //getter; checks the size of the entire Linked List
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
    
    //This method sorts the data either alphabetically or by phone number
    //using node data. I feel like there is some redundant code here;
    //in particular I tried running it through 2 cases, and if there was a way to pass an operator sign in java
    //I probably could have used one. I just didn't feel the time to figure that out would make it worth it
    //
    //TLDR --If I had more time I could make this more elegent! (and maybe I will for my portfolio?)
    public ListNode sort(ListNode book, int entryField, int sortBy)
    {
        ListNode sortedBook = new ListNode();
        while(!book.isEmpty()){
            ListNode current  = head;
            ListNode nodeApex = current;
            int      index    = 0;
            int      letter   = 0;
            for(int node = 1; node < book.size(); node++){
                switch(sortBy){
                    case 1:
                        while(letter != (current.next.data[entryField]).length() - 1 &&
                              letter != (nodeApex.data[entryField]).length() - 1 &&
                              (current.next.data[entryField]).charAt(letter) ==
                              (nodeApex.data[entryField]).charAt(letter)){
                            letter++;
                        }
                        if((current.next.data[entryField]).charAt(letter) >
                           (nodeApex.data[entryField]).charAt(letter)) {
                            nodeApex = current.next;
                            index    = node;
                        }
                        break;
                    case 2:
                        while(letter != (current.next.data[entryField]).length() - 1 &&
                              letter != (nodeApex.data[entryField]).length() - 1 &&
                              (current.next.data[entryField]).charAt(letter) ==
                              (nodeApex.data[entryField]).charAt(letter)){
                            letter++;
                        }
                        if((current.next.data[entryField]).charAt(letter) <
                           (nodeApex.data[entryField]).charAt(letter)) {
                            nodeApex = current.next;
                            index    = node;
                        }
                        break;
                    case 3:
                        if(Long.parseLong(current.next.data[2]) <
                           Long.parseLong(nodeApex.data[2])) {
                            nodeApex = current.next;
                            index    = node;
                        }
                        break;
                    case 4:
                        if(Long.parseLong(current.next.data[2]) >
                           Long.parseLong(nodeApex.data[2])) {
                            nodeApex = current.next;
                            index    = node;
                        }
                        break;
                }
                current = current.next;
            }
            sortedBook.add(book.stringAt(index));
            book.remove(index);
        }
        return sortedBook;
    }
}