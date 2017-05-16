package target.aula.cursoandroid.asyncTask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import target.aula.cursoandroid.Comunicacao;
import target.aula.cursoandroid.ed.RandomUsers;
import target.aula.cursoandroid.ed.Result;

/**
 * Created by sala01 on 15/05/2017.
 */

public class DownloadTask extends AsyncTask<String, Object, Bitmap> {

    private ImageView imageView;

    public DownloadTask(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Comunicacao c = new Comunicacao();
        try {
            InputStream in = c.getInputStream(params[0]);
            return BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        this.imageView.setImageBitmap(bitmap);
    }
}
