import java.util.Scanner;
public class StudentGradeFinder {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total Number of Subjects You have:");
        int sub = sc.nextInt();
        int Nsub[] = new int[sub];
        int totalMarks = 0;
        for(int i=0;i<sub;i++)
        {
            System.out.println("Enter the "+(i+1)+"th subject Marks(for 100) :");
            Nsub[i]= sc.nextInt();
            totalMarks += Nsub[i];
        }
        double percentage = (totalMarks / (sub * 100.0))*100;
        System.out.println("Your total score is : "+totalMarks+" and \nyour Percentage is :"+percentage);
        if(percentage > 90.0){
            System.out.println("Yor Grade is A+");
        }
        else if(percentage > 80.0){
            System.out.println("Your Grade is A");
        }
        else if(percentage > 70.0){
            System.out.println("Your Grade is B+");
        }
        else if(percentage > 60.0){
            System.out.println("Your Grade is B");
        }
        else if(percentage > 50.0){
            System.out.println("Your Grade is C");
        }
        else if(percentage > 40.0){
            System.out.println("Your Grade is D, and you just passed your Exam.");
        }
        else{
            System.out.println("Your are Failed in exams, Better luck next time.");
        }
    }
}
