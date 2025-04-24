package prova02lp2;


public class Texto extends Item  {
    private String texto;
    private int relevancia;

    public Texto(String descricao, int ano, String texto, int relevancia) {
        super(descricao, ano);
        this.texto = texto;
        this.relevancia = relevancia;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ItemTexto - ").append(this.texto).append(this.relevancia);
        return sb.toString();
    }


    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getRelevancia() {
        return relevancia;
    }

    public void setRelevancia(int relevancia) {
        this.relevancia = relevancia;
    }









}

