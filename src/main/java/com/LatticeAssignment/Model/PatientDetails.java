package com.LatticeAssignment.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.*;

@Getter
@Setter
@Entity
@Table(name = "PATIENTS")
public class PatientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    @NotEmpty(message = "Enter name of length at least 3")
    @Column(name = "NAME")
    @Size(min=3)
    private String name;
    @NotEmpty(message = "Enter address of at least 10 characters")
    @Column(name = "ADDRESS")
    @Size(min = 10)
    private String address;
    @NotEmpty(message="Enter a valid email address")
    @Email
    @Column(name = "EMAIL")
    private String email;
    @NotEmpty(message = "This field cannot be empty!")
    @Column(name = "PHONE")
    private String phone;
    @NotEmpty(message = "Enter a valid password")
    @Column(name = "PASSWORD")
    @Size(min=8, max=15)
    private String password;
    @Column(name="APPOINTMENT_DATE")
    private String appointmentDate;
    @Column(name = "DATE_OBJ")
    private Date dateObj;

    public void setDateObj(String appointmentDate) throws ParseException {
        SimpleDateFormat sobj=new SimpleDateFormat("dd-MM-yyyy");
        this.dateObj=sobj.parse(appointmentDate);
    }

    @Override
    public String toString() {
        return "PatientDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", appointmentDate='" + appointmentDate + '\'' +
                ", dateObj=" + dateObj +
                '}';
    }
}
