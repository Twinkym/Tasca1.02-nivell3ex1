package ReservaSeients;

import java.util.ArrayList;
import java.util.List;

public class GestioButaques {
    protected ArrayList<Butaca> butaques;

    public GestioButaques() {
        butaques = new ArrayList<>();
    }

    public ArrayList<Butaca> getButaques() {
        return butaques;
    }

    public void afegirButaca(Butaca butaca) throws ExcepcioButacaOcupada {
        int posicio = cercarButaca(butaca.getFila(), butaca.getSeient());
        if (posicio != -1) {
            throw new ExcepcioButacaOcupada("Butaca ocupada tria un altre.");
        }
        butaques.add(butaca);
    }

    public void eliminarButaca(int fila, int seient) throws ExcepcioButacaLliure {
        int posicio = cercarButaca(fila, seient);
        if (posicio == -1) {
            throw new ExcepcioButacaLliure("Aquesta butaca esta buida.");
        }
        butaques.remove(posicio);
    }

    private int cercarButaca(int fila, int seient) {
        for (int i = 0; i < butaques.size(); i++) {
            Butaca butaca = butaques.get(i);
            if (butaca.getFila() == fila && butaca.getSeient() == seient)
                return i;
        }
        return -1;
    }

    public List<Butaca> gestioButaquesReservades() {
        return butaques;
    }

    public String gestioButaquesReservadesPersona(String nomPersona) {
        return nomPersona;
    }

    public void reservarButaca(int fila, int seient, String persona) {

    }

    public void anularReservaPersona(String persona) {

    }

    public void anularReserva(int file, int seient) {

    }
}
