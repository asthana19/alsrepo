package com.management.alscare.data.model;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint("ParcelCreator")
public class PatientInfo implements Parcelable {
    private String patientId;
    private String patientName;
    private int patientAge;
    private String gender;
    private String typeOfOnset;
    private String dateOfFirstSymptoms;
    private String dateOfDiagnosis;

    private String currentCondition;
    private String caregiver;
    private String medico;
    private String emailId;
    private String phone;
    private String address;

    public PatientInfo(){

    }

    public PatientInfo(Parcel in) {
        patientId = in.readString();
        patientName = in.readString();
        patientAge = in.readInt();
        gender = in.readString();
        typeOfOnset = in.readString();
        dateOfFirstSymptoms = in.readString();
        dateOfDiagnosis = in.readString();
        currentCondition = in.readString();
        caregiver = in.readString();
        medico = in.readString();
        emailId = in.readString();
        phone = in.readString();
        address = in.readString();

    }

    public static final Creator<PatientInfo> CREATOR = new Creator<PatientInfo>() {
        @Override
        public PatientInfo createFromParcel(Parcel in) {
            return new PatientInfo(in);
        }

        @Override
        public PatientInfo[] newArray(int size) {
            return new PatientInfo[size];
        }
    };

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTypeOfOnset() {
        return typeOfOnset;
    }

    public void setTypeOfOnset(String typeOfOnset) {
        this.typeOfOnset = typeOfOnset;
    }

    public String getFirstSymptoms() {
        return dateOfFirstSymptoms;
    }

    public void setFirstSymptoms(String firstSymptoms) {
        this.dateOfFirstSymptoms = firstSymptoms;
    }

    public String getDateOfDiagnosis() {
        return dateOfDiagnosis;
    }

    public void setDateOfDiagnosis(String dateOfDiagnosis) {
        this.dateOfDiagnosis = dateOfDiagnosis;
    }

    public String getCurrentCondition() {
        return currentCondition;
    }

    public void setCurrentCondition(String currentCondition) {
        this.currentCondition = currentCondition;
    }

    public String getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(String caregiver) {
        this.caregiver = caregiver;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String caregiver) {
        this.medico = medico;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(patientId);
        parcel.writeString(patientName);
        parcel.writeInt(patientAge);
        parcel.writeString(gender);
        parcel.writeString(typeOfOnset);
        parcel.writeString(dateOfFirstSymptoms);
        parcel.writeString(dateOfDiagnosis);
        parcel.writeString(currentCondition);
        parcel.writeString(caregiver);
        parcel.writeString(medico);
        parcel.writeString(emailId);
        parcel.writeString(phone);
        parcel.writeString(address);
    }
}
