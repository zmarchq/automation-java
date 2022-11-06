package testdata;

import java.util.List;

public class Company {
    String name;
    String inn;
    String address;
    List<Department> departments;

    static class Department {
        Integer id;
    }
}


