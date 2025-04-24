package prova02lp2;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String login;
    private String papel;
    private ArrayList<Item> listaDeItemUsuarios;
    private int pontos;

    public Usuario(String nome, String login) {
        this.nome = nome;
        this.login = login;
        this.listaDeItemUsuarios = new ArrayList<>();
        this.pontos = 0;
    }

    public void aumentarPontos() {
        pontos++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public ArrayList<Item> getListaDeItemUsuarios() {
        return listaDeItemUsuarios;
    }

    public void setListaDeItemUsuarios(Item item) {
        listaDeItemUsuarios.add(item);
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void setListaDeItemUsuarios(ArrayList<Item> listaDeItemUsuarios) {
        this.listaDeItemUsuarios = listaDeItemUsuarios;
    }











}
