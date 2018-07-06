package com.example.erosa.puppy;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.erosa.puppy.javamail.GMailSender;

import org.w3c.dom.Text;

import javax.mail.AuthenticationFailedException;

public class ContactActivity extends AppCompatActivity {
    private TextView etCorreo, etNombre, etMensaje;
    private ProgressBar pbEnviando;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        etCorreo = findViewById(R.id.et_correo);
        etNombre = findViewById(R.id.et_nombre);
        etMensaje = findViewById(R.id.et_mensaje);
        pbEnviando = findViewById(R.id.pb_enviando);
        btnEnviar = findViewById(R.id.btn_enviar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("StaticFieldLeak")
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(etCorreo.getText()) && etCorreo.getText().toString().contains("@") && !TextUtils.isEmpty(etNombre.getText()) && !TextUtils.isEmpty(etMensaje.getText())){
                    pbEnviando.setVisibility(View.VISIBLE);
                    btnEnviar.setVisibility(View.GONE);
                    new AsyncTask<Void, Void, String>(){

                        @Override
                        protected String doInBackground(Void... voids) {
                            try {
                                GMailSender sender = new GMailSender(CredencialesCorreo.CORREO, CredencialesCorreo.CONTRASENIA);
                                sender.sendMail("Contacto Coursera",
                                        etNombre.getText().toString() + " dice: " + etMensaje.getText().toString(),
                                        "ervinlrosa@gmail.com",
                                        etCorreo.getText().toString());
                            }catch (AuthenticationFailedException authEx){
                                return getString(R.string.message_error);
                            } catch (Exception e) {
                                return e.getMessage();
                            }
                            return getString(R.string.message_success);
                        }

                        @Override
                        protected void onPostExecute(String s) {
                            super.onPostExecute(s);
                            pbEnviando.setVisibility(View.GONE);
                            btnEnviar.setVisibility(View.VISIBLE);
                            Toast.makeText(ContactActivity.this, s, Toast.LENGTH_SHORT).show();
                            if (s.equals(getString(R.string.message_success))){
                                etMensaje.setText("");
                                etCorreo.setText("");
                                etNombre.setText("");
                                etNombre.requestFocus();
                            }
                        }
                    }.execute();
                } else {
                    Toast.makeText(ContactActivity.this, R.string.error_datos_correo, Toast.LENGTH_SHORT).show();
                }


            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
