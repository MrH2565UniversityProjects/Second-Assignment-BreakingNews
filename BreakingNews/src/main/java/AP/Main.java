package AP;

import java.util.Scanner;

public class Main
{//
    public static void main(String[] args)
    {
        Infrastructure infrastructure = new Infrastructure("9020d2e8e11344779a04af783278f541");
        if(!infrastructure.displayNewsList()){
            return;
        }
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("\nEnter the number of the news article to read more (500 for exit):");

            while (!scanner.hasNextInt())
            {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
            int choice = scanner.nextInt();
            if (choice > 0 && choice <= infrastructure.getNewsList().size())
            {
                infrastructure.getNewsList().get(choice - 1).displayNews();
            }
            else if(choice == 500){
                break;
            }
            else
            {
                System.out.println("Invalid number .Please enter a number between 1 and " + infrastructure.getNewsList().size());
            }
        }
        scanner.close();
    }
}