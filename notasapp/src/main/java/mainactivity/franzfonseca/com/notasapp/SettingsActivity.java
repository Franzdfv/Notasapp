package mainactivity.franzfonseca.com.notasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {
    EditText epExpo, epPra, epProy;
    Button bGuardar, ebLimpiarcampos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        epExpo= (EditText) findViewById(R.id.epExpo);
        epProy= (EditText) findViewById(R.id.epProy);
        epPra= (EditText) findViewById(R.id.epPrac);
        bGuardar= (Button) findViewById(R.id.bGuardar);
        ebLimpiarcampos= (Button) findViewById(R.id.ebLimp);



        Bundle extras =  getIntent().getExtras();

        epExpo.setText(String.valueOf(extras.getInt("pExpo")));
        epProy.setText(String.valueOf(extras.getInt("pProy")));
        epPra.setText(String.valueOf(extras.getInt("pPrac")));

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("npExp", epExpo.getText().toString());
                intent.putExtra("npProy", epProy.getText().toString());
                intent.putExtra("npPrac", epPra.getText().toString());
                setResult(RESULT_OK, intent);
                finish();


            }

        });
        ebLimpiarcampos.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        epExpo.setText("");
        epProy.setText("");
        epPra.setText("");


    }
}
