package bancopoo;

import javax.swing.JOptionPane;

public class Banco {
    private Object cuentas[][];
    private Object clientes[][];
    private Object transacciones[][];
    private String salida="";
    private boolean existeCliente=false, existeCuenta=false;
    private int cliente=0, cuenta=0, transaccion=0;
    private double deposito, retiro;
    
    public Banco(){}
    
    public Banco(int cuantosClientes, int cuantasCuentas,  int cuantasTransacciones){
        this.cuentas=new Object[cuantasCuentas][3];
        this.clientes=new Object [cuantosClientes][2];
        this.transacciones=new Object[cuantasTransacciones][4];
        this.salida="";
    }
    
    public void crearCliente(String nombre){
        if(!nombre.isEmpty()){
            this.clientes[cliente][0]=(cliente+1);
            this.clientes[cliente][1]=nombre;
            cliente=cliente+1;
            JOptionPane.showMessageDialog(null, "Cliente creado con éxito");
        }else{
            JOptionPane.showMessageDialog(null, "ERROR. Cliente no creado");
        }
    }
    
    public String mostrarClientes(){
        String salida="IdCliente\tNombre\n";
        for(int fila=0; fila<cliente; fila++){
            for(int columna=0; columna<2; columna++){
                salida=salida+this.clientes[fila][columna]+"\t";
            }
            salida=salida+"\n";
        }
        return salida;
    }
    public boolean existeCliente(int idCliente){
        this.existeCliente=false;
        for(int fila=0; fila<this.cliente;fila++){
            if(clientes[fila][0].equals(idCliente)){
                this.existeCliente=true;
            }
        }
        if(this.existeCliente==false){
            JOptionPane.showMessageDialog(null, "ERROR. El idCliente no existe");
        }else{
            JOptionPane.showMessageDialog(null, "Verificando IdCliente...");
        }
        return this.existeCliente;
    }
    
    public void crearCuenta(Object idCliente, double monto){
        existeCliente(Integer.parseInt(String.valueOf(idCliente)));
        if(this.existeCliente==true){
            if(monto<25 && monto>10000){
                JOptionPane.showMessageDialog(null, "ERROR. Ingrese un monto correcto");
            }else{
                JOptionPane.showMessageDialog(null, "Cuenta creada con éxito");
                cuentas[this.cuenta][0]=idCliente;
                cuentas[this.cuenta][1]=(this.cuenta+1);
                cuentas[this.cuenta][2]=monto;
                cuenta++;
            }
        }
    }

    public String mostrarCuentas(){
        String salida="IdCliente\tidCuenta\tSaldo\n";
        for(int fila=0; fila<this.cuenta; fila++){
            for(int columna=0; columna<3; columna++){
                salida=salida+this.cuentas[fila][columna]+"\t";
            }
            salida=salida+"\n";
        }
        return salida;
    }
    
    public boolean existeCuenta(int idCuenta){
        this.existeCuenta=false;
        for(int fila=0; fila<this.cuenta;fila++){
            if(cuentas[fila][1].equals(idCuenta)){
                this.existeCuenta=true;
            }
        }
        if(this.existeCuenta==false){
            JOptionPane.showMessageDialog(null, "ERROR. El IdCuenta no existe");
        }else{
            JOptionPane.showMessageDialog(null, "Verificando IdCuenta...");
        }
        return this.existeCuenta;
    }
    

    
    public void hacerTransaccion(Object idCliente, Object idCuenta, Object tipo, Object monto){
        double saldo, cantidad;
        int cliente, cuenta, opcion;
        cliente=Integer.parseInt(String.valueOf(idCliente));
        cuenta=Integer.parseInt(String.valueOf(idCuenta));
        opcion=Integer.parseInt(String.valueOf(tipo));
        cantidad=Double.parseDouble(String.valueOf(monto));
        
        existeCliente(cliente);
        existeCuenta(cuenta);
        if(this.existeCliente && this.existeCuenta){
            if(opcion==1){ //Depositos
                saldo=Double.parseDouble(String.valueOf(cuentas[cuenta-1][2]));
                if( cantidad<5 || ((saldo+cantidad)>10000)  ){
                    JOptionPane.showMessageDialog(null, "ERROR. El monto del deposito es menor o sobrepasa la cantidad permitida por el Banco");
                }else{
                    this.cuentas[cuenta-1][2]=String.valueOf(saldo+cantidad);
                    this.transacciones[transaccion][0]=idCliente;
                    this.transacciones[transaccion][1]=idCuenta;
                    this.transacciones[transaccion][2]=tipo;
                    this.transacciones[transaccion][3]=monto;
                    transaccion++;
                }
            }else if(opcion==2){// Retiros
                saldo=Double.parseDouble(String.valueOf(cuentas[cuenta-1][2]));
                if( cantidad<5 || ((saldo-cantidad)<15) ){
                    JOptionPane.showMessageDialog(null, "ERROR. El monto del retiro es menor o sobrepasa la cantidad permitida por el Banco");
                }else{
                    this.cuentas[cuenta-1][2]=String.valueOf(saldo-cantidad);
                    this.transacciones[transaccion][0]=idCliente;
                    this.transacciones[transaccion][1]=idCuenta;
                    this.transacciones[transaccion][2]=tipo;
                    this.transacciones[transaccion][3]=monto;
                    transaccion++;
                }
            }else{
                JOptionPane.showMessageDialog(null, "ERROR. Ingrese el tipo de accion correcto");
            }
        } 
    }
    
    public String mostrarTransferencias(){
        String salida="IdCliente\tidCuenta\tTipo\tMonto($)\n";
        for(int fila=0; fila<this.transaccion; fila++){
            for(int columna=0; columna<4; columna++){
                salida=salida+this.transacciones[fila][columna]+"\t";
            }
            salida=salida+"\n";
        }
        return salida;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        
        this.salida = salida;
    }
    
}
