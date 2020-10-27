package com.example.medicell.modelo;

public class Diagnostico {
        String idDiagnostico;
        String nombre_apellido;
        String Diagnostico;
        String Sintomas_presentados;
        String enfermedades_has_diagnostico_diagnostico_id_diagnostico;

        public Diagnostico(String idDiagnostico, String nombre_apellido,String Diagnostico, String Sintomas_presentados, String enfermedades_has_diagnostico_diagnostico_id_diagnostico){
            this.idDiagnostico = idDiagnostico;
            this.nombre_apellido = nombre_apellido;
            this.Diagnostico = Diagnostico;
            this.Sintomas_presentados = Sintomas_presentados;
            this.enfermedades_has_diagnostico_diagnostico_id_diagnostico = enfermedades_has_diagnostico_diagnostico_id_diagnostico;

        }

    public String getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(String idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getDiagnostico() {
        return Diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        Diagnostico = diagnostico;
    }

    public String getSintomas_presentados() {
        return Sintomas_presentados;
    }

    public void setSintomas_presentados(String sintomas_presentados) {
        Sintomas_presentados = sintomas_presentados;
    }

    public String getEnfermedades_has_diagnostico_diagnostico_id_diagnostico() {
        return enfermedades_has_diagnostico_diagnostico_id_diagnostico;
    }

    public void setEnfermedades_has_diagnostico_diagnostico_id_diagnostico(String enfermedades_has_diagnostico_diagnostico_id_diagnostico) {
        this.enfermedades_has_diagnostico_diagnostico_id_diagnostico = enfermedades_has_diagnostico_diagnostico_id_diagnostico;
    }
}
