import java.util.*;
class Bank{
    static int accEnd=0;
    long phone;
    String name;
    String ref="1SB23CS1100";
    String accNum;
    float ballance;

    //Create Account
    void createAcc(Scanner sc){
        System.out.println("Enter your Name:");
        sc.nextLine();
        name = sc.nextLine();
        System.out.println("Enter your Mobil Number:");
        phone = sc.nextLong();
        System.out.println("Enter your Initial Amount:");
        ballance = sc.nextFloat();
        accNum = ref + accEnd++;
        System.out.println("Account Created Successfully and your Account number is :"+accNum);
        sc.nextLine();
    }
}
public class AtmMachine{

    // Withdraw Method
    void withdraw(Bank clint,String withacc,float withAmt){
        clint.ballance -= withAmt;
        System.out.println("The balance amout after the withdrawl of $"+withAmt+" in the account "+withacc+" is : $"+clint.ballance);
    }

    //Deposit Method
    void deposit(Bank clint,String depositacc,float depositAmt){
        clint.ballance += depositAmt;
        System.out.println("The balance amout after the Deposition of $"+depositAmt+"in the account "+depositacc+" is : $"+clint.ballance);
    }

    //Check Bank Ballance
    void checkBallance(Bank clint,String checkacc){
        System.out.println("The Account "+checkacc+" has $"+clint.ballance);
    }
    //Show Details of all the Clients
    void showDetails(Bank clint,int i){
        System.out.println(i+"  \t"+clint.accNum+" \t"+clint.phone+"\t $"+clint.ballance+"\t\t"+clint.name);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int clintNum = 0;
        int choice;
        Bank[] clint = new Bank[1000];
        while(true)
        {
            System.out.println("\n\n\t----* Welcome to the Sairam Bank of Karnataka *----\n");
            System.out.println("Choice the service below:\n1.Create an Account.\n2.Withdraw Money.\n3.Deposit Money.\n4.Check Account Ballance.\n5.Check the Details of the Clients(Not for the clients use don't choose this option if your not a Bank Employee).");
            choice = sc.nextInt();
            AtmMachine a = new AtmMachine();
            boolean isFound = false;
            float amount =0;
            String account;
            switch(choice)
            {
                case 1:
                    clint[clintNum] = new Bank();
                    clint[clintNum++].createAcc(sc);
                    break;
                case 2:
                    System.out.println("You chosse '2' to Withdraw Amount\nEnter your Account Number:");
                    account = sc.next();
                    System.out.println("Enter the Amount you want to withdraw:\n");
                    amount = sc.nextFloat();       
                    for(int i=0;i<clintNum;i++)
                    {
                        if(clint[i].accNum.equals(account)){    
                            a.withdraw(clint[i],account,amount);
                            isFound = true;
                        }
                    }
                    if(!isFound)
                    System.out.println("The Account with the number "+account+" is not Found.");
                    break;
                case 3:
                    System.out.println("You chosse '3' to Deposit Amount\nEnter your Account Number:");
                    account = sc.next();
                    System.out.println("Enter the Amount you want to deposit:\n");
                    amount = sc.nextFloat();       
                    for(int i=0;i<clintNum;i++)
                    {
                        if(clint[i].accNum.equals(account)){    
                            a.deposit(clint[i],account,amount);
                            isFound=true;
                        }
                    }
                    if(!isFound)
                    System.out.println("The Account with the number "+account+" is not Found.");
                    break;
                case 4:
                    System.out.println("You chosse '4' to Check Account Ballance Amount\nEnter your Account Number:");
                    account = sc.next();      
                    for(int i=0;i<clintNum;i++)
                    {
                        if(clint[i].accNum.equals(account)){    
                            a.checkBallance(clint[i],account);
                            isFound = true;
                        }
                    }
                    if(!isFound)
                    System.out.println("The Account with the number "+account+" is not Found.");
                    break;
                case 5:
                    System.out.println("You choose '5' then you must be the banker, choose the password:");
                    sc.nextLine();
                    String password = sc.nextLine();
                    if("SROK".equals(password)){
                        System.out.println("S.NO\tAccount Number\t Phone Number\t Ballance \tAccount Holder Name");
                        for(int i=0;i<clintNum;i++)
                        {
                            a.showDetails(clint[i],i);
                        }
                    }
                    else{
                        System.out.println("The Password is Incorrect !!, Try Again.");
                    }
                    break;
                default:
                    System.out.println("Invalid Input, Choose the available choice only.");
            }
        }
    }
}