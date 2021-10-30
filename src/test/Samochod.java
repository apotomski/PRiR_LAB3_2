package test;

public class Samochod extends Thread{
    private String nrRej;
    private int pojZbiornika;
    private int paliwo;
    private int liczbaTankowan;
    private boolean hamowanie;

    public Samochod(String nrRej,  int pojZbiornika, int paliwo) {
        this.nrRej = nrRej;
        this.paliwo = paliwo;
        this.pojZbiornika = pojZbiornika;
        this.liczbaTankowan = 0;
        this.hamowanie = false;
    }
    public void tankowanie(int _paliwo) {
        this.paliwo += _paliwo;
        System.out.println("[" + this.nrRej + "] tankuje " + _paliwo + " paliwa");

        this.liczbaTankowan++;
    }

    @Override
    public void start() {
        System.out.println("Samochod o numerze rejestracyjnym:" + this. nrRej + " zostal odpalony *Brum Brum*");
        super.start();
    }

    public void zatrzymajSie() {
        System.out.println("[" + this.nrRej + "] zatrzymuje sie *hamowanie*");
        this.hamowanie = true;
    }

    @Override
    public void run() {
        while(!hamowanie) {
            if(this.liczbaTankowan >= 10)
                    this.zatrzymajSie();
            else {
                try {
                    if (this.paliwo <= 100) {
                        System.out.println("Samochod o numerze rejestracyjnym:" + this.nrRej + " tankuje");
                        this.tankowanie((this.pojZbiornika / 10) + 100 + (this.pojZbiornika % 10));
                        Thread.sleep(2000);
                    } else {
                        System.out.println("Samochod o numerze rejestracyjnym:" + this.nrRej + " jedzie *zium zium*[paliwo(" + this.paliwo + "/" + this.pojZbiornika + ")]");
                        this.paliwo -= 1;
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {

                }
            }
        }
    }


}
