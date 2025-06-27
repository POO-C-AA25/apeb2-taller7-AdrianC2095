public class Problema4_NominaTrabajadores {
        public static void main(String[] args) {
        Jefe jefe1 = new Jefe("Jorge", "Fernandez", "Av. Villonaco", "11054548751", 3000.0);

        SueldoMensual empleado1 = new SueldoMensual("Angie", "Armijos", "Onas", "1105826981", jefe1, 1000.0);
        Comisionista empleado2 = new Comisionista("Pedro", "Martínez", "Madre de Dios", "1105803371", jefe1, 2.0);
        empleado2.ventas = 10000.0;

        Horas empleado3 = new Horas("Daniela", "Briceño", "Plaza Central", "44444444D", jefe1, 15.0, 20.0);
        empleado3.horasTrabajadas = 45;

        
        System.out.println("Nómina Jefe: " + jefe1.calcularNomina());
        System.out.println("Nómina Sueldo Mensual: " + empleado1.calcularNomina());
        System.out.println("Nómina Comisionista: " + empleado2.calcularNomina());
        System.out.println("Nómina Por Horas: " + empleado3.calcularNomina());
    }
}

class Trabajador {
    public String nombre;
    public String apellido;
    public String direc;
    public String iD;
    public Trabajador jefe;

    public Trabajador(String nombre, String apellido, String direc, String iD, Trabajador jefe) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direc = direc;
        this.iD = iD;
        this.jefe = jefe;
    }

    public double calcularNomina() {
        return 0.0;
    }
}

class SueldoMensual extends Trabajador {
    public double sueldoFijo;

    public SueldoMensual(String nombre, String apellido, String direc, String iD, Trabajador jefe, double sueldoFijo) {
        super(nombre, apellido, direc, iD, jefe);
        this.sueldoFijo = sueldoFijo;
    }

    @Override
    public double calcularNomina() {
        return sueldoFijo;
    }
}

class Comisionista extends Trabajador {
    public double ventas;
    public double porcentajeComision;

    public Comisionista(String nombre, String apellido, String direc, String iD, Trabajador jefe, double porcentajeComision) {
        super(nombre, apellido, direc, iD, jefe);
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public double calcularNomina() {
        return ventas * (porcentajeComision / 100);
    }
}

class Horas extends Trabajador {
    public int horasTrabajadas;
    public double precioHora;
    public double precioHoraExtra;

    public Horas(String nombre, String apellidos, String direccion, String dni, Trabajador jefe, double precioHora, double precioHoraExtra) {
        super(nombre, apellidos, direccion, dni, jefe);
        this.precioHora = precioHora;
        this.precioHoraExtra = precioHoraExtra;
    }

    @Override
    public double calcularNomina() {
        if (horasTrabajadas <= 40) {
            return horasTrabajadas * precioHora;
        } else {
            return (40 * precioHora) + ((horasTrabajadas - 40) * precioHoraExtra);
        }
    }
}

class Jefe extends Trabajador {
    public double sueldoFijo;

    public Jefe(String nombre, String apellido, String direc, String iD, double sueldoFijo) {
        super(nombre, apellido, direc, iD, null);
        this.sueldoFijo = sueldoFijo;
    }

    @Override
    public double calcularNomina() {
        return sueldoFijo;
    }
}