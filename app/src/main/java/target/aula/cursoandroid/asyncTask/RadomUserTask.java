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
import target.aula.cursoandroid.ed.Usuario;

/**
 * Created by sala01 on 15/05/2017.
 */

public class RadomUserTask extends AsyncTask<String, Object, List<Usuario>> {

    private RadomUserRetorno radomUserRetorno;

    public RadomUserTask(RadomUserRetorno radomUserRetorno) {
        this.radomUserRetorno = radomUserRetorno;
    }

    @Override
    protected List<Usuario> doInBackground(String... params) {
        Comunicacao c = new Comunicacao();
        try {
            List<Usuario> lista = new ArrayList<>();

            String json = c.get(params[0]);
            JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
            JsonArray array = jsonObject.getAsJsonArray("results");

            for (JsonElement jsonElement : array) {
                JsonObject usuario = (JsonObject) jsonElement;
                JsonObject onome = usuario.getAsJsonObject("name");
                JsonObject picture = usuario.getAsJsonObject("picture");
                String urlImagem = picture.getAsJsonPrimitive("large").getAsString();

                Usuario usuarioed = new Usuario();
                usuarioed.setUsuario(onome.getAsJsonPrimitive("first").getAsString()  + " "+ onome.getAsJsonPrimitive("last").getAsString());
                usuarioed.setLugar(usuario.getAsJsonObject("location").getAsJsonPrimitive("street").getAsString());
                Bitmap bitmap = BitmapFactory.decodeStream(c.getInputStream(urlImagem));
                usuarioed.setbImagemPessoa(bitmap);
                usuarioed.setbImagemPrincipal(bitmap);


                lista.add(usuarioed);
            }

            return lista;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(List<Usuario> jsonArray) {
        radomUserRetorno.returnoArray(jsonArray);
    }
}
