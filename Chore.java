public class Chore {
    
    private String name;
    private String familyMember;
    private String day;
    
    public Chore(String[] array){
        this.name = array[0];
        this.familyMember = array[1];
        this.day = array[2];
    }
    
    public Chore(String n, String f, String d){
        this.name = n;
        this.familyMember = f;
        this.day = d;
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

    public String toString(){
        return this.name + " - " + this.familyMember + " - Do by: " + this.day;
    }

}
