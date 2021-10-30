package test;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Samochod s1 = new Samochod("BIA 12345", 1000, 115);
        Samochod s2 = new Samochod("BI 57131", 500, 400);
        Samochod s3 = new Samochod("WAW 10987", 320, 200);

        s1.start();
        s2.start();
        s3.start();
    }
}
