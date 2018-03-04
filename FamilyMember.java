public class FamilyMember {
    
    private String name;
    private String status;
    private Boolean period;
    private String password;
    
    public FamilyMember(String[] array){
        this.name = array[0];
        this.password = array[1];
        this.period = Boolean.parseBoolean(array[2]);
        this.status = array[3];
    }
    
    public FamilyMember(String n, String p, String s, Boolean g){
        this.name = n;
        this.password = p;
        this.period = g;
        this.status = s;
    }
    
    public String getName(){
        return this.name;
    }
    
    public Boolean getPeriod(){
        return this.period;
    }

    public String getStatus(){
        return this.status;
    }
    
    public String getPassword(){
        return this.password;
    }
    

    public String toString(){
        return this.name + " - " + this.status;
    }
    
}