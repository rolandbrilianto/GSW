package com.example.goldenstatewarrior;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class LoginAdmin extends AppCompatActivity {
    Button logout, add, update, delete;
    EditText id, versus, tanggal, time, finalscore;
    FirebaseDatabase FD;
    DatabaseReference reference;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_page);
        fAuth=FirebaseAuth.getInstance();
        logout = findViewById(R.id.Logout_button);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
              Intent intent = new Intent(LoginAdmin.this, MainActivity.class);
              intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });
        id = findViewById(R.id.ID);
       versus = findViewById(R.id.VERSUS);
        tanggal = findViewById(R.id.TANGGAL);
        time = findViewById(R.id.TIME);
        finalscore = findViewById(R.id.FINALSCORE);
       add = findViewById(R.id.button_add);

       add.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FD = FirebaseDatabase.getInstance();
                reference = FD.getReference("users");
                String Id = id.getText().toString();
                String Versus = versus.getText().toString();
               String Tanggal = tanggal.getText().toString();
               String Time = time.getText().toString();
               String FinalScore = finalscore.getText().toString();

               if(TextUtils.isEmpty(Id)){
                   id.setError("Id is required");
                   return;
               }
               if(TextUtils.isEmpty(Versus)){
                   versus.setError("Versus is required");
                   return;
               }
               if(TextUtils.isEmpty(Tanggal)){
                   tanggal.setError("Tanggal is required");
                   return;
               }
               if(TextUtils.isEmpty(Time)){
                   time.setError("Time is required");
                   return;
               }
               if(TextUtils.isEmpty(FinalScore)){
                   finalscore.setError("Final Score is required");
                   return;
               }
                UserHelperClass helperClass = new UserHelperClass(Id,Versus,Tanggal,Time,FinalScore);

                reference.child(Id).setValue(helperClass);
               Toast.makeText(LoginAdmin.this, "Succcess", Toast.LENGTH_SHORT).show();
                id.setText("");
                versus.setText("");
                tanggal.setText("");
                time.setText("");
                finalscore.setText("");


           }
       });
        update = findViewById(R.id.button_update);
       update.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String Id = id.getText().toString();
               String Versus = versus.getText().toString();
               String Tanggal = tanggal.getText().toString();
               String Time = time.getText().toString();
               String FinalScore = finalscore.getText().toString();
               if(TextUtils.isEmpty(Id)){
                   id.setError("Id is required");
                   return;
               }
               if(TextUtils.isEmpty(Versus)){
                   versus.setError("Versus is required");
                   return;
               }
               if(TextUtils.isEmpty(Tanggal)){
                   tanggal.setError("Tanggal is required");
                   return;
               }
               if(TextUtils.isEmpty(Time)){
                   time.setError("Time is required");
                   return;
               }
               if(TextUtils.isEmpty(FinalScore)){
                   finalscore.setError("Final Score is required");
                   return;
               }

               FD = FirebaseDatabase.getInstance();
               reference = FD.getReference("users");

               HashMap hashMap = new HashMap();
               hashMap.put("id",Id);
               hashMap.put("versus",Versus);
               hashMap.put("tanggal",Tanggal);
               hashMap.put("time",Time);
               hashMap.put("finalScore",FinalScore);

               reference.child(Id).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                   @Override
                   public void onSuccess(Object o) {
                       Toast.makeText(LoginAdmin.this, "Data Successfully Updated", Toast.LENGTH_SHORT).show();
                       id.setText("");
                       versus.setText("");
                       tanggal.setText("");
                       time.setText("");
                       finalscore.setText("");
                   }
               });
           }
       });

       delete=findViewById(R.id.button_delete);
       delete.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String Id = id.getText().toString();
               if(TextUtils.isEmpty(Id)){
                   id.setError("Id is required");
                   return;
               }

              delete(Id);
           }
       });
    }
public void delete(String Id){
        DatabaseReference DR = FirebaseDatabase.getInstance().getReference("users").child(Id);
        DR.removeValue();
    Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
    id.setText("");
}
}
