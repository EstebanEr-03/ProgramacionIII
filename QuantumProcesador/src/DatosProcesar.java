public class DatosProcesar {
     String identificadorDeProcesos,cedula;
     int tiempoProcesar;

    public DatosProcesar(String identificadorDeProcesos, String cedula, int tiempoProcesar) {
        this.identificadorDeProcesos = identificadorDeProcesos;
        this.cedula = cedula;
        this.tiempoProcesar = tiempoProcesar;
    }

    public String getIdentificadorDeProcesos() {
        return identificadorDeProcesos;
    }

    public void setIdentificadorDeProcesos(String identificadorDeProcesos) {
        this.identificadorDeProcesos = identificadorDeProcesos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getTiempoProcesar() {
        return tiempoProcesar;
    }

    public void setTiempoProcesar(int tiempoProcesar) {
        this.tiempoProcesar = tiempoProcesar;
    }

    @Override
    public String toString() {
        return "identificadorDeProcesos='" + identificadorDeProcesos + '\'' +
                " cedula='" + cedula + '\'' +
                " tiempoProcesar=" + tiempoProcesar
                ;
    }
}
