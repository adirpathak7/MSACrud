/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.it.serverapp.entity;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author Aditya Pathak R
 */
@Entity
@Table(name = "doctorsappointment")
@NamedQueries({
    @NamedQuery(name = "Doctorsappointment.findAll", query = "SELECT d FROM Doctorsappointment d"),
    @NamedQuery(name = "Doctorsappointment.findByDoctorId", query = "SELECT d FROM Doctorsappointment d WHERE d.doctorId = :doctorId"),
    @NamedQuery(name = "Doctorsappointment.findByDoctorName", query = "SELECT d FROM Doctorsappointment d WHERE d.doctorName = :doctorName"),
    @NamedQuery(name = "Doctorsappointment.findByAddress", query = "SELECT d FROM Doctorsappointment d WHERE d.address = :address"),
    @NamedQuery(name = "Doctorsappointment.findBySpecialization", query = "SELECT d FROM Doctorsappointment d WHERE d.specialization = :specialization"),
    @NamedQuery(name = "Doctorsappointment.findByFromTime", query = "SELECT d FROM Doctorsappointment d WHERE d.fromTime = :fromTime"),
    @NamedQuery(name = "Doctorsappointment.findByToTime", query = "SELECT d FROM Doctorsappointment d WHERE d.toTime = :toTime")})
public class Doctorsappointment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "doctorId")
    private Integer doctorId;
    @Basic(optional = false)
    @Column(name = "doctorName")
    private String doctorName;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "specialization")
    private String specialization;
    @Basic(optional = false)
    @Column(name = "fromTime")
    private String fromTime;
    @Basic(optional = false)
    @Column(name = "toTime")
    private String toTime;

    public Doctorsappointment() {
    }

    public Doctorsappointment(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Doctorsappointment(Integer doctorId, String doctorName, String address, String specialization, String fromTime, String toTime) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.address = address;
        this.specialization = specialization;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doctorId != null ? doctorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctorsappointment)) {
            return false;
        }
        Doctorsappointment other = (Doctorsappointment) object;
        if ((this.doctorId == null && other.doctorId != null) || (this.doctorId != null && !this.doctorId.equals(other.doctorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.it.serverapp.entity.Doctorsappointment[ doctorId=" + doctorId + " ]";
    }
    
}
