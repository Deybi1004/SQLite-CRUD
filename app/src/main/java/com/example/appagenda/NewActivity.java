package com.example.appagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appagenda.db.DbContactos;

public class NewActivity extends AppCompatActivity {
    EditText txtNombre, txtTelefono, txtCorreo;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtCorreo = findViewById(R.id.txtCorreo);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbContactos dbContactos = new DbContactos(NewActivity.this);
                long id = dbContactos.insertarContactos(txtNombre.getText().toString(), txtTelefono.getText().toString(), txtCorreo.getText().toString());
                if (id > 0) {
                    Toast.makeText(NewActivity.this, "Se creo correctamente", Toast.LENGTH_SHORT).show();
                    limpiar();
                } else {
                    Toast.makeText(NewActivity.this, "Error al guardar registro", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void limpiar() {
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
    }
}