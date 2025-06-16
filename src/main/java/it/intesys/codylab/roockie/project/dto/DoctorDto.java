package it.intesys.codylab.roockie.project.dto;

public class AccountDto {
   private int id;
   private String nome;
   private String specializzazione;

    public AccountDto(int id, String nome, String specializzazione) {
        this.id = id;
        this.nome = nome;
        this.specializzazione = specializzazione;
    }

    public int getId() {co
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSpecializzazione() {
        return specializzazione;
    }
}
