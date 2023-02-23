public abstract class Moneda {
    private String input_moneda;

    public String getInput_moneda() {
        return input_moneda;
    }

    public Moneda() {
        String input_moneda;
    }

    public Double toDolar(Double monto) {
        return monto = monto * 191.66;
    }

    public Double toEuro(Double monto) {
        return monto = monto * 205.07;
    }

    public String setMoneda(String string) {
        return this.input_moneda = string;
    }

    public Double impuesto(Double monto) {
        return monto = ((75 * monto) / 100);
    }
}
