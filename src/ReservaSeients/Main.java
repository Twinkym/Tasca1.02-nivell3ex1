package ReservaSeients;

public class Main {
    public static void main(String[] args) throws ExcepcioFilaIncorrecta, ExcepcioNomPersonaIncorrecte, ExcepcioSeientIncorrecte {

        Cine cine = new Cine();

        cine.iniciar();



        Butaca butaca1 = new Butaca(5, 20, "Maria Febrer");

        System.out.println(butaca1);
        System.out.println(butaca1.getFila());
        System.out.println(butaca1.getSeient());
        System.out.println(butaca1.getPersona());
    }
}