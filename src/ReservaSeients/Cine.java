package ReservaSeients;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Cine {

    protected int nombreTotalDeFiles;
    protected int nombreDeSeientsPerFila;
    protected GestioButaques gestioButaques;

    public Cine() {
        gestioButaques = new GestioButaques();
        demanarDadesInicials();
    }

    private void demanarDadesInicials() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduiex el nombre de files del cinema: ");
        nombreTotalDeFiles = sc.nextInt();
        System.out.println("Introdueix el nombre de seients per cada fila: ");
        nombreDeSeientsPerFila = sc.nextInt();
    }

    void iniciar() throws ExcepcioFilaIncorrecta, ExcepcioNomPersonaIncorrecte, ExcepcioSeientIncorrecte {
        boolean sortir = false;
        while (!sortir) {
            int opcio = menu();
            switch (opcio) {
                case 1 -> mostrarButaques();
                case 2 -> mostrarButaquesPersona();
                case 3 -> reservarButaca();
                case 4 -> anularReserva();
                case 5 -> anularReservaPersona();
                case 6 -> {
                    sortir = true;
                    System.out.println("Fins aviat!");
                }
                default -> System.out.println("Opció invàlida. Torna a provar.");
            }
        }
    }

    private int menu() {
        System.out.println("---- Menu Principal ----");
        System.out.println("1.- Mostrar totes les butaques reservades. ");
        System.out.println("2.- Mostrar las butaques reservades per una persona");
        System.out.println("3.- Reservar una butaca.");
        System.out.println("4.- Anul-lar la reserva d'una butaca. ");
        System.out.println("5.- Anul-lar totes les reserves d'una persona. ");
        System.out.println("0.- Sortir. ");
        System.out.println("Selecciona una opció: ");
        Scanner sc = new Scanner(System.in);
        int opcio;
        try {
            opcio = sc.nextInt();
        } catch (InputMismatchException e) {
            opcio = 0;
        }
        sc.nextLine();
        return opcio;
    }

    private void mostrarButaques() {
        List<Butaca> butaquesReservades = gestioButaques.gestioButaquesReservades();
        if (butaquesReservades.isEmpty()) {
            System.out.println("No hi cap butaca reservada. ");
        } else {
            System.out.println("Butaques reservades: ");
            for (Butaca butaca : butaquesReservades) {
                System.out.println(butaca);
            }
        }
    }

    private void mostrarButaquesPersona() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix el nom de la persona: ");
        String nomPersona = sc.nextLine();
            System.out.println("Butaques reservades per " + nomPersona + ": ");
            for (Butaca butaca : gestioButaques.getButaques()) {
                System.out.println(butaca);
        }
    }
    private void reservarButaca() throws ExcepcioFilaIncorrecta, ExcepcioSeientIncorrecte, ExcepcioNomPersonaIncorrecte {
        int fila = introduirFila();
        int seient = introduirSeient();
        String persona = introduirPersona();
        gestioButaques.reservarButaca(fila, seient, persona);
        System.out.println("Butaca reservada amb èxit.");
    }

    private String introduirPersona() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix el nom de la persona: ");
        String nomPersona = sc.nextLine();
        if (nomPersona.matches(".*\\d.*")){
            try {
                throw new ExcepcioNomPersonaIncorrecte("El nom de la persona no pot contenir números.");
            } catch (ExcepcioNomPersonaIncorrecte e) {
                throw new RuntimeException(e);
            }
        }
        return nomPersona;
    }

    private int introduirSeient () throws ExcepcioSeientIncorrecte {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix el número de seient: ");
        int seient = sc.nextInt();
        if (seient < 1 || seient > nombreDeSeientsPerFila) {
            throw new ExcepcioSeientIncorrecte("El número de seient és incorrecte.");
        }
        return seient;
    }

    private int introduirFila() throws ExcepcioFilaIncorrecta {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix el número de fila: ");
        int fila = sc.nextInt();
        if (fila < 1 || fila > nombreTotalDeFiles) {
            throw new ExcepcioFilaIncorrecta("El número de fila és incorrecte.");
        }
        return fila;
    }

    private void anularReservaPersona() throws ExcepcioSeientIncorrecte {
        Scanner sc = new Scanner(System.in);
        String persona = introduirPersona();
        gestioButaques.anularReservaPersona(persona);
        System.out.println("Reserves anul·lades per " + persona + " amb èxit.");
    }

    private void anularReserva() {
        Scanner sc = new Scanner(System.in);
        try {
            int file = introduirFila();
            int seient = introduirSeient();
            gestioButaques.anularReserva(file, seient);
            System.out.println("Reserva anul·lada amb èxit.");
        } catch (ExcepcioFilaIncorrecta | ExcepcioSeientIncorrecte e) {
            System.out.println(e.getMessage());
        }
    }
}
