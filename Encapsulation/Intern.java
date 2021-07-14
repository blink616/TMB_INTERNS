//Encapsulation Example


public class Intern {
    //private class variables direct access will be denied
    private String name;
    private int age;
    private String Expertise;

    //public getter/setter methods to set the object attributes
    public void setName(String name){
        this.name = name;
    }
    public void setExpertise(String Expertise){
        this.Expertise = Expertise;
    }
    public String getExpertise(){
        return Expertise;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
}
