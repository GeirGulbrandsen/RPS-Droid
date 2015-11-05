package com.plusonetesting.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        spnrAttack.setSelection(2, true);

        final Player player1 = new Player();
        player1.setName("Player");
        final Player player2 = new Player();
        player2.setName("Skynet");


        swPlayer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    spnrAttack.setEnabled(false);
                    player1.setName("Android");
                } else {
                    spnrAttack.setEnabled(true);
                    player1.setName("Player");
                }
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (swPlayer.isChecked()) {
                    player1.setAttack((String) adapter.getItem((int) (Math.random() * adapter.getCount())));
                } else {
                    player1.setAttack(spnrAttack.getSelectedItem().toString());
                }
                player2.setAttack((String) adapter.getItem((int) (Math.random() * adapter.getCount())));

                txtP1Attack.setText(player1.getAttack());
                txtP2Attack.setText(player2.getAttack());
                txtResult.setText(evaluate(player1, player2));
            }
        });
    }

    public String evaluate(Player player1, Player player2) {
        String result;

        if (player1.getAttack().equals(player2.getAttack())) {
            result = "It's a tie.";
        } else {
            if (player1.getWinsOver().equals(player2.getAttack())) {
                result = player1.getName() + " wins!!";

            } else result = player2.getName() + " wins!!";
        }
        return result;

    }
}
