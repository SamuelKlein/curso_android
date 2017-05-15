package target.aula.cursoandroid.ed;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sala01 on 09/05/2017.
 */

public class Usuario {

    private String usuario;
    private String lugar;
    private Bitmap bImagemPrincipal;
    private Bitmap bImagemPessoa;


    private TextView cUsuario;
    private TextView cLugar;
    private ImageView cImagemPrincipal;

    private ImageView cImagemPessoa;

    public Usuario() {

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public TextView getcUsuario() {
        return cUsuario;
    }

    public void setcUsuario(TextView cUsuario) {
        this.cUsuario = cUsuario;
    }

    public TextView getcLugar() {
        return cLugar;
    }

    public void setcLugar(TextView cLugar) {
        this.cLugar = cLugar;
    }

    public ImageView getcImagemPrincipal() {
        return cImagemPrincipal;
    }

    public Bitmap getbImagemPrincipal() {
        return bImagemPrincipal;
    }

    public void setcImagemPrincipal(ImageView cImagemPrincipal) {
        this.cImagemPrincipal = cImagemPrincipal;
    }

    public ImageView getcImagemPessoa() {
        return cImagemPessoa;
    }

    public void setcImagemPessoa(ImageView cImagemPessoa) {
        this.cImagemPessoa = cImagemPessoa;
    }

    public void setbImagemPrincipal(Bitmap bImagemPrincipal) {
        this.bImagemPrincipal = bImagemPrincipal;
    }

    public Bitmap getbImagemPessoa() {
        return bImagemPessoa;
    }

    public void setbImagemPessoa(Bitmap bImagemPessoa) {
        this.bImagemPessoa = bImagemPessoa;
    }
}
