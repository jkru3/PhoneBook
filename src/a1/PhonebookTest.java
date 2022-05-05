package a1;
import java.util.Scanner;

public class PhonebookTest
{
    protected static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        PhonebookManager bellingham = new PhonebookManager();
        int              selection  = 0; // Integer object?
    
        while(selection != 4)
        {
            System.out.printf("1. Show all contacts \t" + "2. Look up a contact \t" +
                              "3. Add a contact \t" + "4. Exit\n" +
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
        
            switch(selection){
                case 1:
                    bellingham.showAll();
                    break;
                case 2:
                    bellingham.narrowDown();
                    break;
                case 3:
                    bellingham.addContact();
                    break;
                default:
                    break;
            }
        }
    }
}