package target.aula.cursoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import target.aula.cursoandroid.service.AndroidServiceStartOnBoot;

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

        if(!AndroidServiceStartOnBoot.isIniciado()) {
            Intent serviceIntent = new Intent(this, AndroidServiceStartOnBoot.class);
            startService(serviceIntent);
        }
    }


}
