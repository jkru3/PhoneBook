package a1;
import java.util.Scanner;

public class PhonebookTest
{
    public static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        PhonebookManager bellingham = new PhonebookManager();
        int              selection  = 0; // Integer object?
        boolean          exit       = false;
    
        while(selection != 4)
        {
            System.out.printf("\n1. Show all contacts \n" + "2. Look up a contact \n" +
                              "3. Add a contact \n" + "4. Exit \n" +
                              "What would you like to do? ");
            String testSelection = input.nextLine();
            try{
                selection = Integer.parseInt(testSelection);
                if(selection > 4 || selection < 1)
                    System.out.println("Invalid selection");
            } catch(Exception e) {
                System.out.println("Invalid selection");
            }
        
            switch(selection){
                case 1:
                    bellingham.showAll();
                    break;
                default:
                    break;
            }
        }
    }
}