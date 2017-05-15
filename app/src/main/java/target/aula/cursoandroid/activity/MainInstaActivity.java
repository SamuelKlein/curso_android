package target.aula.cursoandroid.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;

import target.aula.cursoandroid.R;
import target.aula.cursoandroid.adapter.AdapterDaListView;
import target.aula.cursoandroid.asyncTask.RadomUserRetorno;
import target.aula.cursoandroid.asyncTask.RadomUserTask;
import target.aula.cursoandroid.ed.Usuario;

public class MainInstaActivity extends AppCompatActivity implements RadomUserRetorno{

    private ListView listView;
    private RadomUserTask radomUserTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_insta);

        listView = (ListView) findViewById(R.id.listview);

        radomUserTask = new RadomUserTask(this);
    }

    @Override
    public void returnoArray(List<Usuario> listaUsuario) {
        try {
            if(listView.getAdapter() == null){
                listView.setAdapter(new AdapterDaListView(this, listaUsuario));
            } else {
                AdapterDaListView adapterDaListView = (AdapterDaListView) listView.getAdapter();
                adapterDaListView.clear();
//                for (Usuario object : listaUsuario) {
//                    adapterDaListView.insert(object, adapterDaListView.getCount());
//                }
                adapterDaListView.notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void atualizarTela(View view) {
        radomUserTask.execute("https://randomuser.me/api/?results=10&gender=female");
    }
}
