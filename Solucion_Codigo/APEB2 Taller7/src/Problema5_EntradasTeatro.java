import java.util.ArrayList;
import java.util.Random;

public class Problema5_EntradasTeatro {

    public static void main(String[] args) {

        ArrayList<Zona> zonas = new ArrayList<>();
        zonas.add(new Zona("Principal", 200, 25.0, 17.5));
        zonas.add(new Zona("Zona 1", 40, 70.0, 40.0));
        zonas.add(new Zona("Zona 2", 400, 20.0, 14.0));
        zonas.add(new Zona("Zona 2", 100, 15.5, 10.0));

        ArrayList<Entrada> todasLasEntradas = new ArrayList<>();

        venderEntrada(zonas, todasLasEntradas, "Principal", "Adrian", "normal");
        venderEntrada(zonas, todasLasEntradas, "Zona 1", "Francis", "abonado");
        venderEntrada(zonas, todasLasEntradas, "Zona 2", "Jorge", "reducida");

        buscarEntrada(todasLasEntradas, 1);
        buscarEntrada(todasLasEntradas, 2);
    }

    private static void venderEntrada(ArrayList<Zona> zonas, ArrayList<Entrada> todasLasEntradas,
            String nombreZona, String nombreComprador, String tipo) {
        Zona zona = null;

        for (Zona z : zonas) {
            if (z.getNombre().equalsIgnoreCase(nombreZona)) {
                zona = z;
                break;
            }
        }

        if (zona == null) {
            System.out.println("Zona no encontrada: " + nombreZona);
            return;
        }

        Entrada entrada = zona.venderEntrada(nombreComprador, tipo);
        if (entrada != null) {
            todasLasEntradas.add(entrada);
            System.out.println("Entrada vendida - ID: " + entrada.getId()
                    + ", Precio: " + entrada.calcularPrecio() + "$");
        } else {
            System.out.println("No hay disponibilidad en zona: " + nombreZona);
        }
    }

    public static void buscarEntrada(ArrayList<Entrada> entradas, int id) {
        for (Entrada entrada : entradas) {
            if (entrada.getId() == id) {
                System.out.println("Entrada encontrada:");
                System.out.println("ID: " + entrada.getId());
                System.out.println("Zona: " + entrada.getZona().getNombre());
                System.out.println("Comprador: " + entrada.getNombreComprador());
                System.out.println("Precio: " + entrada.calcularPrecio() + "$");
                return;
            }
        }
        System.out.println("Entrada no encontrada con ID: " + id);
    }
}

class Zona {

    public String nombre;
    public int capacidad;
    public int entradasVendidas;
    public double precioNormal;
    public double precioAbonado;
    public ArrayList<Entrada> entradas;

    public Zona(String nombre, int capacidad, double precioNormal, double precioAbonado) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precioNormal = precioNormal;
        this.precioAbonado = precioAbonado;
        this.entradas = new ArrayList<>();
        this.entradasVendidas = 0;
    }

    public Entrada venderEntrada(String nombreComprador, String tipo) {
        if (entradasVendidas >= capacidad) {
            return null;
        }

        int iD = new Random().nextInt(1000) + 1;
        Entrada entrada;

        if (tipo.equalsIgnoreCase("normal")) {
            entrada = new EntradaNormal(iD, this, nombreComprador);
        } else if (tipo.equalsIgnoreCase("abonado")) {
            entrada = new EntradaAbonado(iD, this, nombreComprador);
        } else if (tipo.equalsIgnoreCase("reducida")) {
            entrada = new EntradaReducida(iD, this, nombreComprador);
        } else {
            return null;
        }

        entradas.add(entrada);
        entradasVendidas++;
        return entrada;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioNormal() {
        return precioNormal;
    }

    public double getPrecioAbonado() {
        return precioAbonado;
    }
}

 class Entrada {

    public int iD;
    public Zona zona;
    public String nombreComprador;

    public Entrada(int iD, Zona zona, String nombreComprador) {
        this.iD = iD;
        this.zona = zona;
        this.nombreComprador = nombreComprador;
    }

    public double calcularPrecio(){
        return 0;
    }

    public int getId() {
        return iD;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public Zona getZona() {
        return zona;
    }
}

class EntradaNormal extends Entrada {

    public EntradaNormal(int iD, Zona zona, String nombreComprador) {
        super(iD, zona, nombreComprador);
    }

    @Override
    public double calcularPrecio() {
        return zona.getPrecioNormal();
    }
}

class EntradaReducida extends Entrada {

    public EntradaReducida(int iD, Zona zona, String nombreComprador) {
        super(iD, zona, nombreComprador);
    }

    @Override
    public double calcularPrecio() {
        return zona.getPrecioNormal() * 0.85; 
    }
}

class EntradaAbonado extends Entrada {

    public EntradaAbonado(int iD, Zona zona, String nombreComprador) {
        super(iD, zona, nombreComprador);
    }

    @Override
    public double calcularPrecio() {
        return zona.getPrecioAbonado();
    }
}