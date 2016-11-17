package at.fh.swengb.converter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private String[] spinnerItems;
    private Spinner spinner;
    private EditText etInput;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = (EditText) findViewById(R.id.etInput);
        tvResult = (TextView) findViewById(R.id.tvResult);
        spinnerItems = new String[] {"inch","cm"};
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, spinnerItems);
        spinner.setAdapter(adapter);
    }

    public void calculate(View view){
        Double value = Double.parseDouble(etInput.getText().toString());
        String valueString = "";
        if(spinner.getSelectedItem().toString()=="inch"){
            value = value * 2.54;
            valueString = String.format("%.6f",value);
            tvResult.setText("Result: "+valueString+" cm");
        }
        if(spinner.getSelectedItem().toString()=="cm"){
            value = value / 2.54;
            valueString = String.format("%.6f",value);
            tvResult.setText("Result: "+valueString+" inch");
        }

    }
    public void showAbout(View view){
        Intent intent = new Intent(this,DisplayAboutActivity.class);
        String message = tvResult.getText().toString();
        intent.putExtra("resultOfConversion",message);
        startActivity(intent);

    }
}
