package mainactivity.franzfonseca.com.notasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText eExpo, ePra, ePro, eNotaF;
    Button bCalcular, blimpiar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eExpo = (EditText) findViewById(R.id.eExpo);
        ePra = (EditText) findViewById(R.id.ePrac);
        ePro = (EditText) findViewById(R.id.eProy);
        eNotaF = (EditText) findViewById(R.id.eNotafinal);
        bCalcular = (Button)findViewById(R.id.bCal);
        blimpiar = (Button)findViewById(R.id.bLimp);


        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double notaF;

                notaF = Double.parseDouble(eExpo.getText().toString())*15/100 + Double.parseDouble(ePra.getText().toString())*50/100 +
                        Double.parseDouble(ePro.getText().toString())*35/100;
                eNotaF.setText(String.valueOf(notaF));


            }
        });
        blimpiar.setOnClickListener(this);


    }
    @Override

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }

    @Override

    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();
        if (id == R.id.mConfig){
            //Toast.makeText(MainActivity.this, "Presionó menu Configuración", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, SettingsActivity.class);
            intent.putExtra("pExpo",15);
            intent.putExtra("pProy",35);
            intent.putExtra("pPrac", 50);
            //startActivity(intent);
            startActivityForResult(intent, 1234);        }
            return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String exp, pra, pro;
        if (requestCode==1234 && resultCode==RESULT_OK){
            exp = data.getExtras().getString("npExp");
            pro = data.getExtras().getString("npProy");
            pra = data.getExtras().getString("npPrac");

            Toast.makeText(MainActivity.this, "Nuevos datos: Exposiciones: "+exp+" Practicas"+pra+" "+ "Proyecto"+pro, Toast.LENGTH_SHORT).show();


        }
    }


    @Override
    public void onClick(View v) {
        eExpo.setText("");
        ePro.setText("");
        ePra.setText("");
        eNotaF.setText("");


     }


}


