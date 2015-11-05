package com.plusonetesting.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Switch swPlayer = (Switch) findViewById(R.id.swPlayer);
        final TextView txtResult = (TextView) findViewById(R.id.txtResult);
        final Spinner spnrAttack = (Spinner) findViewById(R.id.spnrAttack);
        Button btnPlay = (Button) findViewById(R.id.btnPlay);
        final TextView txtP1Attack = (TextView) findViewById(R.id.txtP1Attack);
        final TextView txtP2Attack = (TextView) findViewById(R.id.txtP2Attack);


        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.attacks_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnrAttack.setAdapter(adapter);
        spnrAttack.setSelection(2,true);

        if (swPlayer.isChecked()) {
            txtResult.setText("Checked");
        }
        else {
            txtResult.setText(spnrAttack.getSelectedItem().toString());
        }

        swPlayer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    spnrAttack.setEnabled(false);
                } else {
                    spnrAttack.setEnabled(true);
                }
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (swPlayer.isChecked()) {
                    txtP1Attack.setText(adapter.getItem((int) (Math.random() * adapter.getCount())));
                } else {
                    txtP1Attack.setText(spnrAttack.getSelectedItem().toString());
                }
                txtP2Attack.setText(adapter.getItem((int) (Math.random() * adapter.getCount())));

//                switch ((String) txtP1Attack.getText()){
//                    case "Rock":
//
//                        break;
//
//                    case "Paper":
//                        break;
//
//                    case "Scissors":
//                        break;
//                    default:
//                        break;
//                }
            }
        });

    }
}
