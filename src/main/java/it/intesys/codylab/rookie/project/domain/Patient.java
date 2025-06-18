package it.intesys.codylab.rookie.project.domain;

import java.time.Instant;

public class Patient {
    private long id;
    private long opd;
    private long idp;
    private String name;
    private String surname;
    private int phoneNumber;
    private String address;
    private String email;
    private String avatar;
    private BloodType bloodGroup;
    private String type;
    private String notes;
    private boolean chronicPatient;
    private Instant dateTime;
    private String lastDoctorVisitedId;
    private Long[] doctorIds;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOpd() {
        return opd;
    }

    public void setOpd(long opd) {
        this.opd = opd;
    }

    public long getIdp() {
        return idp;
    }

    public void setIdp(long idp) {
        this.idp = idp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public BloodType getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodType bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isChronicPatient() {
        return chronicPatient;
    }

    public void setChronicPatient(boolean chronicPatient) {
        this.chronicPatient = chronicPatient;
    }

    public Instant getDateTime() {
        return dateTime;
    }

    public void setDateTime(Instant dateTime) {
        this.dateTime = dateTime;
    }

    public String getLastDoctorVisitedId() {
        return lastDoctorVisitedId;
    }

    public void setLastDoctorVisitedId(String lastDoctorVisitedId) {
        this.lastDoctorVisitedId = lastDoctorVisitedId;
    }

    public Long[] getDoctorIds() {
        return doctorIds;
    }

    public void setDoctorIds(Long[] doctorIds) {
        this.doctorIds = doctorIds;
    }
}
