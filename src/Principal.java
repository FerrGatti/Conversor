import javax.swing.*;

public class Principal extends Moneda {

    public static void main(String[] args) {
        Moneda moneda = new Principal();

        moneda.setMoneda(JOptionPane.showInputDialog("Ingrese el tipo de moneda(USD o EU o ARG): ", moneda));
        String dolar = "USD";
        String euro = "EU";
        String pesos = "ARG";

        // OPCION DOLAR

        if (moneda.getInput_moneda().equalsIgnoreCase(dolar)) {
            String input_monto = JOptionPane.showInputDialog("Cuanto desea convertir: ");
            double monto = Integer.parseInt(input_monto);
            if (monto < 1) {
                throw new MonedaNegativaException("Valor erroneo");
            } else {
                monto = moneda.toDolar(monto);
                System.out.println(input_monto + "u$d" + " ==> " + monto + "$");
            }

            // OPCION EURO

        } else if (moneda.getInput_moneda().equalsIgnoreCase(euro)) {
            String input_monto = JOptionPane.showInputDialog("Cuanto desea convertir: ");
            double monto = Integer.parseInt(input_monto);
            if (monto < 1) {
                throw new MonedaNegativaException("Valor erroneo");
            } else {
                monto = moneda.toEuro(monto);
                System.out.println(input_monto + "€ " + " ==> " + monto + "$");
            }

        }

        // OPCION PESOS
        /*
         * Al elegir pesos para operar, se aplican los impuetos del pais para
         * comercializacion de monedas extranjeras.
         */

        while (moneda.getInput_moneda().equalsIgnoreCase(pesos)) {
            String tipo_moneda = JOptionPane.showInputDialog("Que moneda desea comprar(USD o EU): ");

            if (tipo_moneda.equalsIgnoreCase(dolar)) {

                String input_monto = JOptionPane.showInputDialog("Cuanto desea comprar: ");
                double monto = Integer.parseInt(input_monto);

                if (monto < 1) {
                    throw new MonedaNegativaException("Valor erroneo");
                } else {
                    monto = moneda.toDolar(monto);
                    Double impuesto = moneda.impuesto(monto);
                    System.out.println(
                            input_monto + " u$d tiene un costo de " + Math.round(monto + impuesto)
                                    + "$ con inpuestos incluidos($" + impuesto + ")");
                    break;
                }

            } else if (tipo_moneda.equalsIgnoreCase(euro)) {

                String input_monto = JOptionPane.showInputDialog("Cuanto desea comprar: ");
                double monto = Integer.parseInt(input_monto);

                if (monto < 1) {
                    throw new MonedaNegativaException("Valor erroneo");
                } else {
                    monto = moneda.toEuro(monto);
                    Double impuesto = moneda.impuesto(monto);
                    System.out.println(input_monto + " euros tiene un costo de " + Math.round(monto + impuesto)
                            + "$ con impuestos incluidos($" + impuesto + ").");
                    break;
                }
            } else {
                System.out.println("Moneda invalida.");
                tipo_moneda = JOptionPane.showInputDialog("Que moneda desea comprar(USD o EU): ");
            }

        }
    }
}
