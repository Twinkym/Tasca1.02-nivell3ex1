package ReservaSeients;

import java.util.Objects;

public class Butaca {
    protected int fila;
    protected int seient;
    protected String Persona;

    public Butaca(int fila, int seient, String persona) {
        this.fila = fila;
        this.seient = seient;
        Persona = persona;
    }

    public int getFila() {
        return fila;
    }

    public int getSeient() {
        return seient;
    }

    public String getPersona() {
        return Persona;
    }

    // Mètode equals per comparar dues butaques
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Butaca butaca)) return false;
        return getFila() == butaca.getFila() && getSeient() == butaca.getSeient();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFila(), getSeient());
    }

    @Override
    public String toString() {
        return "Butaca{" +
                "nombre_de_fila=" + fila +
                ", nombre_de_seient=" + seient +
                ", Persona='" + Persona + '\'' +
                '}';
    }
}
