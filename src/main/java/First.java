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

        long number = (long) (Integer.MIN_VALUE + 1) * 100;
        System.out.println("Почему значение стало отрицательным? " + number);

        int i = 10000;
        double d = 10.7;
        double result = (i / d) * d + i;
        int resultInt = (int) (result % 15);
        System.out.println(result);
        System.out.println("Теперь хочу выводить в одной строке два значения: " + resultInt + ", " + result);
        System.out.println("How to push?");

    }
}
