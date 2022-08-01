public class First {
    public static void main(String[] args) {

        /*Смоделировать предметную область*/
        Worker worker = new Worker(20, "Dima");
        Company company = new Company(16, worker);

        if (company.getTime() > 18 && company.getTime() < 9) {
            worker.rest();
        } else {
            worker.work();
        }

        long number = (long) (Integer.MAX_VALUE + 1) * 100;
        System.out.println("\nПочему значение стало отрицательным? " + number);

        int i = 10;
        double d = 10.5;
        double result = (i / d) * d + i;
        int resultInt = (int) (result % 15);
        System.out.println(resultInt + " " + result);//todo marchenko do something
        System.out.println("How to push?");
    }
}
