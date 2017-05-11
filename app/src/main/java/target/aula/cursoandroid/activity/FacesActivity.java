package target.aula.cursoandroid.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;

import target.aula.cursoandroid.R;

public class FacesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faces);
    }

    public void dialogtext(View view) {

        MaterialDialog dialog = new MaterialDialog.Builder(this)
                .title(R.string.title)
                .content(R.string.content)
                .positiveText(R.string.agree)
                .show();

    }

    public void dialogList(View view) {

        new MaterialDialog.Builder(this)
                .title(R.string.title)
                .items(R.array.minhaLista)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                    }
                })
                .show();

    }

    public void dialogView(View view) {

        boolean wrapInScrollView = true;
        new MaterialDialog.Builder(this)
                .title(R.string.title)
                .customView(R.layout.dialog_loko, wrapInScrollView)
                .positiveText(R.string.positive)
                .show();
    }
}
