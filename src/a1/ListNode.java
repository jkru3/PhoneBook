package a1;

import java.util.LinkedList;

public class ListNode
{
    
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    protected ListNode next;
    
    public ListNode(String firstName,
                    String lastName,
                    ListNode next) //Constructor for every other node
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.next = next;
    }
    
    public ListNode(String firstName,
                    String lastName) //Overloaded Constructor for new phoneBook nodes
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.next = null;
    }
    
    @Override
    public String toString()
    {
        return firstName + " " +
               lastName + " ";
    }

    //FirstName, lastName
    //PhoneNumber
    //Address, city, zip

    //next (last one has value null)
}
