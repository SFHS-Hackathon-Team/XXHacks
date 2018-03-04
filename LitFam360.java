import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;
public class LitFam360 {
    
    static ArrayList<FamilyMember> family = new ArrayList<FamilyMember>();
    static ArrayList<Chore> chores = new ArrayList<Chore>();
    static ArrayList<Event> events = new ArrayList<Event>();
    static ArrayList<Period> periods = new ArrayList<Period>();
        
    public LitFam360() {
        initializeFamilyMembers();
        initializeChores();
        initializeEvents();
        initializePeriods();
    }
    
    private void initializeFamilyMembers(){
       try {
            Scanner in = new Scanner (new File("FamilyMembers.txt"));
            String str = "";
            int i = 0;
            while (in.hasNextLine()) {
                str = in.nextLine();
                family.add(new FamilyMember(str.split(",")));
                i++;
            }
            in.close();
       } catch (IOException j) {
            System.out.println("Error: " + j.getMessage());
       } 
    }
    
    private void initializeChores(){
       try {
            Scanner in = new Scanner (new File("Chores.txt"));
            String str = "";
            int i = 0;
            while (in.hasNextLine()) {
                str = in.nextLine();
                chores.add(new Chore(str.split(",")));
                i++;
            }
            in.close();
       } catch (IOException j) {
            System.out.println("Error: " + j.getMessage());
       } 
    }
    
    private void initializeEvents(){
       try {
            Scanner in = new Scanner (new File("Events.txt"));
            String str = "";
            int i = 0;
            while (in.hasNextLine()) {
                str = in.nextLine();
                events.add(new Event(str.split(",")));
                i++;
            }
            in.close();
       } catch (IOException j) {
            System.out.println("Error: " + j.getMessage());
       } 
    }
    
    private void initializePeriods(){
       try {
            Scanner in = new Scanner (new File("Period.txt"));
            String str = "";
            int i = 0;
            while (in.hasNextLine()) {
                str = in.nextLine();
                periods.add(new Period(str.split(",")));
                i++;
            }
            in.close();
       } catch (IOException j) {
            System.out.println("Error: " + j.getMessage());
       } 
    }
    
    public static void editPeriod(String member){
        Scanner in = new Scanner(System.in);
        System.out.println("When was the last period? ");      
        String name = in.nextLine();
        System.out.println("Please enter the average cycle length: ");      
        String password = in.nextLine();
        
        periods.add(new Period(member,name, password));  
    }
    
    public static void addFamilyMember(){
        Boolean period = false;
        
        Scanner in = new Scanner(System.in);
      
        System.out.println("Please enter the new family member's name: ");      
        String name = in.nextLine();
        System.out.println("Please enter the new family member's password: ");      
        String password = in.nextLine();
        System.out.println("Please enter the new family member's status (parent/child): ");      
        String status = in.nextLine();
        System.out.println("Does this person have periods?: ");  
        String resp = in.nextLine();
        if (resp.equals("yes")) {
            period = true;
            editPeriod(name);
        }
        
        family.add(new FamilyMember(name, password, status, period));  
    }
 
    public static void deleteFamilyMember(){
       Scanner in = new Scanner(System.in);
       System.out.println("Please enter the name you would like to delete: ");      
       String name = in.nextLine();
       
      for (int i = 0; i < family.size(); i++) {
         if(name.equals(family.get(i).getName())) {
           family.remove(i);  
         }
      }
       
       for(int i = 0; i < chores.size(); i++){
        if (chores.get(i).getFamilyMember().equals(name)){
          chores.remove(i);
        }
      }
    }      

    public static void updateFamilyFile() {
      FileWriter out;
      for (FamilyMember person : family) {
        try{
          if(person.getName().equals(family.get(0).getName())) {
              out = new FileWriter("FamilyMembers.txt");
          } else {
              out = new FileWriter("FamilyMembers.txt",true);
          }
          String str = person.getName() + "," + person.getPassword() + "," + person.getStatus();
          out.write(str);
          out.write("\r\n");
          out.close();
        }catch(IOException f){
          System.out.println("Error: " + f.getMessage());
        } 
      }
    }
    
    public static void addChore(){
        Scanner in = new Scanner(System.in);
      
        System.out.println("Please enter the name of the chore: ");      
        String name = in.nextLine();
        System.out.println("Please enter the family member responsible for the chore: ");      
        String password = in.nextLine();
        System.out.println("Please enter the due date: ");      
        String status = in.nextLine();
        chores.add(new Chore(name, password, status));  
    }
 
    public static void deleteChore(){
       Scanner in = new Scanner(System.in);
       System.out.println("Please enter the name of the chore: ");      
       String name = in.nextLine();
       
      for(int i = 0; i < chores.size(); i++){
        if (chores.get(i).getName().equals(name)){
          chores.remove(i);
        }
      }
    }      
    
    public static void deleteChore(String name){
      for(int i = 0; i < chores.size(); i++){
        if (chores.get(i).getName().equals(name)){
          chores.remove(i);
        }
      }
    }   

    public static void updateChoreFile() {
      FileWriter out;
      for (Chore chore : chores) {
        try{
          if(chore.getName().equals(chores.get(0).getName())) {
              out = new FileWriter("Chores.txt");
          } else {
              out = new FileWriter("Chores.txt",true);
          }
          String str = chore.getName() + "," + chore.getFamilyMember() + "," + chore.getDay();
          out.write(str);
          out.write("\r\n");
          out.close();
        }catch(IOException f){
          System.out.println("Error: " + f.getMessage());
        } 
      }
    }
    
    public static void addEvent(){
        Scanner in = new Scanner(System.in);
      
        System.out.println("Please enter the name of the event: ");      
        String name = in.nextLine();
        System.out.println("Please enter the family member featured in this event: ");      
        String password = in.nextLine();
        System.out.println("Please enter the date: ");      
        String status = in.nextLine();
        System.out.println("Please enter the time: ");      
        String time = in.nextLine();
        events.add(new Event(name, password, status, time));  
    }
 
    public static void deleteEvent(){
       Scanner in = new Scanner(System.in);
       System.out.println("Please enter the name of the event: ");      
       String name = in.nextLine();
       
      for(int i = 0; i < events.size(); i++){
        if (events.get(i).getName().equals(name)){
          events.remove(i);
        }
      }
    }      
    
    public static void deleteEvent(String name){
      for(int i = 0; i < events.size(); i++){
        if (events.get(i).getName().equals(name)){
          events.remove(i);
        }
      }
    }   

    public static void updateEventFile() {
      FileWriter out;
      for (Event event : events) {
        try{
          if(event.getName().equals(events.get(0).getName())) {
              out = new FileWriter("Events.txt");
          } else {
              out = new FileWriter("Events.txt",true);
          }
          String str = event.getName() + "," + event.getFamilyMember() + "," + event.getDay() + "," + event.getTime();
          out.write(str);
          out.write("\r\n");
          out.close();
        }catch(IOException f){
          System.out.println("Error: " + f.getMessage());
        } 
      }
    }
    
}
