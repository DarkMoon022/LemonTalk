package com.example.lemontalk;

public class User {
    private int id;
    private String userName;
    private String email;
    private String password;
    private String selectedLanguage;

    public User(String userName, String email, String password, String selectedLanguage) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.selectedLanguage = selectedLanguage;
    }

    public int getId() { return id; }
    public String getUserName() { return userName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getSelectedLanguage() { return selectedLanguage; }

    public void setId(int id) { this.id = id; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setSelectedLanguage(String selectedLanguage) { this.selectedLanguage = selectedLanguage; }
}
