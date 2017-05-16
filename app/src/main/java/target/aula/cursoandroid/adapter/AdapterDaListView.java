package target.aula.cursoandroid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import target.aula.cursoandroid.R;
import target.aula.cursoandroid.asyncTask.DownloadTask;
import target.aula.cursoandroid.ed.Result;

/**
 * Created by sala01 on 12/05/2017.
 */

public class AdapterDaListView extends ArrayAdapter<Result> {


    private Context context;
    private List<Result> list;

    public AdapterDaListView(@NonNull Context context, @NonNull List<Result> list) {
        super(context, R.layout.itens_da_listview, list);

        this.context = context;
        this.list = list;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Result user = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.itens_da_listview, parent, false);
        }

        if (user.getcUsuario() == null) {
            user.setcUsuario((TextView) convertView.findViewById(R.id.txtNome));
        }
        if(user.getcLugar() == null){
            user.setcLugar((TextView) convertView.findViewById(R.id.txtLugar));
        }

        if(user.getcImagemPrincipal() == null){
            user.setcImagemPrincipal((ImageView) convertView.findViewById(R.id.imagemPrincipal));
        }
        if(user.getcImagemPessoa() == null){
            user.setcImagemPessoa((ImageView) convertView.findViewById(R.id.imagemPessoa));
        }

        if (user.getDownloadPessoa() == null) {
            user.setDownloadPessoa(new DownloadTask(user.getcImagemPessoa()));
            user.getDownloadPessoa().execute(user.getPicture().getThumbnail());
        }

        if (user.getDownloadPrincipal() == null) {
            user.setDownloadPrincipal(new DownloadTask(user.getcImagemPrincipal()));
            user.getDownloadPrincipal().execute(user.getPicture().getLarge());
        }

        user.getcUsuario().setText(user.getName().getFirst() + " " + user.getName().getLast());
        user.getcLugar().setText(user.getLocation().getCity());




//        .setImageBitmap(user.getbImagemPrincipal());
//        user.getcImagemPessoa().setImageBitmap(user.getbImagemPessoa());



        return convertView;

    }
}
