package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TUSER")
public class User {
    
    @Id
    @Column(name="ID")
    public Long id;

    @Column(name="LOGIN")
    public String login;
    @Column(name="NAME")
    public String name;
    @Column(name="LASTNAME")
    public String lastname;
    @Column(name="PASSWORD")
    public String password;
    
    public User(){}
    
    public User(String login,String name,String lastname,String password){
        this.login = login;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
    }
    
    public String getLogin(){
        return this.login;
    }
    
    public void setLogin(String login){
        this.login = login;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getLastName(){
        return this.lastname;
    
    }
    
    public void setLastName(String lastname){
        this.lastname = lastname;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
}