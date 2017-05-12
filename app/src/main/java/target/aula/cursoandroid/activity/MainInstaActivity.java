package target.aula.cursoandroid.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import target.aula.cursoandroid.Comunicacao;
import target.aula.cursoandroid.R;
import target.aula.cursoandroid.adapter.AdapterDaListView;
import target.aula.cursoandroid.ed.Usuario;

public class MainInstaActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_insta);

        listView = (ListView) findViewById(R.id.listview);


        Comunicacao c = new Comunicacao();

        try {
            String json = c.get("https://randomuser.me/api/?results=30");

            List<Usuario> lista = new ArrayList<>();

            JSONObject jsonObject = new GsonBuilder().create().fromJson();

            lista.add(new Usuario("joao1", "asdfasdf","dasdfasfkjasdf"));
            lista.add(new Usuario("joao2", "asdfasdf","dasdfasfkjasdf"));
            lista.add(new Usuario("joao3", "asdfasdf","dasdfasfkjasdf"));
            lista.add(new Usuario("joao4", "asdfasdf","dasdfasfkjasdf"));
            lista.add(new Usuario("joao5", "asdfasdf","dasdfasfkjasdf"));
            lista.add(new Usuario("joao6", "asdfasdf","dasdfasfkjasdf"));
            lista.add(new Usuario("joao7", "asdfasdf","dasdfasfkjasdf"));
            lista.add(new Usuario("joao8", "asdfasdf","dasdfasfkjasdf"));
            lista.add(new Usuario("joao9", "asdfasdf","dasdfasfkjasdf"));
            lista.add(new Usuario("joao9", "asdfasdf","dasdfasfkjasdf"));
            lista.add(new Usuario("joao9", "asdfasdf","dasdfasfkjasdf"));

            listView.setAdapter(new AdapterDaListView(this, lista));

        } catch (IOException e) {
            e.printStackTrace();
        }



    }


}
