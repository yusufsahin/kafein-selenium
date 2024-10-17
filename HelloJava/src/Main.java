import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       System.out.println("Merhaba Java");

       int sayi= 0;
       double pi=3.14;
       float e =2.71f;
       long sayi2=18L;
       char karakter='A';
       boolean dogruMu= true;
       System.out.println(sayi2);
       System.out.println(pi);
       System.out.println(e);
       System.out.println(sayi2);
       System.out.println(karakter);
       System.out.println(dogruMu);

       //if - else / switch

        if(sayi>0){
            System.out.println("Sayı Pozitif");
        }else if(sayi<0){
            System.out.println("sayi negatif");
        }else{
            System.out.println("Sayı sıfıra eşit");
        }

        System.out.println("Haftanın gününü sayi olarak giriniz!");

        Scanner sc= new Scanner(System.in);
        int gun=sc.nextInt();
        switch (gun) {
            case 1:
                System.out.println("Pazartesi");
                break;
            case 2:
                System.out.println("Salı");
                break;
            case 3:
                System.out.println("Çarşamba");
                break;
            case 4:
                System.out.println("Perşembe");
                break;
            case 5:
                System.out.println("Cuma");
                break;
            case 6:
                System.out.println("Cumartesi");
                break;
            case 7:
                System.out.println("Pazar");
                break;
            default:
                System.out.println("Geçersiz gün numarası");
        }
        // döngüler

        //for i++ -> i=i+1
        for( int i=1;i<=10;i++){
            System.out.println(i);
        }

        int j=5;
       // While
        while(j<10){
            System.out.println(j);
            j++; //j=j+1
        }
        System.out.println("do -while");

        //Do - While
        do{
            System.out.println(j);
            j++; //j=j+1
        }while (j<5);

        System.out.println(j);

        int[] sayilar= new int[5];

        sayilar[0]=10;
        sayilar[1]=20;
        sayilar[2]=30;
        sayilar[3]=40;
        sayilar[4]=50;
        //sayilar[5]=60;
        System.out.println("Üçüncü eleman: " + sayilar[2]);
        //System.out.println("Üçüncü eleman: " + sayilar[5]);

        //for-each

        for (int s:sayilar) {
            System.out.println(s);
        }

        System.out.println("Toplama işlemi sonucu");
        System.out.println(Topla(5,9));

        Araba mercedes= new Araba();
        mercedes.setMarka("Mercedes");
        mercedes.setModel("E200");
        mercedes.setYil("2024");
        mercedes.setHiz(200);

       System.out.println(mercedes.toString());

       mercedes.HizArttir(10);

       System.out.println(mercedes.getHiz());

       Araba bmw= new Araba("BMW","320","2020",240);
       System.out.println(bmw.toString());

        ArrayList<String> meyveler= new ArrayList<>();
        meyveler.add("Elma");
        meyveler.add("Muz");
        meyveler.add("Portakal");
        System.out.println(meyveler.size());
        System.out.println(meyveler.toString());
        System.out.println(meyveler.indexOf("Portakal"));
        System.out.println(meyveler.get(1));

        Araba toyota= new Araba("Toyota","Coralla","2020",180);

        ArrayList<Araba> arabalar= new ArrayList<>();

        arabalar.add(mercedes);
        arabalar.add(bmw);

        arabalar.add(toyota);

        for (Araba araba : arabalar) {
            System.out.println(araba.toString());
        }

        try {
            FileWriter yazici = new FileWriter("dosya.txt");
            yazici.write("Bu bir dosya yazma örneğidir.\n");
            yazici.write("Java dosya işlemleri.");
            yazici.close();  // Dosya kapatılmalıdır
            System.out.println("Dosyaya yazıldı.");
        } catch (IOException ex) {
            System.out.println("Bir hata oluştu: " + ex.getMessage());
        }
        try {
            FileReader dosya = new FileReader("dosya.txt");
            BufferedReader okuyucu = new BufferedReader(dosya);

            String satir;
            while ((satir = okuyucu.readLine()) != null) {
                System.out.println(satir);
            }
            okuyucu.close();
        } catch (IOException ex) {
            System.out.println("Bir hata oluştu: " + ex.getMessage());
        }

    }

    public  static  int Topla(int a,int b){
        return  a+b;
    }
}