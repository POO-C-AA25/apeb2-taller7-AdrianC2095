
public class Problema6_SistemaBanco {
    public static void main(String[] args) {
        CuentaCheques cc = new CuentaCheques("Cheques", "Adrian Cuenca");
        CuentaAhorros ca = new CuentaAhorros("Ahorros", "Jorge Fernandez");
        CuentaPlatino cp = new CuentaPlatino("Platino", "Fransis Tapia");


        cc.depositar(1000);
        cc.retirar(1500);

        ca.depositar(2000);
        ca.retirar(500);
        ca.calcularInteres();

        cp.depositar(3000);
        cp.retirar(4000);
        cp.calcularInteres();

        System.out.println("=== Estado de Cuentas ===");
        System.out.printf("%s (%s): $%.2f%n", cc.num, cc.cliente, cc.balance);
        System.out.printf("%s (%s): $%.2f%n", ca.num, ca.cliente, ca.balance);
        System.out.printf("%s (%s): $%.2f%n", cp.num, cp.cliente, cp.balance);
    }
}

class Cuenta {
    public String num;
    public String cliente;
    public double balance;

    public Cuenta(String num, String cliente) {
        this.num = num;
        this.cliente = cliente;
        this.balance = 0.0;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            balance += monto;
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && balance >= monto) {
            balance -= monto;
            return true;
        }
        return false;
    }
}

class CuentaCheques extends Cuenta {
    public CuentaCheques(String num, String cliente) {
        super(num, cliente);
    }

    @Override
    public boolean retirar(double monto) {

        if (monto > 0) {
            balance -= monto;
            return true;
        }
        return false;
    }
}

class CuentaAhorros extends Cuenta {
    public double interes = 0.05;

    public CuentaAhorros(String num, String cliente) {
        super(num, cliente);
    }

    @Override
    public boolean retirar(double monto) {

        if (monto > 0 && balance >= monto) {
            balance -= monto;
            return true;
        }
        return false;
    }

    public void calcularInteres() {
        balance += balance * interes;
    }
}

class CuentaPlatino extends Cuenta {
    public double interes = 0.10;

    public CuentaPlatino(String num, String cliente) {
        super(num, cliente);
    }

    @Override
    public boolean retirar(double monto) {
        if (monto > 0) {
            balance -= monto;
            return true;
        }
        return false;
    }

    public void calcularInteres() {
        balance += balance * interes;
    }
}
