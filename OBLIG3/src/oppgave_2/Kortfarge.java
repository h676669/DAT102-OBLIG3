package oppgave_2;

public enum Kortfarge {
    KLOEVER("♣"), RUTER("♢"), SPAR("♠"), HJERTER("♡");
    private String symbol;
    Kortfarge(String symbol) {
        this.symbol = symbol;
    }
    public String getKortsymbol() {
        return symbol;
    }
    @Override
    public String toString() {
        return symbol;
    }
}