package target.aula.cursoandroid.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import target.aula.cursoandroid.R;

/**
 * Created by sala01 on 16/05/2017.
 */

public class FragmentoDeSangue extends Fragment {

    private ImageView imgMaOI;
    private TextView txtMaOI;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentos_de_sangue, container, false);

        imgMaOI = (ImageView)view.findViewById(R.id.imgMaOI);
        txtMaOI = (TextView)view.findViewById(R.id.txtMaOI);
        return view;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }
}
