public class Worker {
    private int age;
    private String name;

    public Worker(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void work() {
        System.out.println("I'm working");
    }

    public void rest() {
        System.out.println("I'm relaxing");
    }
}
