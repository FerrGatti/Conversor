package com.conversor.model;

public class conversorMoneda {
    // Valor Pesos a otras monedas
    static double dolarCompra = 208;
    static double euroCompra = 214.98;
    static double libraCompra = 244.27;
    static double yenCompra = 1.506;
    static double wonCompra = 6.463;

    // Valor dolar a otras monedas
    static double dolarEuro = 0.93;
    static double dolarLibra = 1.22;
    static double dolarYen = 133.32;
    static double dolarWon = 1296.33;

    // Valor Euro a otras monedas
    static double euroDolar = 1.06;
    static double euroLibra = 1.13;
    static double euroYen = 142.97;
    static double euroWon = 1390.42;

    // Valor libra a otras monedas
    static double libraYen = 162.30;
    static double libraWon = 1578.44;

    // Valor yen
    static double yenWon = 9.73;
    // Metodos

    public static Double PesoDolar(Double monto) {
        return dolarCompra;
    };

    public static Double DolarPeso(Double monto) {
        return dolarCompra + (dolarCompra * 0.65);
    };

    public static Double PesoEuro(Double monto) {
        return euroCompra;
    };

    public static Double EuroDolar(Double monto) {
        return euroDolar;
    };

    public static Double DolarEuro(Double monto) {
        return dolarEuro;
    };

    public static Double PesoYen(Double monto) {
        return yenCompra;
    };

    public static Double PesoWon(Double monto) {
        return wonCompra;
    };

    public static Double PesoLibra(Double monto) {
        return libraCompra;
    };

    public static Double DolarLibra(Double monto) {
        return dolarLibra;
    };

    public static Double DolarYen(Double monto) {
        return dolarYen;
    };

    public static Double DolarWon(Double monto) {
        return dolarWon;
    };

    public static Double EuroLibra(Double monto) {
        return euroLibra;
    }

    public static Double EuroYen(Double monto) {
        return euroYen;
    }

    public static Double EuroWon(Double monto) {
        return euroWon;
    }

    public static Double LibraWon(Double monto) {
        return libraWon;
    }

    public static Double LibraYen(Double monto) {
        return libraYen;
    }

    public static Double YenWon(Double monto) {
        return yenWon;
    }

}
