package br.edu.ifsc.garopaba.jokenpoh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int jogadaPc() {
        int n = new Random().nextInt(3) + 1;
        ImageView padrao = findViewById(R.id.padrao);
        switch (n) {
            case 1:
                padrao.setImageResource(R.drawable.pedra);
                break;
            case 2:
                padrao.setImageResource(R.drawable.papel);
                break;
            case 3:
                padrao.setImageResource(R.drawable.tesoura);
                break;
        }
        return n;
    }

    public void verificar(int jogadaUser, int jogadaPc) {
        TextView result = findViewById(R.id.result);
        if (jogadaUser == jogadaPc) {
            Toast.makeText(this, "Empate!", Toast.LENGTH_SHORT).show();
            result.setText("Empate!");
        } else if ((jogadaUser == 1 && jogadaPc == 3) || (jogadaUser == 2 && jogadaPc == 1) || (jogadaUser == 3 && jogadaPc == 2)) {
            Toast.makeText(this, "Você ganhou!", Toast.LENGTH_SHORT).show();
            result.setText("Você ganhou!");
        } else {
            Toast.makeText(this, "Computador ganhou!", Toast.LENGTH_SHORT).show();
            result.setText("Computador ganhou!");
        }
    }

    public void jogar(View view) {
        String jogada = getResources().getResourceEntryName(view.getId());
        int jogadaUser = 0;
        int jogadaPc = jogadaPc();

        switch (jogada) {
            case "pedra":
                jogadaUser = 1;
                Toast.makeText(this, "Você jogou pedra", Toast.LENGTH_SHORT).show();
                break;
            case "papel":
                jogadaUser = 2;
                Toast.makeText(this, "Você jogou papel", Toast.LENGTH_SHORT).show();
                break;
            case "tesoura":
                jogadaUser = 3;
                Toast.makeText(this, "Você jogou tesoura", Toast.LENGTH_SHORT).show();
                break;
        }

        verificar(jogadaUser, jogadaPc);
    }
}
