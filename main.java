import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class main {
    public static void main(String[] args) {
        // Cria e exibe a janela de reserva de voo

        new FirstFrame();

        // INSTANCIAÇÃO
        // CompanhiaAerea

        CompanhiaAerea latam = new CompanhiaAerea("Latam", "JJ");
        CompanhiaAerea gol = new CompanhiaAerea("Gol", "G3");
        CompanhiaAerea azul = new CompanhiaAerea("Azul", "AD");
        CompanhiaAerea qatarAirways = new CompanhiaAerea("Qatar Airways", "QR");
        CompanhiaAerea americanAirlines = new CompanhiaAerea("American Airlines", "AA");
        CompanhiaAerea allNipponAirways = new CompanhiaAerea("All Nippon Airways", "NH");
        CompanhiaAerea airFrance = new CompanhiaAerea("Air France", "AF");

        // Aeroporto
        Aeroporto curitiba = new Aeroporto("Aeroporto Internacional de Curitiba - Afonso Pena", "São José dos Pinhais, PR, Brasil", "CWB");
        Aeroporto guarulhos = new Aeroporto("Aeroporto Internacional de São Paulo - Guarulhos", "Guarulhos, SP, Brasil", "GRU");
        Aeroporto galeao = new Aeroporto("Aeroporto Internacional do Rio de Janeiro - Galeão", "Rio de Janeiro, RJ, Brasil", "GIG");
        Aeroporto qatar = new Aeroporto("Aeroporto Internacional de Hamad", "Doha, Qatar", "DOH");
        Aeroporto unitedstates = new Aeroporto("Aeroporto Internacional John F. Kennedy", "Queens, NY, Estados Unidos", "JFK");
        Aeroporto tokyo = new Aeroporto("Aeroporto Internacional de Tokyo", "Tokyo, Japão", "HND");
        Aeroporto paris = new Aeroporto("Aeroporto de Paris-Charles de Gaulle", "Paris, França", "CDG");
//        Aeroporto curitiba = new Aeroporto("Aeroporto Internacional de Curitiba - Afonso Pena", "São José dos Pinhais, PR, Brasil", "CWB", voosCuritiba);
//        Aeroporto guarulhos = new Aeroporto("Aeroporto Internacional de São Paulo - Guarulhos", "Guarulhos, SP, Brasil", "GRU", voosGuarulhos);
//        Aeroporto galeao = new Aeroporto("Aeroporto Internacional do Rio de Janeiro - Galeão", "Rio de Janeiro, RJ, Brasil", "GIG", voosGaleao);
//        Aeroporto qatar = new Aeroporto("Aeroporto Internacional de Hamad", "Doha, Qatar", "DOH", voosQatar);
//        Aeroporto unitedstates = new Aeroporto("Aeroporto Internacional John F. Kennedy", "Queens, NY, Estados Unidos", "JFK", voosEua);
//        Aeroporto tokyo = new Aeroporto("Aeroporto Internacional de Tokyo", "Tokyo, Japão", "HND", voosTokyo);
//        Aeroporto paris = new Aeroporto("Aeroporto de Paris-Charles de Gaulle", "Paris, França", "CDG", voosParis);
//        ArrayList<Aeroporto> aeroportos = new ArrayList<>();
//        aeroportos.add(curitiba);
//        aeroportos.add(guarulhos);
//        aeroportos.add(galeao);
//        aeroportos.add(qatar);
//        aeroportos.add(unitedstates);
//        aeroportos.add(tokyo);
//        aeroportos.add(paris);

        // VooInternacional
        new ColecaoVoos("NH1449", curitiba, tokyo, "30/05/2023", "31/05/2023", allNipponAirways, 750, 19850.00f, "BR", "JP", true);
        new ColecaoVoos("G31255", guarulhos, unitedstates, "26/06/2023", "27/06/2023", gol, 700, 3983.50f, "BR", "US", false);
        new ColecaoVoos("AD2145", galeao, tokyo, "25/08/2023", "26/08/2023", azul, 680, 13345.00f, "BR", "JP", true);
        new ColecaoVoos("QR1689", curitiba, qatar, "29/10/2023", "30/10/2023", qatarAirways, 953, 21088.95f, "BR", "QA", true);
        new ColecaoVoos("AF0520", guarulhos, paris, "02/07/2023", "03/07/2023", airFrance, 554, 9876.52f, "BR", "FR", false);

        // VooNacional
        new ColecaoVoos("JJ3566", curitiba, guarulhos, "31/10/2023", "31/10/2023", latam, 250, 765.00f, 50.45f);
        new ColecaoVoos("G31236", guarulhos, curitiba, "27/07/2023", "28/07/2023", gol, 295, 685.00f, 48.46f);
        new ColecaoVoos("AD2450", guarulhos, galeao, "26/09/2023", "26/09/2023", azul, 350, 1368.56f, 65.45f);
        new ColecaoVoos("AD5299", galeao, curitiba, "30/06/2023", "30/06/2023", azul, 325, 3982.79f, 25.56f);
        new ColecaoVoos("JJ3999", galeao, guarulhos, "03/08/2023", "03/08/2023", latam, 300, 1246.96f, 69.22f);
//
//        Conta conta01 = new Conta("Beatriz Khey", "beatriz@gmail.com", "Beatriz.", "Rua Ângelo Massignan, 820", "(+5541)999943781", "BR159357", "101.885.899-53", new Date(1997, 10, 20));
//        Conta conta02 = new Conta("Bruno Marques", "bruno@gmail.com", "bRuno.", "Rua XV, 200", "(+5541)925648623", "BR456123", "684.546.645-56", new Date(2002, 02, 02));
//        Conta conta03 = new Conta("João Fadel", "joao@gmail.com", "JoaO3", "Rua Sete de Setembro, 300", "(+5541)923651356", "BR202023", "654.631.131-65", new Date(2001, 05, 30));
//        Conta conta04 = new Conta("Lohine Mussi", "lohine@gmail.com", "Lohine@", "Rua República Argentina, 520", "(+5541)931353242", "BR121212", "651.233.973-22", new Date(2002, 9, 05));
//        Conta conta05 = new Conta("Ariana Grande", "ariana@gmail.com", "arigra12.", "Hollywood Boulevard, 6006", "(+1408)1235236", "CS265436", "\"does not apply\" ", new Date(1993, 06, 26));
//        Conta conta06 = new Conta("Travis Scott", "travis@gmail.com", "scoTT@", "North Reese Avenue, 5396 ", "(+1408)1253248", "TS123123", "\"does not apply\" ", new Date(1991, 04, 30));
//
//        Passageiro beatriz = new Passageiro("Beatriz Khey", "BR159357", "101.008.859-93", new Date(1997, 10, 20), conta01);
//        Passageiro bruno = new Passageiro("Bruno Marques", "BR456123", "684.546.645-56", new Date(2002, 02, 02), conta02);
//        Passageiro joao = new Passageiro("João Fadel", "BR202023", "654.631.131-65", new Date(2001, 05, 30), conta03);
//        Passageiro lohine = new Passageiro("Lohine Mussi", "BR121212", "651.233.973-22", new Date(2002, 12, 05), conta04);
//        Passageiro ariana = new Passageiro("Ariana Grande", "CS265436", "\"does not apply\" ", new Date(1993, 06, 26), conta05);
//        Passageiro travis = new Passageiro("Travis Scott", "TS123123", "\"does not apply\" ", new Date(1991, 04, 30), conta06);
    }
}
