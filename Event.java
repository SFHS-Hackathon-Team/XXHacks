public class Event
{
    private String name;
    private String familyMember;
    private String day;
    private String time;
    
    public Event(String[] array){
        this.name = array[0];
        this.familyMember = array[1];
        this.day = array[2];
        this.time = array[3];
    }
    
    public Event(String n, String f, String d, String t){
        this.name = n;
        this.familyMember = f;
        this.day = d;
        this.time = t;
    }
    
    public String getName(){
        return this.name;
    }

    public String getFamilyMember(){
        return this.familyMember;
    }
    
    public String getDay(){
        return this.day;
    }
    
    public String getTime(){
        return this.time;
    }

    public String toString(){
        return this.name + " - " + this.familyMember + " - Date: " + this.day + " - Time: " + this.time;
    }

}
