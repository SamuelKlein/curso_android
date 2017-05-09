package target.aula.cursoandroid.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import target.aula.cursoandroid.R;
import target.aula.cursoandroid.ed.Usuario;

public class LoginActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = (Button) findViewById(R.id.btnOk);
        editText = (EditText) findViewById(R.id.editText);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, UsuarioActivity.class);
                Usuario usuario = new Usuario();
                usuario.setUsuario(editText.getText().toString());
                usuario.setDescricao("Seilah");
                usuario.setSenha("asdfsafdfsfsdaf");
                intent.putExtra("usuario", new Gson().toJson(usuario));
                startActivity(intent);
            }
        });
    }
}
