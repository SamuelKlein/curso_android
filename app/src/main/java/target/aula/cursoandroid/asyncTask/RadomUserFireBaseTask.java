package target.aula.cursoandroid.asyncTask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import target.aula.cursoandroid.Comunicacao;
import target.aula.cursoandroid.ed.Result;
import target.aula.cursoandroid.ed.Usuario;

/**
 * Created by sala01 on 15/05/2017.
 */

public class RadomUserFireBaseTask extends AsyncTask<String, Object, List<Result>> {

    private RadomUserRetorno radomUserRetorno;

    public RadomUserFireBaseTask(RadomUserRetorno radomUserRetorno) {
        this.radomUserRetorno = radomUserRetorno;
    }


    @Override
    protected List<Result> doInBackground(String... params) {

        return null;
    }
}
