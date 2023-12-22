package com.maxi.backschool.entities;

import java.io.Serializable;
import java.time.LocalDate;

import com.maxi.backschool.enums.UserGender;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@MappedSuperclass
public abstract class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be correct")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Fone number is required")
    @Column(name = "fonenumber")
    private String foneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private UserGender gender;

    @Temporal(TemporalType.DATE)
    @NotBlank(message = "A Date is required")
    @Column(name = "birthday")
    private LocalDate birthDay;

    @Temporal(TemporalType.DATE)
    @Column(name = "registdate")
    private LocalDate registrationDate;

    private boolean active;

    public User() {
        super();
    }

    public User(String name, String email, String foneNumber, UserGender gender, LocalDate birthDay,
            LocalDate registrationDate) {

        this.name = name;
        this.email = email;
        this.foneNumber = foneNumber;
        this.gender = gender;
        this.birthDay = birthDay;
        this.registrationDate = registrationDate;
        this.active = true;
    }

    public Long getId() {
        return id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoneNumber() {
        return foneNumber;
    }

    public void setFoneNumber(String foneNumber) {
        this.foneNumber = foneNumber;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public UserGender getGender() {
        return gender;
    }

    public void setGender(UserGender gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((foneNumber == null) ? 0 : foneNumber.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (foneNumber == null) {
            if (other.foneNumber != null)
                return false;
        } else if (!foneNumber.equals(other.foneNumber))
            return false;
        if (gender != other.gender)
            return false;
        return true;
    }

}
