// Joseph "Joey" Krueger
// Assignment 2
// CS145
//
// This class serves as a medium between ListNode and Main
// In this class, the user gets prompted to interact with the program and statements are
// printed into the console.


package a2;

public class PhonebookManager extends Main
{
    private ListNode phoneBook = new ListNode();
    private ListNode testBook  = new ListNode();
    
    public PhonebookManager() //this class could be implemented with file I/O but for the
    // sake of experimentation, I've left this with fixed elements.
    // Notice that the phonebook passes a new array, rather than individual variables
    {
        phoneBook.add(new String[] {"Hank", "Hill", "3607857639", "hank@strickland.com",
                                    "call for deals on propane and propane accessories"});
        phoneBook.add(new String[] {"Eugene", "Krabs", "3602557484",
                                    "ilikemoney@krustykrab.com", ""});
        phoneBook.add(
                new String[] {"Satya", "Nadella", "4257779821", "satyan@microsoft.com",
                              "hey Microsoft, you hiring?"});
        phoneBook.add(new String[] {"Bobby", "Hill", "3607852938",
                                    "thatsmypurse@strickland.com", ""});
        phoneBook.add(new String[] {"Kurt", "Cobain", "4256658927",
                                    "kurt@corporatesellouts.com", "he's dead"});
    }
    
    public void showAll() //prints all ListNode entries in phoneBook
    {
        boolean boolSearch = false;
        int     selection  = 0;
        int     index      = 0;
        
        System.out.println("\n\t~Contacts~");
        for(int i = 0; i < phoneBook.size(); i++){
            System.out.printf("%d. %-10s", i + 1, phoneBook.get(i, 0));
            System.out.printf("%-10s", phoneBook.get(i, 1));
            System.out.printf("%-17s", phoneBook.get(i, 2));//phone number
            System.out.printf("%-40s", phoneBook.get(i, 3));
            System.out.printf("%s%n", phoneBook.get(i, 4));
        }
        if(phoneBook.isEmpty()) {
            System.out.println("Phonebook is empty!");
            return;
        }
        while(selection < 1 || selection > 6){
            System.out.printf("\n" + "1. Refine results \t" + "2. Sort results \t" +
                              "3. Edit a contact \t" + "4. Delete a contact \t" +
                              "5. Add a contact \t" + "6. Go back\n" +
                              "What would you like to do? ");
            selection = stringInputConvert(input);
            switch(selection){
                case 1:
                    while(!boolSearch){
                        boolSearch = narrowDown();
                    }
                    break;
                case 2:
                    sort();
                    break;
                case 3:
                    edit();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    addContact();
                    break;
                default:
                    break;
            }
        }
    }
    
    public void addContact() //prompts the user to enter a new contact
    {
        System.out.print("What is contact's first name? ");
        String firstName = input.nextLine();
        System.out.print("What is contact's last name? ");
        String lastName = input.nextLine();
        System.out.print("What is contact's phone number? ");
        String phoneNumber = input.nextLine();
        while(phoneNumber.length() != 10){
            System.out.println("10-diget numbers only!");
            phoneNumber = input.nextLine();
        }
        System.out.print("What is contact's email? ");
        String address = input.nextLine();
        System.out.print("Additional notes: ");
        String notes = input.nextLine();
        phoneBook.add(new String[] {firstName, lastName, phoneNumber, address, notes});
        System.out.println("\nContact added!");
    }
    
    public boolean narrowDown()
    {
        boolean boolSearch = false;
        int     selection  = 0;
        if(phoneBook.isEmpty()) {
            System.out.println("Phonebook is empty!");
            return true;
        }
        System.out.print(
                "\nEnter information about the contact you'd like to " + "search for: ");
        String search = input.nextLine();
        
        System.out.println("\n\t~Search results~");
        for(int index = 0; index < phoneBook.size(); index++){
            if(phoneBook.contains(index, search)) {
                System.out.printf("%d. %-10s", index + 1, phoneBook.get(index, 0));
                System.out.printf("%-10s", phoneBook.get(index, 1));
                System.out.printf("%-17s", phoneBook.get(index, 2));
                System.out.printf("%-40s", phoneBook.get(index, 3));
                System.out.printf("%s%n", phoneBook.get(index, 4));
                testBook.add(phoneBook.stringAt(index));
            }
        }
        if(testBook.isEmpty()) {
            System.out.println("No results found");
            return false;
        }
        
        while(selection < 1 || selection > 5){
            System.out.printf("\n1. Search again \t" + "2. Show all contacts \t" +
                              "3. Edit a contact \t" + "4. Delete a contact \t" +
                              "5. Go back\n" + "What would you like to do? ");
            selection = stringInputConvert(input);
            switch(selection){
                case 1:
                    while(!boolSearch){
                        boolSearch = narrowDown();
                    }
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    edit();
                    break;
                case 4:
                    delete();
                    break;
                default:
                    break;
            }
        }
        return true;
    }
    
    private void delete()
    {
        System.out.print("What index would you like to delete? ");
        int index = validIndex();
        phoneBook.remove(index - 1);
        System.out.printf("\nContact deleted!\n\n");
    }
    
    public void sort()
    {
    }
    
    public void edit()
    {
        int    index     = 0;
        int    selection = 0;
        String edit      = "";
        
        System.out.print("What contact (Integer) would you like to edit? ");
        index = validIndex();
        while(selection < 1 || selection > 6){
            System.out.print(
                    "1. First name \t" + "2. Last name \t" + "3. Phone number \t" +
                    "4. Email \t" + "5. Notes \t" + "6. Cancel\n" +
                    "What would you like to edit? ");
            selection = stringInputConvert(input);
            switch(selection){
                case 1:
                    System.out.print("New first name: ");
                    break;
                case 2:
                    System.out.print("New last name: ");
                    break;
                case 3:
                    System.out.print("New phone number: ");
                    break;
                case 4:
                    System.out.print("New email: ");
                    break;
                case 5:
                    System.out.print("Additional notes: ");
                    break;
                default:
                    return;
            }
        }
        edit = input.nextLine();
        phoneBook.modify(index - 1, selection - 1, edit);
    }
    
    public int validIndex()
    {
        int index = stringInputConvert(input);
        while(index < 1 || index > phoneBook.size()){
            System.out.print("That is not a valid Index number: ");
            index = stringInputConvert(input);
        }
        return index;
    }
}