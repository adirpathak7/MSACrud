/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.it.serverapp.ejb;

import com.it.serverapp.entity.Doctorsappointment;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author Aditya Pathak R
 */
@Stateless
public class DoctorBean {

    @PersistenceContext(unitName = "mypu")
    EntityManager entityManager;

    public List<Doctorsappointment> getAllDoctors() {
        List<Doctorsappointment> list = entityManager.createNamedQuery("Doctorsappointment.findAll").getResultList();
        return list;
    }

    public List<Doctorsappointment> getDoctorsBySpecialization(String specialization) {
        List<Doctorsappointment> list = entityManager.createNamedQuery("Doctorsappointment.findBySpecialization", Doctorsappointment.class)
                .setParameter("specialization", specialization)
                .getResultList();
        return list;
    }

}
