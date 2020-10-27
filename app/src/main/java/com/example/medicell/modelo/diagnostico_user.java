package com.example.medicell.modelo;

public class diagnostico_user {
        String nombre_apellido;
        String sintomas_presentados;
        String Diagnostico;
        String Enfermedad_presentados;

        public diagnostico_user(String nombre_apellido, String sintomas_presentados, String Diagnostico, String Enfermedad_presentados){
            this.nombre_apellido = nombre_apellido;
            this.sintomas_presentados = sintomas_presentados;
            this.Diagnostico = Diagnostico;
            this.Enfermedad_presentados = Enfermedad_presentados;

        }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getSintomas_presentados() {
        return sintomas_presentados;
    }

    public void setSintomas_presentados(String sintomas_presentados) {
        this.sintomas_presentados = sintomas_presentados;
    }

    public String getDiagnostico() {
        return Diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        Diagnostico = diagnostico;
    }

    public String getEnfermedad_presentados() {
        return Enfermedad_presentados;
    }

    public void setEnfermedad_presentados(String enfermedad_presentados) {
        Enfermedad_presentados = enfermedad_presentados;
    }
}
