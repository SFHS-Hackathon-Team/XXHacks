import java.util.Scanner;
public class Period
{
    private String familyMember;
    private String lastDate;
    private String cycleLength;
    
    public Period(String[] array){
        this.familyMember = array[0];
        this.lastDate = array[1];
        this.cycleLength = array[2];
    }
    
    public Period(String n, String f, String d){
        this.familyMember = n;
        this.lastDate = f;
        this.cycleLength = d;
    }

    public String getFamilyMember(){
        return this.familyMember;
    }
    
    public String getLastDate(){
        return this.lastDate;
    }
    
    public void setLastDate(String s){
        lastDate = s;
    }
    
    public String getCycleLength(){
        return this.cycleLength;
    }

    public String toString(){
        return "Last Date: " + this.lastDate + " - Cycle Length: " + this.cycleLength;
    }
}
