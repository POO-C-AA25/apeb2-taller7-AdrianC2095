public class Problema3_Mensajes {
    public static void main(String[] args) {

        SMS sms1 = new SMS("964041044", "939537831", "Hola");
        sms1.nombreRemitente = "Rosario";
        
        MMS mms1 = new MMS("997263441", "939537831", "foto_vacaciones.jpg");
        mms1.nombreRemitente = "Francis";
        mms1.nombreDestinatario = "Adrian";

        System.out.println("Remitente del SMS: " + sms1.remitente);

        sms1.enviarMensaje();
        System.out.println(mms1.verMensaje());
    }
}

class Mensaje {
    public String remitente;
    public String destinatario;
    public String nombreRemitente;
    public String nombreDestinatario;

    public Mensaje(String remitente, String destinatario) {
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    public void enviarMensaje() {
        System.out.println("Enviando mensaje genérico...");
    }

    public String verMensaje() {
        return "Mensaje de " + remitente + " a " + destinatario;
    }
}

class SMS extends Mensaje {
    public String texto;

    public SMS(String remitente, String destinatario, String texto) {
        super(remitente, destinatario);
        this.texto = texto;
    }

    @Override
    public void enviarMensaje() {
        System.out.println("Enviando SMS a " + destinatario + ": " + texto);
    }

    @Override
    public String verMensaje() {
        return "SMS de " + nombreRemitente + " (" + remitente + "): " + texto;
    }
}


class MMS extends Mensaje {
    public String nombreFicheroImagen;

    public MMS(String remitente, String destinatario, String nombreFicheroImagen) {
        super(remitente, destinatario);
        this.nombreFicheroImagen = nombreFicheroImagen;
    }

    @Override
    public void enviarMensaje() {
        System.out.println("Enviando MMS con imagen '" + nombreFicheroImagen + "' a " + destinatario);
    }

    @Override
    public String verMensaje() {
        return "MMS de " + nombreRemitente + " (" + remitente + "): " + nombreFicheroImagen;
    }
}
