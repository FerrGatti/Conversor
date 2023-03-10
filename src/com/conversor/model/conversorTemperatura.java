package com.conversor.model;

public class conversorTemperatura {
    public static Double celciusFarenheit(Double valor) {
        return valor * 9 / 5 + 32;
    }

    public static Double farenheitCelcius(Double valor) {
        return (valor - 32) * 5 / 9;
    }

    public static Double farenheitKelvin(Double valor) {
        return (valor - 32) * 5 / 9 + 273.15;
    }

    public static Double kelvinFarenheit(Double valor) {
        return (valor - 273.15) * 9 / 5 + 32;
    }

    public static Double kelvinCelcius(Double valor) {
        return (valor - 273.15);
    }

    public static Double celciusKelvin(Double valor) {
        return (valor + 273.15);
    }
}
