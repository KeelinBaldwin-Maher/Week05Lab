package models; 

public class User {
        final String USERNAME;
        final String PASSWORD;
        
        User(String username) {
            this.USERNAME = username;
            this.PASSWORD = null;
        }
        
        public String getUsername() {
            return USERNAME;
        }
 }