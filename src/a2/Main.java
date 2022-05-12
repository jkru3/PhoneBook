// Joseph "Joey" Krueger
// Assignment 2
// CS145
//
// For this program, I used 3 classes to implement a linked list, which i used to make
// a simple phonebook program.
// For extra credit, I used protected objects and classes, a try/catch statements,
// and a sort function
//
// ADD -1 FUNCTIONALITY TO ADD METHOD
// MULTIPLE SORT METHODS

package a2;

import java.util.Scanner;

public class Main
{
    protected static Scanner input = new Scanner(System.in);
            //this scanner is also used by PhonebookManager
    
    public static void main(String[] args) //this is the main loop
    {
        PhonebookManager bellingham = new PhonebookManager();
        int              selection  = 0;
        boolean          boolSearch = false;
        
        while(selection != 4){
            System.out.printf("1. Show all contacts \t" + "2. Look up a contact \t" +
                              "3. Add a contact \t" + "4. Exit\n" +
                              "What would you like to do? ");
            selection = stringInputConvert(input);
            switch(selection){
                case 1:
                    bellingham.showAll();
                    break;
                case 2:
                    while(!boolSearch){
                        boolSearch = bellingham.narrowDown();
                    }
                    break;
                case 3:
                    bellingham.addContact();
                    break;
                default:
                    break;
            }
        }
    }
    
    protected static int stringInputConvert(
            Scanner input) //this class is used by both Main and PhonebookManager
    {
        int testInput = -1;
        while(testInput == -1){
            try{
                testInput = Integer.parseInt(input.nextLine());
            } catch(Exception e) {
                System.out.print("That is not a valid input: ");
            }
        }
        return testInput;
    }
}