package com.example.bakrapk.admiinlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bakrapk.Insertdata.Insertentry;
import com.example.bakrapk.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

public class adminsin extends AppCompatActivity {
    TextView userName1, password1;
    Button BTN;
    // String  userName,password;
    FirebaseDatabase db;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminsin);

        userName1 = findViewById(R.id.e1);
        password1 = findViewById(R.id.e2);
        BTN = findViewById(R.id.button);

        BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName = userName1.getText().toString();
                String password = password1.getText().toString();
                if (!userName.isEmpty() && !password.isEmpty()) {
                    Model users = new Model(userName, password);
                    db = FirebaseDatabase.getInstance();
                    reference = db.getReference("Users");

                    OnFailureListener failureListener = new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(adminsin.this, "Failed to register: " + e, Toast.LENGTH_LONG).show();
                        }
                    };

                    reference.child(userName).setValue(users).addOnFailureListener(failureListener).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            userName1.setText("");
                            password1.setText("");
                            Toast.makeText(adminsin.this, "Successfully Updated", Toast.LENGTH_SHORT).show();

                        }
                    });

                }}
        });


    }
}