import java.util.*;
public class NumberGuessGame{
    static int gameStart(){
        Scanner sc = new Scanner(System.in);
        int targetNum = (int)(Math.random()*101);
        boolean target = false;
        int timeConsumed =0;
        int guess = 0;
        while(target == false){
            System.out.println("Guess the number:");
            guess = sc.nextInt();
            if(guess == targetNum)
            {
                System.out.println("\n\nHurry!! you guessed it right the number is '"+targetNum+"' and you guessed after "+timeConsumed+" times of loss.");
                return 0;
            }
            else{
                timeConsumed++;
                if(targetNum > guess)
                {
                    System.out.println("Your guessing SMALLER than the Target value. Enter the 'Exit' to quit the game:");
                    if(sc.nextLine() == "Exit");
                }
                else{
                    System.out.println("Your guessing GREATER than the Target value. Enter the 'Exit' to quit the game:");
                    if(sc.nextLine() == "Exit");
                }
            }
        }
        return 0;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int isStart = 0;
        do{
            gameStart();
            System.out.println("Enter '1' for Start / Restart the Game:");
            isStart = sc.nextInt();
        }while(isStart==1);
        sc.close();
    }
}