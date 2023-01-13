package model;

public class Sessao {

private String nome_usuario;


    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public Sessao(String nome_usuario) {
       
        this.nome_usuario = nome_usuario;
       
    }


}
