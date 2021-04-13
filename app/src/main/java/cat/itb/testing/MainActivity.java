package cat.itb.testing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button boton;
    TextView titulo;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = findViewById(R.id.button);
        titulo = findViewById(R.id.titulo);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boton.setText(R.string.button_back);
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });

        username = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);

    }
}