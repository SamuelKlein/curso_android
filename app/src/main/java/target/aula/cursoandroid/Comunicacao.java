package target.aula.cursoandroid;

import android.net.http.HttpResponseCache;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by sala01 on 12/05/2017.
 */

public class Comunicacao {

    OkHttpClient client = new OkHttpClient();

    public String get(String url) throws IOException {
        Request request = new Request.Builder().url(url)
                .build();

        Response response = client.newCall(request).execute();

        return response.body().toString();
    }

}
