package com.redmath.account;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long account_id;
    private String password;
    private String name;
    private String email;
    private String address;

    public Long getId() {
        return account_id;
    }

    public void setId(Long id) {
        this.account_id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

