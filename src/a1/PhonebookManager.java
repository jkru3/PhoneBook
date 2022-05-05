package a1;

import java.util.LinkedList;
import java.util.Scanner;

public class PhonebookManager //extends ListNode
{
    //ListNode pb = new ListNode();
    //private ListNode front;
    private Scanner    input     = new Scanner(System.in);
    private LinkedList<ListNode> phoneBook = new LinkedList<>();
    private LinkedList<Integer> indexes = new LinkedList<>();
    
    
    public PhonebookManager()
    {
        phoneBook.add(new ListNode("penis", "muncher"));
        phoneBook.add(new ListNode("penis", "muncher"));
        phoneBook.add(new ListNode("him", "muncher"));
        phoneBook.add(new ListNode("gang", "muncher"));
        phoneBook.add(new ListNode("penis", "yung"));
    
    
    }
    
    
    
    public void showAll(/*whatever list*/)
    {
        int selection = 0;
        System.out.println();
        for(int i = 0; i < phoneBook.size(); i++)
            System.out.print((i + 1) + ". " + phoneBook.get(i) + "\n");
        if(phoneBook.isEmpty())
        {
            System.out.println("Phonebook is empty!");
            return;
        }
        System.out.printf("\n" +
                          "1. Refine results \t" +
                          "2. Sort results \t" +
                          "3. Select a contact \t" +
                          "4. Add a contact\n" +
                          "What would you like to do? ");
        while(selection < 1 || selection > 4)
        {
            String testSelection = input.nextLine();
            try{
                selection = Integer.parseInt(testSelection);
                if(selection > 4 || selection < 1)
                    System.out.println("Invalid selection ");
            } catch(Exception e) {
                selection = 0;
                System.out.println("Invalid selection ");
            }
        }
        switch(selection)
        {
            case 1:
                narrowDown();
                break;
            case 2:
                sort();
                break;
            case 3:
                select(phoneBook);
                break;
            case 4:
                addContact();
                break;
            default:
                break;
        }
    }
    
    public void addContact()
    {
        System.out.print("\nWhat is contact's first name?");
        String firstName = input.nextLine();
        System.out.print("\nWhat is contact's last name?");
        String lastName = input.nextLine();
        phoneBook.add(new ListNode(firstName, lastName));
        System.out.println("\nContact added!");
    }
    
    public void narrowDown(LinkedList indexes)
    {
        int selection = 0;
        
        if(phoneBook.isEmpty())
        {
            System.out.println("Phonebook is empty!");
            return;
        }

        System.out.print("Enter information about the contact you would like to " +
                         "search for: ");
        String search = input.nextLine();
        for(int index = 0; index < phoneBook.size(); index++)
        {
            if((phoneBook.get(index).toString()).contains(search))
            {
                System.out.println((index + 1) + ". " + phoneBook.get(index));
                indexes.add(index);
            }
        }
    
        while(selection < 1 || selection > 3){
            System.out.printf(
                    "1. Select a contact \t" + "2. Show all contacts \t" + "3. Cancel" +
                    "What would you like to do? ");
            String testSelection = input.nextLine();
            try{
                selection = Integer.parseInt(testSelection);
                if(selection > 4 || selection < 1)
                    System.out.println("Invalid selection");
            } catch(Exception e) {
                selection = 0;
                System.out.println("Invalid selection");
            }
        }
        switch(selection)
        {
            case 1:
                select(indexes);
                break;
            case 2:
                showAll();
                break;
            default:
        }
        
        while(!indexes.contains(selection))
        {
            System.out.printf("1. Select a contact \t" + "2. Show all contacts \t" +
                              "3. Go back");
            String testSelection = input.nextLine();
            try{
                selection = Integer.parseInt(testSelection);
                if(!indexes.contains(selection))
                    System.out.println("Invalid selection");
            } catch(Exception e) {
                selection = 0;
                System.out.println("Invalid selection");
            }
        }
    }
    
    public void modify()
    {
        String search = input.nextLine();
        if(phoneBook.contains(search));
            System.out.println("yeet");
    }
    
    public void delete(LinkedList book, int contact)
    {
        book.remove(contact - 1);
    }
    
    public void select(LinkedList indexes)
    {
        int contact   = 0;
        int selection = 0;
        System.out.print("What contact would you like to look at?: ");
        while(selection < 1 || selection > 3)
        {
            while(contact < 1 || contact > phoneBook.size())
            {
                String testContact = input.nextLine();
                try{
                    contact = Integer.parseInt(testContact);
                    if(contact <= 0 || contact > phoneBook.size()) {
                        System.out.print("Invalid selection");
                    }
                } catch(Exception e) {
                    selection = 0;
                    System.out.print("Invalid selection");
                }
            }
            System.out.print(
                    "---> " + phoneBook.get(contact - 1) + "\n" + "1. Modify \t" +
                    "2. Delete \t" + "3. Cancel\n" + "What would you like to do? ");
            String testSelection = input.nextLine();
            try
            {
                selection = Integer.parseInt(testSelection);
                if(selection < 1 || selection > 3)
                {
                    System.out.print("Invalid selection");
                }
            } catch(Exception e) {
                System.out.print("Invalid selection");
            }
        }
        switch(selection)
        {
            case 1:
                modify();
                break;
            case 2:
                delete(phoneBook, contact);
                break;
            default: // no need to build a case 3, brings you to main menu
                break;
        }
    }
    
    public void sort()
    {
    
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