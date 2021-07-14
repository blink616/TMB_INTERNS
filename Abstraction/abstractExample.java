
abstract class Animal {

    public abstract void animal();
}


class Cat extends Animal {
    public void animal() {
        System.out.println("I am a cat");
    }
}

class abstractExample{
    public static void main(String[] args) {
        Cat myCat = new Cat();
        myCat.animal();
    }
}