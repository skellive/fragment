package com.example.medicell.modelo;

public class enfermedades {
        Integer id_enfermedades;
        String enfermedades;
        Integer enfermedades_has_diagnostico_diagnostico_id_diagnostico;

        public enfermedades(Integer id_enfermedades, String enfermedades, Integer enfermedades_has_diagnostico_diagnostico_id_diagnostico){
            this.id_enfermedades = id_enfermedades;
            this.enfermedades = enfermedades;
            this.enfermedades_has_diagnostico_diagnostico_id_diagnostico = enfermedades_has_diagnostico_diagnostico_id_diagnostico;

        }

    public Integer getId_enfermedades() {
        return id_enfermedades;
    }

    public void setId_enfermedades(Integer id_enfermedades) {
        this.id_enfermedades = id_enfermedades;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public Integer getEnfermedades_has_diagnostico_diagnostico_id_diagnostico() {
        return enfermedades_has_diagnostico_diagnostico_id_diagnostico;
    }

    public void setEnfermedades_has_diagnostico_diagnostico_id_diagnostico(Integer enfermedades_has_diagnostico_diagnostico_id_diagnostico) {
        this.enfermedades_has_diagnostico_diagnostico_id_diagnostico = enfermedades_has_diagnostico_diagnostico_id_diagnostico;
    }
}
