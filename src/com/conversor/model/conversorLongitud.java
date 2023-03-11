package com.conversor.model;

public class conversorLongitud {
    public static Double kilometroMilla(Double valor) {
        return valor / 1.607;
    }

    public static Double millaKilometro(Double valor) {
        return valor * 1.607;
    }
}
