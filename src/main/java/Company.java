import java.util.ArrayList;

public class Company {
    private int time;
    private Worker worker;


    public Company(int time, Worker worker) {
        this.time = time;
        this.worker = worker;
    }

    public int getTime() {
        return time;
    }
}
