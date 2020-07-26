package com.example.goldenstatewarrior.ui.slideshow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.goldenstatewarrior.LoginAdmin;
import com.example.goldenstatewarrior.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class SlideshowFragment extends Fragment {
EditText mEmail, mPassword;
Button LoginButton;
FirebaseAuth fAuth;
Activity context;

 //   @Override
   // public void onCreate(@Nullable Bundle savedInstanceState) {

      //  super.onCreate(savedInstanceState);

       // mEmail.findViewById(R.id.email);
       // mPassword.findViewById(R.id.password);
       // fAuth = FirebaseAuth.getInstance();
       // LoginButton.findViewById(R.id.button_signin);


       // LoginButton.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
               // String Email = mEmail.getText().toString().trim();
                //String Password = mPassword.getText().toString().trim();
//
   //             if (TextUtils.isEmpty(Email)){
      //              mEmail.setError("Email is required");
         //           return;
            //    }
               // if(TextUtils.isEmpty(Password)){
                  //  mPassword.setError("Password is required");
                    //return;
                //}

               // fAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                  //  @Override
                   // public void onComplete(@NonNull Task<AuthResult> task) {
                      //  if (task.isSuccessful()) {
                         //   Toast.makeText(getActivity(), "Logged in Successfully", Toast.LENGTH_SHORT).show();
                            //startActivity(new Intent(context.getApplicationContext(),com.example.goldenstatewarrior.LoginAdmin.class));
                       // }else {
                          //  Toast.makeText(getActivity(), "Error!"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                       // }

                    //}
               // });
          //  }
       // });

   // }//


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_slideshow,container,false);
mEmail = view.findViewById(R.id.email);
mPassword = view.findViewById(R.id.password);
fAuth = FirebaseAuth.getInstance();
LoginButton = view.findViewById(R.id.button_signin);

LoginButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String Password = mPassword.getText().toString().trim();
        String Email = mEmail.getText().toString().trim();
        if(TextUtils.isEmpty(Email)){
            mEmail.setError("Email is required");
            return;
        }
        if(TextUtils.isEmpty(Password)){
            mPassword.setError("Password is required");
            return;
        }
        fAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getActivity(),"Logged in Successfully",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getContext(),
                            com.example.goldenstatewarrior.LoginAdmin.class));
                getActivity().finish();

                }else{
                    Toast.makeText(getActivity(), "Error!"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
});

       return view;
    }
}
