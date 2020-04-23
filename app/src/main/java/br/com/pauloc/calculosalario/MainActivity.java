package br.com.pauloc.calculosalario;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ViewUtils;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ViewHolder mVHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edt_vlSal = findViewById(R.id.edt_vlSal);
        RadioButton rd40 = findViewById(R.id.rb_40);
        final RadioButton rd45 = findViewById(R.id.rb_45);
        RadioButton rd50 = findViewById(R.id.rb_50);
        final RadioGroup rgroup = findViewById(R.id.rgroup);
        Button btn_calcular = findViewById(R.id.btn_calcular);
        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double salario = Double.parseDouble(edt_vlSal.getText().toString());
                int op = rgroup.getCheckedRadioButtonId();

                if (salario < 1100){
                    rgroup.check(R.id.rb_40);
                    salario += (salario * 0.40);
                } else if(salario >= 1100 && salario < 1500){
                    rgroup.check(R.id.rb_45);
                    salario += (salario * 0.45);
                }else {
                    rgroup.check(R.id.rb_50);
                    salario += (salario * 0.50);
                }

/*
                if (op == R.id.rb_40){
                    salario = salario + (salario * 0.40);
                } else if (op == R.id.rb_45){
                    salario = salario + (salario * 0.45);
                }else{
                    salario = salario + (salario * 0.50);
                }
*/

                AlertDialog.Builder msgSalario = new AlertDialog.Builder(MainActivity.this);
                msgSalario.setTitle("Novo salaário");
                msgSalario.setMessage("Seu salário reajustado é R$" + salario);
                msgSalario.setNeutralButton("Ciente!", null);
                msgSalario.show();
            }
            });

    }

    public void OnClick(View view){

        double salario = Double.parseDouble(this.mVHolder.edt_vlSal.getText().toString());
        int op = this.mVHolder.rgroup.getCheckedRadioButtonId();

        if (op == R.id.rb_40){
            salario = salario + (salario * 0.40);
        } if(op == R.id.rb_45){
            salario = salario + (salario * 0.45);
        } if(op == R.id.rb_50) {
            salario = salario + (salario * 0.50);
        }
    }

    private static class ViewHolder{
        Button btn_calcular;
        RadioButton rd40, rd45, rd50;
        EditText edt_vlSal;
        RadioGroup rgroup;
        TextView text_novosalario;
    }
}
