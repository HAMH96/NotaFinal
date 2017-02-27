package com.example.humor.notafinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView labelFinalGrade;
    private TextView showFinalGrade;
    private EditText editPracticas;
    private EditText editAvance1;
    private EditText editAvance2;
    private EditText editAvance3;
    private EditText editAppFinal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        labelFinalGrade = (TextView) findViewById(R.id.labelFinalGrade);
        showFinalGrade = (TextView) findViewById(R.id.showFinalGrade);
        editPracticas = (EditText) findViewById(R.id.editPracticas);
        editAvance1 = (EditText) findViewById(R.id.editAvance1);
        editAvance2 = (EditText) findViewById(R.id.editAvance2);
        editAvance3 = (EditText) findViewById(R.id.editAvance3);
        editAppFinal = (EditText) findViewById(R.id.editAppFinal);

        labelFinalGrade.setVisibility(View.INVISIBLE);
        showFinalGrade.setVisibility(View.INVISIBLE);
    }

    public void clear(View view){
        labelFinalGrade.setVisibility(View.INVISIBLE);
        showFinalGrade.setVisibility(View.INVISIBLE);
        editPracticas.setText("");
        editAvance1.setText("");
        editAvance2.setText("");
        editAvance3.setText("");
        editAppFinal.setText("");
    }

    public void calculate(View view){
        String textPracticas = editPracticas.getText().toString();
        String textAvance1 = editAvance1.getText().toString();
        String textAvance2 = editAvance2.getText().toString();
        String textAvance3 = editAvance3.getText().toString();
        String textAppFinal = editAppFinal.getText().toString();

        if(!(textPracticas.equals(""))&&!(textAvance1.equals(""))&&!(textAvance2.equals(""))&&!(textAvance3.equals(""))&&!(textAppFinal.equals(""))) {
            double practicas = Double.parseDouble(textPracticas);
            double avance1 = Double.parseDouble(textAvance1);
            double avance2 = Double.parseDouble(textAvance2);
            double avance3 = Double.parseDouble(textAvance3);
            double appFinal = Double.parseDouble(textAppFinal);
            double finalGrade;
            if ((practicas<=5.0)&&(practicas>=0.0)&&(avance1<=5.0)&&(avance1>=0.0)&&(avance2<=5.0)&&(avance2>=0.0)&&(avance3<=5.0)&&(avance3>=0.0)&&(appFinal<=5.0)&&(appFinal>=0.0)) {
                finalGrade = (practicas * 0.6) + (avance1 * 0.05) + (avance2 * 0.07) + (avance3 * 0.08) + (appFinal * 0.2);
                showFinalGrade.setVisibility(View.VISIBLE);
                labelFinalGrade.setVisibility(View.VISIBLE);
                showFinalGrade.setText(Double.toString(finalGrade));
                if((finalGrade>=0)&&(finalGrade<=1)){
                    Toast.makeText(getApplicationContext(),"Estas en el lugar equivocado",Toast.LENGTH_SHORT).show();
                }

                else if((finalGrade>=1.1)&&(finalGrade<=2)){
                    Toast.makeText(getApplicationContext(),"Remal",Toast.LENGTH_SHORT).show();
                }
                else if((finalGrade>=2.1)&&(finalGrade<=3)){
                    Toast.makeText(getApplicationContext(),"Es posible recuperarse",Toast.LENGTH_SHORT).show();
                }
                else if((finalGrade>=3.1)&&(finalGrade<=4)){
                    Toast.makeText(getApplicationContext(),"Normalito",Toast.LENGTH_SHORT).show();
                }
                else if((finalGrade>=4.1)&&(finalGrade<=4.5)){
                    Toast.makeText(getApplicationContext(),"Muy bien",Toast.LENGTH_SHORT).show();
                }
                else if((finalGrade>=4.6)&&(finalGrade<=5)){
                    Toast.makeText(getApplicationContext(),"Excelente estudiante",Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(getApplicationContext(),"Las notas deben estar entre 0.0 y 5.0",Toast.LENGTH_SHORT).show();
            }

        }
    }
}

