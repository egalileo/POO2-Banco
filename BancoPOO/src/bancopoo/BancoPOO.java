package bancopoo;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class BancoPOO {
    public static void main(String[] args) {
        String nombre;
        int cuantosClientes, cuantasCuentas, cuantasTransacciones, opcion, idCliente,idCuenta, tipoTransaccion;
        double monto;
       
        JTextArea hoja= new JTextArea();
        do{
            cuantosClientes=Integer.parseInt(JOptionPane.showInputDialog("Cuantos clientes manejará (Máximo 10)"));
        }while(cuantosClientes<2 && cuantosClientes>=10);
        do{
            cuantasCuentas=Integer.parseInt(JOptionPane.showInputDialog("Cuantos cuentas manejará (Máximo 20)"));
        }while(cuantasCuentas<1 && cuantasCuentas>=20);
         do{
            cuantasTransacciones=Integer.parseInt(JOptionPane.showInputDialog("Cuantas Transacciones manejará (Máximo 100)"));
        }while(cuantasTransacciones<1 && cuantasTransacciones>100);
         
        Banco agricola = new Banco(cuantosClientes, cuantasCuentas, cuantasTransacciones);
        opcion=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion que desea\n1. Crear Cliente\n2. Crear Cuenta\n3. Ver Clientes\n4. Ver cuentas\n5. Realizar Movimientos\n6. Ver Historial Movimientos"));
        while (opcion>=1 && opcion<=6){
            switch (opcion){
                case 1:// Crear Cliente
                    nombre=JOptionPane.showInputDialog("Ingrese su nombre");
                    agricola.crearCliente(nombre);
                    break;
                case 2:// Crear Cuenta
                    idCliente=Integer.parseInt(JOptionPane.showInputDialog("Ingrese su Id de cliente"));
                    monto=Double.parseDouble(JOptionPane.showInputDialog("Ingrese su monto inicial (Entre 25 y 10,000)"));
                    agricola.crearCuenta(idCliente, monto);
                    break;
                case 3:// Ver Clientes
                    hoja.setText(agricola.mostrarClientes());
                    JOptionPane.showMessageDialog(null, hoja);
                    break;
                case 4:// Ver Cuentas
                    hoja.setText(agricola.mostrarCuentas());
                    JOptionPane.showMessageDialog(null, hoja);
                    break;
                case 5:// Realizar Transaccion
                    idCliente=Integer.parseInt(JOptionPane.showInputDialog("Ingrese su Id de cliente"));
                    idCuenta=Integer.parseInt(JOptionPane.showInputDialog("Ingrese su Numero de cuenta"));
                    tipoTransaccion=Integer.parseInt(JOptionPane.showInputDialog("Que operacion desea hacer\n1. Depositos\n2.Retiros"));
                    monto=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto"));
                    agricola.hacerTransaccion(idCliente, idCuenta, tipoTransaccion, monto);
                    break; 
                case 6:// Ver Transacciones
                    hoja.setText(agricola.mostrarTransferencias());
                    JOptionPane.showMessageDialog(null, hoja);
                    break;
 
            }
            opcion=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion que desea\n1. Crear Cliente\n2. Crear Cuenta\n3. Ver clientes\n4. Ver cuentas\n5. Realizar Movimientos\n6. Ver Historial Movimientos"));
        }
    }
    
}
