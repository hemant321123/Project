package Project1;
import java.util.*;
class Reservation {
    String name;
    String trainNumber;
    String trainName;
    String classType;
    String date;
    String from;
    String to;
    String pnr;

    Reservation(String name, String trainNumber,String trainName, String classType,String date, String from, String to, String pnr){
        this.name = name;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.date = date;
        this.from = from;
        this.to = to;
        this.pnr = pnr;
    }

}

public class OnlineReservationSystem {
    static Scanner sc = new Scanner(System.in);
    static HashMap<String,Reservation> database = new HashMap<>();
    static final String USERNAME = "admin";
    static final String PASSWORD = "1234";

    // Login Form
     public static boolean login(){
        System.out.print("Enter Username :- ");
        String user = sc.nextLine();
        System.out.print("Enter password :- ");
        String pass = sc.nextLine();

        if(user.equals(USERNAME) && pass.equals(PASSWORD)){
            System.out.println("\n Login Successfull ! \n");
            return true;
        }
        else{
            System.out.println("\n Invalid Login. Try Again. \n");
            return false;
        }
     }

    //  Reservation Form

     public static void makeReservation(){
        System.out.println("---Reservation Form---");
        System.out.print("Enter Passenger Name :- ");
        String name = sc.nextLine();
        System.out.print("Enter Train Number :- ");
        String trainNumber = sc.nextLine();
        System.out.print("Enter Train Name :- ");
        String trainName = sc.nextLine();
        System.out.print("Enter Class Type :- ");
        String classType = sc.nextLine();
        System.out.print("Enter Journey date(DD/MM/YYYY) :- ");
        String date = sc.nextLine();
        System.out.print("From :- ");
        String from = sc.nextLine();
        System.out.print("To :- ");
        String to = sc.nextLine();

        String pnr = "PNR " +  new Random().nextInt(99999);

        Reservation r = new Reservation(name, trainNumber, trainName, classType, date, from, to, pnr);
        database.put(pnr,r);

        System.out.println("\nReservation Successfull!");
        System.out.println("Your PNR Number :" + pnr +"\n");

        
    }
    // Cancellation Form

    public static void cancelReservation(){
        System.out.print("\nEnter PNR to cancel :- ");
        String pnr = sc.nextLine();

        if(database.containsKey(pnr)){
            Reservation r = database.get(pnr);
            System.out.println("\n Reservation Found !");
            System.out.println("Name :- " +r.name);
            System.out.println("TrainName :- " + r.trainName +"("+r.trainNumber +")");
            System.out.println("Journey :- " +r.from +" -> "+r.to);
            System.out.println("Date :- "+ r.date);
            System.out.print("\nConfirm cancellation(yes/no):- ");
            String confirm = sc.nextLine();

            if(confirm.equalsIgnoreCase("yes")){
                database.remove(pnr);
                System.out.println("\nReservation Cancelled Successfully!\n");

            }
            else{
                System.out.println("\nCancellation Aborted.\n");
            }
        }
        else{
            System.out.println("Invalid PNR. No Record Found.\n");
        }
     }
     public static void main(String[] args) {
        System.out.println("**** ONLINE RESERVATION SYSTEM****");

        while(true){
            if(!login())continue;
            while(true){
                System.out.println("1.Make Reservation");
                System.out.println("2.Cancel Reservation");
                System.out.println("3.Exit");
                System.out.print("Choose Option :- ");
                int choice = Integer.parseInt(sc.nextLine());

                switch(choice){
                    case 1:
                        makeReservation();
                        break;
                    case 2:
                        cancelReservation();
                        break;
                    case 3:
                        System.out.println("\n Thank You for using the system!");
                        return;
                    default:
                        System.out.println("\nInvalid Option!\n");
                }
            }
        }
     }
}
    

