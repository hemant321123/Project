
import java.util.Scanner;
import java.util.Random;

public class Rock_Paper_Scissor_Game {
    public static void main(String[] args) {

        // 0 for ROCK
        // 1 for PAPER
        // 2 for SCISSOR
        Scanner sc= new Scanner(System.in);
        System.out.println("ENTER 0 FOR ROCK , 1 FOR PAPER, 2 FOR SCISSOR ");
        System.out.print("\n USER CHOICE : ");
        int userinput = sc.nextInt();


        Random rd = new Random();
        int computerinput = rd.nextInt(3);
        //System.out.println("\n COMPUTER CHOICE :"  + computerinput);
        if(computerinput==0){
            System.out.println("\nCOMPUTER CHOICE : "  + "ROCK");
        }
        else if(computerinput==1){
            System.out.println("\nCOMPUTER CHOICE : " + "PAPER");
        }
        else{
            System.out.println("\nCOMPUTER CHOICE :" + "SCISSOR");
        }
        if(userinput==computerinput){
            System.out.println("\n RESULT : DRAW !");
        }
        else if(userinput==0 && computerinput==2 || userinput==1 && computerinput==0 || userinput==2 && computerinput==1){
            System.out.println("\n RESULT : YOU WIN !");

        }
        
        else{
            System.out.println("\n RESULT : COMPUTER WIN !");
        }


    }
    
}

