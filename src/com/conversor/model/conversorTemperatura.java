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

// Utilizamos los metodos staticos para poder acceder a ellos llamando a la
// clase directamente, sin necesidad de instanciar un objeto, debido a que no
// actuan sobre ellos.
// Por ej, la utilizamos en el conversor de esta manera:
// conversorTemperatura.farenheitCelsius(double);
//
// Los metodos static no pueden acceder a campos de ejemplar(variables/costantes
// declaradas en la clase) a menos que estas tambien sean statics.
