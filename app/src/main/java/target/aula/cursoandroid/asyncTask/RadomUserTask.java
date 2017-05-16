package target.aula.cursoandroid.asyncTask;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import target.aula.cursoandroid.Comunicacao;
import target.aula.cursoandroid.ed.RandomUsers;
import target.aula.cursoandroid.ed.Result;

/**
 * Created by sala01 on 15/05/2017.
 */

public class RadomUserTask extends AsyncTask<String, Object, List<Result>> {

    private RadomUserRetorno radomUserRetorno;

    public RadomUserTask(RadomUserRetorno radomUserRetorno) {
        this.radomUserRetorno = radomUserRetorno;
    }

    @Override
    protected List<Result> doInBackground(String... params) {
        Comunicacao c = new Comunicacao();
        try {
            String json = c.get(params[0]);
            RandomUsers randomUsers = new Gson().fromJson(json, RandomUsers.class);
            return randomUsers.getResults();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(List<Result> jsonArray) {
        radomUserRetorno.returnoArray(jsonArray);
    }
}
