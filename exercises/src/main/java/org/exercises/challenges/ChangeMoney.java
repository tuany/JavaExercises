package org.exercises.challenges;

// devolver o troco otimo para um dado valor inteiro
// se nao for possivel, retornar null
// Considerando os valores de notas 10, 5 e 2.
// Utilizei estrategia que realiza backtracking ate onde for possivel.
public class ChangeMoney {

    public static final long BILL_10 = 10L;
    public static final long BILL_5  = 5L;
    public static final long COIN_2  = 2L;

    // Do not modify this method signature
    public Change optimalChange(long s) {
        if(s < 0) return null;
        
        long d = s;
        long pd = 0L; // necessario para o backtracking
        long q = 1L; // quantidade de notas
        Change c = new Change();
        c.bill10 = 0;
        c.bill5 = 0;
        c.coin2 = 0;

        boolean changePossible = true;
        while (d > 0 && changePossible) {
            if ((d >= BILL_5)) {
                q = d / BILL_5;
                c.bill5 = c.bill5 + q;
                pd = d;
                d = d - (BILL_5 * q);
            } else if ((d >= COIN_2)) {
                q = d / COIN_2;
                c.coin2 = c.coin2 + q;
                pd = d;
                d = d - (COIN_2 * q);
            } else {
                // se e possivel fazer backtracking
                if (c.bill5 > 0 && pd >= COIN_2) {
                    c.bill5--;
                    d = d + BILL_5;
                    pd = d;

                    q = d / COIN_2;
                    c.coin2 = c.coin2 + q;
                    d = d - (COIN_2 * q);
                    continue;
                }
                changePossible = false;
            }
        }

        if (c.bill5 >= 2) {
            c.bill10 = c.bill5 / 2;
            c.bill5 = c.bill5 % 2;
        }

        return d == 0 ? c : null;
    }
}
