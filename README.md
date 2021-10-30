# PRiR_LAB3_2
PRiR lab 3 projekt 2. Uzupełnienie szkieletu samochodu i wywołanie 3 sztuk aby sobie pracowały na wątkach.

Opis kodu 
Main

utworznie 3 obiektów klasy samochud i wywołanie pracy na wątkach

     public static void main(String[] args) {
	// write your code here
        Samochod s1 = new Samochod("BIA 12345", 1000, 115);
        Samochod s2 = new Samochod("BI 57131", 500, 400);
        Samochod s3 = new Samochod("WAW 10987", 320, 200);

        s1.start();
        s2.start();
        s3.start();
    }
    
klasa Samochod

konstruktor przypisuje dane

    public Samochod(String nrRej,  int pojZbiornika, int paliwo) {
            this.nrRej = nrRej;
            this.paliwo = paliwo;
            this.pojZbiornika = pojZbiornika;
            this.liczbaTankowan = 0;
            this.hamowanie = false;
        }

metoda tankowanie tankuje paliwo i wypluwa odpowiedni komunikat
        
   public void tankowanie(int _paliwo) {
        this.paliwo += _paliwo;
        System.out.println("[" + this.nrRej + "] tankuje " + _paliwo + " paliwa");

        this.liczbaTankowan++;
    }
    
    
 metoda start uruchamia wątek a zatrzymaj przerywa wątek
 
      @Override
    public void start() {
        System.out.println("Samochod o numerze rejestracyjnym:" + this. nrRej + " zostal odpalony *Brum Brum*");
        super.start();
    }

    public void zatrzymajSie() {
        System.out.println("[" + this.nrRej + "] zatrzymuje sie *hamowanie*");
        this.hamowanie = true;
    }
    
metoda run zmniejsza ilośc paliwa wywołuje funkcję tankowania w odpowiednim momęcie usypia wątek na określony czas lub wywołuje metodę zatrzymaj po spełnieniu odpowiedniego warunku
dodatkowo cały czas podaje odpowiednie komunikaty

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
