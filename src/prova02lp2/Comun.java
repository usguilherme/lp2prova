package prova02lp2;

public class Comun extends Usuario {

    public Comun(String nome, String login) {
        super(nome, login);
    }

    public String toString() {
        return "Usuário normal";
    }

    @Override
    public String getNome() {
        // TODO Auto-generated method stub
        return super.getNome();
    }

    @Override
    public void setNome(String nome) {
        // TODO Auto-generated method stub
        super.setNome(nome);
    }

    @Override
    public String getLogin() {
        // TODO Auto-generated method stub
        return super.getLogin();
    }

    @Override
    public void setLogin(String login) {
        // TODO Auto-generated method stub
        super.setLogin(login);
    }

    @Override
    public String getPapel() {
        // TODO Auto-generated method stub
        return super.getPapel();
    }

    @Override
    public void setPapel(String papel) {
        // TODO Auto-generated method stub
        super.setPapel(papel);
    }





}
