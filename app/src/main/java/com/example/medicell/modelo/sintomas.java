package com.example.medicell.modelo;

public class sintomas {

    int id_sintomas;
    String sintomas;
    int enfermedades_id_enfermedades;

    public sintomas(){};
    public sintomas( int id_sintomas, String sintomas){
        this.setId_sintomas(id_sintomas);
        this.setSintomas(sintomas);
    }

    public int getId_sintomas() {
        return id_sintomas;
    }

    public void setId_sintomas(int id_sintomas) {
        this.id_sintomas = id_sintomas;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public int getEnfermedades_id_enfermedades() {
        return enfermedades_id_enfermedades;
    }

    public void setEnfermedades_id_enfermedades(int enfermedades_id_enfermedades) {
        this.enfermedades_id_enfermedades = enfermedades_id_enfermedades;
    }
}
