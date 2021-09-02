package model;

public class User {
    private String username;
    private String password;
    private String confirm_password;
    private String email;
    private String security_answer;
    private String security_question;
    private int id;

    public User() {
        
    }
    
    public User(String username, String password, String confirm_password, String email, String security_answer, String security_question, int id) {
        this.username = username;
        this.password = password;
        this.confirm_password = confirm_password;
        this.email = email;
        this.security_answer = security_answer;
        this.security_question = security_question;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public String getSecurity_answer() {
        return security_answer;
    }

    public void setSecurity_answer(String security_answer) {
        this.security_answer = security_answer;
    }

    public String getSecurity_question() {
        return security_question;
    }

    public void setSecurity_question(String security_question) {
        this.security_question = security_question;
    }    
}
