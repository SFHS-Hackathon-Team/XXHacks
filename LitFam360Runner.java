import java.util.Scanner;

public class LitFam360Runner
{
    private static LitFam360 myFamily = new LitFam360();
    private static boolean run_program = true;
    private static Scanner in = new Scanner(System.in);
    private static int input;
    
    private static FamilyMember member;

    private static void login() {
        member = myFamily.family.get(0);
        boolean username = false;
        boolean password = false;
        int count = 0;
        
        System.out.println("LOGIN:");
        System.out.println("Please enter your name: ");
        while (username == false) {
            Scanner input = new Scanner(System.in);
            String name = input.nextLine();
            for(FamilyMember person : myFamily.family) {
                if (name.equals(person.getName())) {
                    username = true;
                    member = person;
                    break;
                }
                count++;
            }
            if (username) {
                System.out.println("\n\n");
                break;
            } else if (count >= 10) {
                System.out.println("Too many errors. Please restart the app.");
                break;
            } else {
                System.out.println("Please enter a valid name: ");
            }
        }
        
        if (username) {
            count = 0;
            System.out.println("Please enter your password: ");
            while (password == false) {
                Scanner input = new Scanner(System.in);
                String pass = input.nextLine();
                if (pass.equals(member.getPassword())) {
                    password = true;
                    break;
                }
                    count++;
                if (password) {
                    System.out.println("\n\n");
                    break;
                } else if (count >= 10) {
                    System.out.println("Too many errors. Please restart the app.");
                    break;
                } else {
                    System.out.println("Wrong password. Please try again: ");
                }
            }
        }
        System.out.println("\n\n");
    }
    
    private static void display_menu() {
        if (member.getStatus().equals("parent")) {
            System.out.println("1 - Manage Family");
            System.out.println("2 - Mangage Family Chores");
            System.out.println("3 - Display My Chores");
            System.out.println("4 - Manage Events");
        } else {
            System.out.println("1 - Display Family");
            System.out.println("2 - Display Family Chores");
            System.out.println("3 - Display My Chores");
            System.out.println("4 - Manage Events");
        }
        if (member.getPeriod()) {
            System.out.println("5 - Manage Period");
        }
        System.out.println("Any other key - Terminate Program");
    }
    
    private static void manage_family_display_menu() {
        System.out.println("1 - Add Family Member");
        System.out.println("2 - Delete Family Member");
    }
   
    private static void displayFamilyMembers(){
        for(FamilyMember person : myFamily.family){
            System.out.println(person.toString());
        }
        System.out.println("\n\n");
    }
    
    private static void displayFamilyChores(){
        for(Chore chore : myFamily.chores){
            System.out.println(chore.toString());
        }
        System.out.println("\n\n");
    }
    
    private static void displayMyChores(){
      for(Chore chore : myFamily.chores){
        if (chore.getFamilyMember().equals(member.getName())){
          System.out.println(chore.toString());
        }
      }
      
      System.out.println("Did you finish any of your chores?");
      Scanner in = new Scanner(System.in);
      if (in.nextLine().equals("yes")) {
          System.out.println("Please enter the name of the chore you have completed: ");
          String chore = in.nextLine();
          LitFam360.deleteChore(chore);
          LitFam360.updateChoreFile();
      }
    }
    
    private static void displayEvents(){
      Scanner inp = new Scanner(System.in);
      for(Event event : myFamily.events){
          System.out.println(event.toString());
      }
      
      System.out.println("Would you like to edit events?");
      String response = inp.nextLine();
      if (response.equals("yes")) {
          System.out.println("1 - Add Event");
          System.out.println("2 - Delete Event");
          int respons = inp.nextInt();
          if (respons == 1) {
                    LitFam360.addEvent();
                    LitFam360.updateEventFile();
          } else if (respons == 2){
                    LitFam360.deleteEvent();
                    LitFam360.updateEventFile();
          }
      }
    }
    
    public static void displayPeriod(){
        Scanner in = new Scanner(System.in);
        int period = 0;
        for(int i = 0; i < myFamily.periods.size(); i++){
          if (myFamily.periods.get(i).getFamilyMember().equals(member.getName())) {
              period = i;
            }
        }
      
        System.out.println("Your last period was " + myFamily.periods.get(period).getLastDate() + " and your average cycle length is " + myFamily.periods.get(period).getCycleLength());    
        System.out.println("Did you have a period?");
        String r = in.nextLine();
        if (r.equals("yes")) {
            System.out.println("What day did it start?");
            myFamily.periods.get(period).setLastDate(in.nextLine());
        }
        
    }
      
    private static void run_child_option(int new_input){
        Scanner in = new Scanner(System.in);
        if(new_input == 1) {
           System.out.println("\n");
           displayFamilyMembers();
           System.out.println("\n");
        } else if (new_input == 2){
            System.out.println("\n");
            displayFamilyChores();
            System.out.println("\n");
        } else if (new_input == 3) {
            System.out.println("\n");
            displayMyChores();
            System.out.println("\n");
        } else if (new_input == 4) {
            displayEvents();
        } else if (new_input == 5) {
            displayPeriod();
        } else
            System.exit(0);
    }
    
    private static void run_parent_option(int new_input){
        Scanner in = new Scanner(System.in);
        if(new_input == 1) {
           System.out.println("\n");
           displayFamilyMembers();
           manage_family_display_menu();
                int inp = in.nextInt();
                if (inp == 1) {
                    LitFam360.addFamilyMember();
                    LitFam360.updateFamilyFile();
                } else if (inp == 2){
                    LitFam360.deleteFamilyMember();
                    LitFam360.updateFamilyFile();
                }
           displayFamilyMembers();
           System.out.println("\n");
        } else if (new_input == 2){
            System.out.println("\n");
            displayFamilyChores();
            System.out.println("1 - Add Chore");
            System.out.println("2 - Delete Chore");
                int inp = in.nextInt();
                if (inp == 1) {
                    LitFam360.addChore();
                    LitFam360.updateChoreFile();
                } else {
                    LitFam360.deleteChore();
                    LitFam360.updateChoreFile();
                }
            displayFamilyChores();
            System.out.println("\n");
        } else if (new_input == 3) {
            System.out.println("\n");
            displayMyChores();
            System.out.println("\n");
        } else if (new_input == 4) {
            displayEvents();
        } else if (new_input == 5) {
            displayPeriod();
        }else {
            System.exit(0);
        }
    }

    public static void main(String[] args){
        login();
        if (member.getStatus().equals("child")) {
            while(run_program){
                display_menu();
                input = in.nextInt();
                run_child_option(input);
            }
        } else {
            while(run_program){
                display_menu();
                input = in.nextInt();
                run_parent_option(input);
            }
        }
        
    }
}
