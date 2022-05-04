package a1;

import java.util.LinkedList;
import java.util.Scanner;

public class PhonebookManager // extends ListNode
{
    //ListNode pb = new ListNode();
    private Scanner    input     = new Scanner(System.in);
    private LinkedList phoneBook = new LinkedList();
    
    public PhonebookManager()
    {
        phoneBook.add(new ListNode("david", "sparks"));
        phoneBook.add(new ListNode("donny", "rich"));
        phoneBook.add(new ListNode("baby", "butch"));
        phoneBook.add(new ListNode("lady", "kush"));
    }
    
    public void showAll(/*whatever list*/)
    {
        System.out.println(phoneBook);
    }
    
    public void addContact()
    {
    
    }
    
    public void narrowDown()
    {
    
    }
    
    public void modify()
    {
    
    }
    
    public void delete()
    {
    
    }
    
    public void select(/*whateverList*/)
    {
        int  contact   = 0;
        char selection = ' ';
        System.out.print("What contact would you like to look at? ");
        while(selection != 'm' || selection != 'd' || selection != 'b' || selection != 'c'){
            while(contact < 0 /* || contact > size of list */){
                String testContact = input.nextLine();
                try{
                    contact = Integer.parseInt(testContact);
                    // the whole "if size is not valid" thing
                } catch(Exception e) {
                    System.out.println("Invalid selection");
                }
                //switch
            }
            //trycatch
            //switch
            //case 'e'
            //    modify();
            //case 'd'
            //    delete();
        }
    }
}
    //add(index);
    //display();
    //remove();
    //display();
    //modify();
    //display();
             /*while(!phoneBook.isEmpty())
         {
             phoneBook.get(0);
         }
     
//.remove(index);

while(!phoneBook.isEmpty())
{
    phoneBook.display();
}

.modify(index, value);

.sort("parameter" e.g. last name);

.search(value != null);

.search(index);			PB search()
        
            .size(while != null);
    
    
        System.out.println(phoneBook);
    */