package webapp.newsletterjdbc.model;

public class Usuario {
    private String email;
    private String senha;
    private String repeatSenha;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getRepeatSenha() {
        return repeatSenha;
    }
    public void setRepeatSenha(String repeatSenha) {
        this.repeatSenha = repeatSenha;
    }

    
}
