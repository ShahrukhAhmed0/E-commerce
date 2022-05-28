package com.example.bakrapk.AdminLogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bakrapk.Dashbboard.Dashboard;
import com.example.bakrapk.Insertdata.Insertentry;
import com.example.bakrapk.R;
import com.example.bakrapk.admiinlogin.Model;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class AdminLogin extends AppCompatActivity {
EditText UserName,password;
TextView login;
ImageView bkk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        login=findViewById(R.id.l1);
        UserName=findViewById(R.id.e11);
        password=findViewById(R.id.e22);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isUser();
            }
        });

        bkk=findViewById(R.id.bkk);
        bkk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n =new Intent(AdminLogin.this,Dashboard.class);
                startActivity(n);
            }
        });

    }
    private Boolean validateUsername() {
        String val = UserName.getText().toString();
        if (val.isEmpty()) {
            UserName.setError(null);
            return false;
        }else {
            UserName.setError(null);
            return true;
        }
    }
    private Boolean validatePassword(){
        String val = password.getText().toString();
        if (val.isEmpty()) {
            password.setError("field can not be empty");
            return false;
        }else {
            UserName.setError(null);
            return true;
        }
    }
    public  void loginUser() {
        if (!validateUsername()|!validatePassword())
        {return;}
        else {isUser();}
    }
    private void isUser() {
        String userName1=UserName.getText().toString().trim();
        String password1=password.getText().toString().trim();
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Users");
        Query checluser= reference.orderByChild("userName1").equalTo(userName1);
        checluser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                {
                    String pasworddb=snapshot.child(userName1).child("password1").getValue(String.class);
                    if (pasworddb.equals(password1)){
                        Toast.makeText(AdminLogin.this, "login success", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(AdminLogin.this,Insertentry.class);
                        startActivity(intent);
                    }
                    else {
                        password.setError(" w p");
                    }
                }
                else {
                    UserName.setError("tt");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}