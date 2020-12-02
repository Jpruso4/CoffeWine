package PPI.Modelos;

/**
 *
 * @author Personal
 */
public class ModeloSesion {

    boolean sesionActiva;
    int idUsuario;
    int tipoUsuario;
    String Nick;
    String Correo;
    String Puto;

    public boolean isSesionActiva() {
        return sesionActiva;
    }

    public void setSesionActiva(boolean sesionActiva) {
        this.sesionActiva = sesionActiva;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int gettipoUsuario() {
        return tipoUsuario;
    }

    public void settipoUsuario(int TipoUsuario) {
        this.tipoUsuario = TipoUsuario;
    }

    public String getNick() {
        return Nick;
    }

    public void setNick(String Nick) {
        this.Nick = Nick;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
}
