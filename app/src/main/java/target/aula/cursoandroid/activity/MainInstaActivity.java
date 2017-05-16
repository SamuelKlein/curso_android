package target.aula.cursoandroid.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import target.aula.cursoandroid.R;
import target.aula.cursoandroid.adapter.AdapterDaListView;
import target.aula.cursoandroid.asyncTask.RadomUserRetorno;
import target.aula.cursoandroid.ed.Result;

public class MainInstaActivity extends AppCompatActivity implements RadomUserRetorno{

    private ListView listView;
//    private RadomUserTask radomUserTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_insta);

        listView = (ListView) findViewById(R.id.listview);


        atualizarTela(listView);

        createNewFragment();
//        radomUserTask = new RadomUserTask(this);
    }

    private void createNewFragment() {
        FragmentoDeSangue fragmentoDeSangue = new FragmentoDeSangue();
        FragmentManager manager = this.getSupportFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_conteiner,fragmentoDeSangue);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void returnoArray(List<Result> listaUsuario) {
        try {
            if(listView.getAdapter() == null){
                listView.setAdapter(new AdapterDaListView(this, listaUsuario));
            } else {
                listView.setAdapter(new AdapterDaListView(this, listaUsuario));
                listView.notify();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void atualizarTela(View view) {

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("results");

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Result> lista = new ArrayList<Result>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    try{
                        Log.d("LINHA", lista.size() + "");
                        lista.add(snapshot.getValue(Result.class));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                returnoArray(lista);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

//        radomUserTask.execute("https://randomuser.me/api/?results=10&gender=female");
    }
}
