public interface MonedaAbstract {
    double dolarCompra = 203;
    double euroCompra = 214.98;
    double dolarEuro = 0.95;
    double euroDolar = 1.06;

    public abstract Double PesoDolar(Double monto);

    public abstract Double DolarPeso(Double monto);

    public abstract Double PesoEuro(Double monto);

    public abstract Double EuroDolar(Double monto);

    public abstract Double DolarEuro(Double monto);

}
