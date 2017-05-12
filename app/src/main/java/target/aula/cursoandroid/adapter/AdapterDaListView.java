package target.aula.cursoandroid.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import target.aula.cursoandroid.R;
import target.aula.cursoandroid.ed.Usuario;

/**
 * Created by sala01 on 12/05/2017.
 */

public class AdapterDaListView extends ArrayAdapter<Usuario> {


    private Context context;
    private List<Usuario> list;

    public AdapterDaListView(@NonNull Context context, @NonNull List<Usuario> list) {
        super(context, R.layout.itens_da_listview, list);

        this.context = context;
        this.list = list;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Usuario user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.itens_da_listview, parent, false);
        }
        // Lookup view for data population
//        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
//        TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
//        // Populate the data into the template view using the data object
//        tvName.setText(user.name);
//        tvHome.setText(user.hometown);
        // Return the completed view to render on screen
        return convertView;

    }
}
