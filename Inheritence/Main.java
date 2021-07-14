public class Main {
    public static void main(String[] args) {

        Car myCar = new Car();
        //setting the object attributes using setter methods
        myCar.setBrand("BMW");
        myCar.setModelName("M5");

        //accessing the object attributes using getter methods
        System.out.println("output");
        System.out.println(myCar.getBrand());
        System.out.println( myCar.getModelName());
        myCar.honk();

    }
}