
package target.aula.cursoandroid.ed;


import android.widget.ImageView;
import android.widget.TextView;

import target.aula.cursoandroid.asyncTask.DownloadTask;

public class Result {

    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Login login;
    private String dob;
    private String registered;
    private String phone;
    private String cell;
    private Id id;
    private Picture picture;
    private String nat;

    private TextView cUsuario;
    private TextView cLugar;
    private ImageView cImagemPrincipal;
    private ImageView cImagemPessoa;

    private DownloadTask downloadPrincipal;
    private DownloadTask downloadPessoa;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
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

    public void setcImagemPrincipal(ImageView cImagemPrincipal) {
        this.cImagemPrincipal = cImagemPrincipal;
    }

    public ImageView getcImagemPessoa() {
        return cImagemPessoa;
    }

    public void setcImagemPessoa(ImageView cImagemPessoa) {
        this.cImagemPessoa = cImagemPessoa;
    }

    public DownloadTask getDownloadPrincipal() {
        return downloadPrincipal;
    }

    public void setDownloadPrincipal(DownloadTask downloadPrincipal) {
        this.downloadPrincipal = downloadPrincipal;
    }

    public DownloadTask getDownloadPessoa() {
        return downloadPessoa;
    }

    public void setDownloadPessoa(DownloadTask downloadPessoa) {
        this.downloadPessoa = downloadPessoa;
    }
}
