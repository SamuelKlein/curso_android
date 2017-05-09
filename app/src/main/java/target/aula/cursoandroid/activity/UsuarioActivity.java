package target.aula.cursoandroid.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import target.aula.cursoandroid.R;
import target.aula.cursoandroid.ed.Usuario;

public class UsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        Intent intent = getIntent();
        TextView txtNome = (TextView) findViewById(R.id.txtNome);

        String json = intent.getStringExtra("usuario");
        Usuario usuario = new Gson().fromJson(json, Usuario.class);


        txtNome.setText(intent.getStringExtra("usuario"));
    }
}
