package oppgave_2;

public record Kort(Kortfarge farge, Kortverdi verdi) {
    @Override
    public String toString() {
        return "[" + farge + " " + verdi + "]";
    }
}
