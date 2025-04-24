package prova02lp2;

public class Numero extends Item {
    private int numero;

    public Numero(String descricao, int ano, int numero) {
        super(descricao, ano);
        this.numero = numero;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Item	- ").append(this.numero);
        return sb.toString();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}

