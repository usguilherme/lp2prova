package prova02lp2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BibliCRUD {
    private HashMap<String, Usuario> listaUsuarios;

    public BibliCRUD() {
        this.listaUsuarios = new HashMap<>();
    }

    public boolean cadastrarUsuario(String nome, String login) {
        if (nome == null || login == null || nome.isEmpty() || login.isEmpty()) {
            return false;
        }

        else if (listaUsuarios.containsKey(login)) {
            throw new IllegalArgumentException("O usuário já foi cadastrado");
        }

        else {
            Usuario usuario = new Usuario(nome, login);
            listaUsuarios.put(login, usuario);
            return true;
        }
    }

    public String alterarNomeUsuario(String login, String novoNome) {
        if (!listaUsuarios.containsKey(login)) {
            return "";
        } else {
            Usuario usuario = listaUsuarios.get(login);
            usuario.setNome(novoNome);
            return usuario.getNome();
        }
    }

    @SuppressWarnings("unlikely-arg-type")
    public void definirPapel(String login, String nomeNovoPapel) {
        if (!listaUsuarios.containsKey(login)) {
            throw new IllegalArgumentException("O usuário não está cadastrado");
        }
        Usuario usuario = listaUsuarios.get(login);
        String nome = usuario.getNome();
        if (nomeNovoPapel.toLowerCase().equals("administrador")) {
            Administrador adm = new Administrador(login,nome);
            adm.setPapel(nomeNovoPapel);
            listaUsuarios.remove(usuario);
            listaUsuarios.put(login, adm);
        } else if (nomeNovoPapel.toLowerCase().equals("comun")) {
            Comun comun = new Comun(login,nome);
            comun.setPapel(nomeNovoPapel);
            listaUsuarios.remove(usuario);
            listaUsuarios.put(login, comun);
        }
    }

    public boolean podeAcao(String login, String acao) {
        if (!listaUsuarios.containsKey(login)) {
            throw new IllegalArgumentException("O usuário não está cadastrado");
        }
        Usuario usuario = listaUsuarios.get(login);
        if (usuario instanceof Administrador) {
            if (acao.toLowerCase().equals("criar") || acao.toLowerCase().equals("recuperar") || acao.toLowerCase().equals("editar") || acao.toLowerCase().equals("apagar")) {
                return true;
            } else {
                return false;
            }
        } else if (usuario instanceof Comun) {
            if (acao.toLowerCase().equals("recuperar")) {
                return true;
            } else {
                return false;
            }
        } else {
            throw new IllegalArgumentException("Algo de errado aconteceu!");

        }

    }

    public String getDescricao(String login) {
        if (!listaUsuarios.containsKey(login)) {
            throw new IllegalArgumentException("O usuário não está cadastrado");
        }
        Usuario usuario = listaUsuarios.get(login);
        if (usuario instanceof Administrador) {
            return usuario.toString();
        } else if (usuario instanceof Comun) {
            return usuario.toString();
        } else {
            throw new IllegalArgumentException("Erro na demonstracao da Descricao");
        }

    }

    public void cadastrarItemTexto(String login, String descricao, int ano, String texto, int relevancia) {
        if (!listaUsuarios.containsKey(login)) {
            throw new IllegalArgumentException("O usuário não está cadastrado");
        }
        Usuario usuario = listaUsuarios.get(login);
        Item item = new Texto(descricao,ano, texto, relevancia);
        usuario.setListaDeItemUsuarios(item);
        usuario.aumentarPontos();
    }

    public void cadastrarItemNumero(String login, String descricao, int ano, int numero) {
        if (!listaUsuarios.containsKey(login)) {
            throw new IllegalArgumentException("O usuário não está cadastrado");
        }
        Usuario usuario = listaUsuarios.get(login);
        Item item = new Numero(descricao,ano, numero);
        usuario.setListaDeItemUsuarios(item);
        usuario.aumentarPontos();
    }

    public int getItens(String login) {
        if (!listaUsuarios.containsKey(login)) {
            return 0;
        } else {
            Usuario usuario = listaUsuarios.get(login);
            return usuario.getPontos();
        }
    }

    public String[] listarUsuariosPorNumItens() {
        ArrayList<Usuario> arrayNovo = new ArrayList<>(listaUsuarios.values());
        String[] usuariosNomes = new String[arrayNovo.size()];
        Collections.sort(arrayNovo, (e1,e2) -> Integer.compare(e1.getPontos(),e2.getPontos()));
        int indice = 0;
        for (Usuario usuario : arrayNovo) {
            usuariosNomes[indice] = usuario.getNome();
            indice += 1;
        }
        return usuariosNomes;
    }
}
