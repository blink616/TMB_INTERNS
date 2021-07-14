public class Main {
    public static void main(String[] args) {

        Intern newIntern = new Intern();
        //setting the object attributes using setter methods
        newIntern.setName("Hamiz Ali");
        newIntern.setAge(21);
        newIntern.setExpertise("Backend");
        //accessing the object attributes using getter methods
        System.out.println("Name: " + newIntern.getName());
        System.out.println("Age: " + newIntern.getAge() + "years");
        System.out.println("Expertise: " + newIntern.getExpertise());
    }
}