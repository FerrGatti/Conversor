package com.conversor.model;

public class conversorMoneda {
    static double dolarCompra = 208;
    static double euroCompra = 214.98;
    static double dolarEuro = 0.95;
    static double euroDolar = 1.06;

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

}
