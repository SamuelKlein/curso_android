package target.aula.cursoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExemploInterface extends AppCompatActivity {

    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo_interface);


        Button button = (Button) findViewById(R.id.button);
        final TextView textView = (TextView) findViewById(R.id.textView);



        button.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  textView.setText("Q SACANAGEM" + (i++) );
              }
          });
    }


}
