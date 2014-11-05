package com.imranyousuf.planetsofage;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;


// This is written and edited by Imran Yousuf using various help from the internet,
// github and projects in order to learn how to make it functional.

public class AgeCalculator extends Activity implements AdapterView.OnItemSelectedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calculator);
        Spinner spinner = (Spinner) findViewById(R.id.solarChoices);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        EditText raw_age = (EditText) findViewById(R.id.editYears);
        raw_age.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                refreshNumbers();
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                refreshNumbers();
            }
            @Override
            public void afterTextChanged(Editable editable) {
                refreshNumbers();
            }
        });

    }

    public void refreshNumbers() {
        DecimalFormat df = new DecimalFormat("0.0 Years");
        Spinner spinner = (Spinner) findViewById(R.id.solarChoices);
        String sourcePlanet = spinner.getSelectedItem().toString();
        EditText raw_age = (EditText) findViewById(R.id.editYears);
        double source_age = 0;
        if(!raw_age.getText().toString().equals("")) {
            source_age = Double.parseDouble(raw_age.getText().toString());
        }


        TextView mercuryAge = (TextView) findViewById(R.id.mercuryAge);
        TextView venusAge = (TextView) findViewById((R.id.venusAge));
        TextView earthAge = (TextView) findViewById((R.id.earthAge));
        TextView marsAge = (TextView) findViewById((R.id.marsAge));
        TextView jupiterAge = (TextView) findViewById((R.id.jupiterAge));
        TextView saturnAge = (TextView) findViewById((R.id.saturnAge));
        TextView neptuneAge = (TextView) findViewById((R.id.neptuneAge));
        TextView uranusAge = (TextView) findViewById((R.id.uranusAge));

        mercuryAge.setText(Double.toString(0));
        venusAge.setText(Double.toString(0));
        earthAge.setText(Double.toString(0));
        marsAge.setText(Double.toString(0));
        jupiterAge.setText(Double.toString(0));
        saturnAge.setText(Double.toString(0));
        neptuneAge.setText(Double.toString(0));
        uranusAge.setText(Double.toString(0));

        if(sourcePlanet.equals("Mercury")) {
            mercuryAge.setText(df.format(source_age));
            venusAge.setText(df.format(calculateAge(source_age, mercury, venus)));
            earthAge.setText(df.format(calculateAge(source_age, mercury, earth)));
            marsAge.setText(df.format(calculateAge(source_age, mercury, mars)));
            jupiterAge.setText(df.format(calculateAge(source_age, mercury, jupiter)));
            saturnAge.setText(df.format(calculateAge(source_age, mercury, saturn)));
            neptuneAge.setText(df.format(calculateAge(source_age, mercury, neptune)));
            uranusAge.setText(df.format(calculateAge(source_age, mercury, uranus)));
        }
        if(sourcePlanet.equals("Venus")) {
            mercuryAge.setText(df.format(calculateAge(source_age, venus, mercury)));
            venusAge.setText(df.format(source_age));
            earthAge.setText(df.format(calculateAge(source_age, venus, earth)));
            marsAge.setText(df.format(calculateAge(source_age, venus, mars)));
            jupiterAge.setText(df.format(calculateAge(source_age, venus, jupiter)));
            saturnAge.setText(df.format(calculateAge(source_age, venus, saturn)));
            neptuneAge.setText(df.format(calculateAge(source_age, venus, neptune)));
            uranusAge.setText(df.format(calculateAge(source_age, venus, uranus)));
        }
        if(sourcePlanet.equals("Earth")) {
            mercuryAge.setText(df.format(calculateAge(source_age, earth, mercury)));
            venusAge.setText(df.format(calculateAge(source_age, earth, venus)));
            earthAge.setText(df.format(source_age));
            marsAge.setText(df.format(calculateAge(source_age, earth, mars)));
            jupiterAge.setText(df.format(calculateAge(source_age, earth, jupiter)));
            saturnAge.setText(df.format(calculateAge(source_age, earth, saturn)));
            neptuneAge.setText(df.format(calculateAge(source_age, earth, neptune)));
            uranusAge.setText(df.format(calculateAge(source_age, earth, uranus)));
        }
        if(sourcePlanet.equals("Mars")) {
            mercuryAge.setText(df.format(calculateAge(source_age, mars, mercury)));
            venusAge.setText(df.format(calculateAge(source_age, mars, venus)));
            earthAge.setText(df.format(calculateAge(source_age, mars, earth)));
            marsAge.setText(df.format(source_age));
            jupiterAge.setText(df.format(calculateAge(source_age, mars, jupiter)));
            saturnAge.setText(df.format(calculateAge(source_age, mars, saturn)));
            neptuneAge.setText(df.format(calculateAge(source_age, mars, neptune)));
            uranusAge.setText(df.format(calculateAge(source_age, mars, uranus)));
        }
        if(sourcePlanet.equals("Jupiter")) {
            mercuryAge.setText(df.format(calculateAge(source_age, jupiter, mercury)));
            venusAge.setText(df.format(calculateAge(source_age, jupiter, venus)));
            earthAge.setText(df.format(calculateAge(source_age, jupiter, earth)));
            marsAge.setText(df.format(calculateAge(source_age, jupiter, mars)));
            jupiterAge.setText(df.format(source_age));
            saturnAge.setText(df.format(calculateAge(source_age, jupiter, saturn)));
            neptuneAge.setText(df.format(calculateAge(source_age, jupiter, neptune)));
            uranusAge.setText(df.format(calculateAge(source_age, jupiter, uranus)));
        }
        if(sourcePlanet.equals("Saturn")) {
            mercuryAge.setText(df.format(calculateAge(source_age, saturn, mercury)));
            venusAge.setText(df.format(calculateAge(source_age, saturn, venus)));
            earthAge.setText(df.format(calculateAge(source_age, saturn, earth)));
            marsAge.setText(df.format(calculateAge(source_age, saturn, mars)));
            jupiterAge.setText(df.format(calculateAge(source_age, saturn, jupiter)));
            saturnAge.setText(df.format(calculateAge(source_age, saturn, saturn)));
            neptuneAge.setText(df.format(calculateAge(source_age, saturn, neptune)));
            uranusAge.setText(df.format(calculateAge(source_age, saturn, uranus)));
        }
        if(sourcePlanet.equals("Uranus")) {
            mercuryAge.setText(df.format(calculateAge(source_age, uranus, mercury)));
            venusAge.setText(df.format(calculateAge(source_age, uranus, venus)));
            earthAge.setText(df.format(calculateAge(source_age, uranus, earth)));
            marsAge.setText(df.format(calculateAge(source_age, uranus, mars)));
            jupiterAge.setText(df.format(calculateAge(source_age, uranus, jupiter)));
            saturnAge.setText(df.format(calculateAge(source_age, uranus, saturn)));
            neptuneAge.setText(df.format(calculateAge(source_age, uranus, neptune)));
            uranusAge.setText(df.format(source_age));
        }
        if(sourcePlanet.equals("Neptune")) {
            mercuryAge.setText(df.format(calculateAge(source_age, neptune, mercury)));
            venusAge.setText(df.format(calculateAge(source_age, neptune, venus)));
            earthAge.setText(df.format(calculateAge(source_age, neptune, earth)));
            marsAge.setText(df.format(calculateAge(source_age, neptune, mars)));
            jupiterAge.setText(df.format(calculateAge(source_age, neptune, jupiter)));
            saturnAge.setText(df.format(calculateAge(source_age, neptune, saturn)));
            neptuneAge.setText(df.format(source_age));
            uranusAge.setText(df.format(calculateAge(source_age, neptune, uranus)));
        }
    }

    public final static double mercury = 87.96;
    public final static double venus = 224.68;
    public final static double earth = 365.26;
    public final static double mars = 686.96;
    public final static double jupiter = 11.862 * earth;
    public final static double saturn = 29.456 * earth;
    public final static double uranus = 84.07 * earth;
    public final static double neptune = 164.81 * earth;


    public double calculateAge(double sourceAge, double sourcePlanet, double destinationPlanet) {

        return sourceAge*sourcePlanet/destinationPlanet;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.age_calculator, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
        refreshNumbers();
    }
}


