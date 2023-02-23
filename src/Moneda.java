import javax.swing.JOptionPane;

public abstract class Moneda {
    private String input_moneda; // <-- Se le solicita al usuario que ingrese un tipo de moneda para trabajar

    // GETTERS & SETTERS

    public String getMoneda() {
        return input_moneda;
    }

    public String setMoneda(String string) {
        return this.input_moneda = string;
    }

    // VALOR DEL DOLAR
    // Compra
    public Double toDolar(Double monto) {
        return monto = monto * 203.0;
    }

    // Venta
    public Double fromDolar(Double monto) {
        return monto = monto * 195.49;
    }

    // VALOR DEL EURO
    // Compra
    public Double toEuro(Double monto) {
        return monto = monto * 214.28;
    }

    // Venta
    public Double fromEuro(Double monto) {
        return monto = monto * 205.07;
    }

    // IMPUESTO PAIS
    public Double impuesto(Double monto) {
        return monto = ((65 * monto) / 100);
    }

    // OPCIONES VENTA
    public void opcionDolar() {
        String input_monto = JOptionPane.showInputDialog("Cuanto desea convertir: ");
        double monto = Integer.parseInt(input_monto);
        if (monto < 1) {
            throw new MonedaNegativaException("Valor erroneo");
        } else {
            monto = fromDolar(monto);
            System.out.println(input_monto + "u$d" + " ==> $" + monto);
        }
    }

    public void opcionEuro() {
        String input_monto = JOptionPane.showInputDialog("Cuanto desea convertir: ");
        double monto = Integer.parseInt(input_monto);
        if (monto < 1) {
            throw new MonedaNegativaException("Valor erroneo");
        } else {
            monto = fromEuro(monto);
            System.out.println(input_monto + "€ " + " ==> $" + monto);
        }
    }

    // OPCIONES COMPRA
    public void compraDolar() {
        String input_monto = JOptionPane.showInputDialog("Cuanto desea comprar: ");
        double monto = Integer.parseInt(input_monto);

        if (monto < 1) {
            throw new MonedaNegativaException("Valor erroneo");
        } else {
            monto = toDolar(monto);
            Double impuesto = impuesto(monto);
            System.out.println(
                    input_monto + " u$d tiene un costo de $" + Math.round(monto + impuesto)
                            + " con inpuestos incluidos($" + impuesto + ")");
        }
    }

    public void compraEuro() {
        String input_monto = JOptionPane.showInputDialog("Cuanto desea comprar: ");
        double monto = Integer.parseInt(input_monto);

        if (monto < 1) {
            throw new MonedaNegativaException("Valor erroneo");
        } else {
            monto = toEuro(monto);
            Double impuesto = impuesto(monto);
            System.out.println(input_monto + " euros tiene un costo de $" + Math.round(monto + impuesto)
                    + " con impuestos incluidos($" + impuesto + ").");
        }
    }
}
