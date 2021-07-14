public class Vehicle {
    private String brand;        // Vehicle parent class

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void honk() {                    // Vehicle method
        System.out.println("honk, honkkk!");
    }
}

class Car extends Vehicle { //extend parent class and attributes
    private String modelName;    // Car attribute

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }
}