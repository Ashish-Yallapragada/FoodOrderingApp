package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends Fragment {
    DatabaseHelper db;
    EditText e1,e2;
    Button b3;
    View view;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_login, container, false);
        db=new DatabaseHelper(getActivity());
        e1=view.findViewById(R.id.email_2);
        e2=view.findViewById(R.id.pass_2);
        b3=view.findViewById(R.id.button_2);
        b3.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String email=e1.getText().toString();
                String password=e2.getText().toString();
                boolean chkepass=db.epass(email,password);
                if(chkepass){
                    Toast.makeText(getActivity(), "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getActivity(),Welcome_home.class);
                    startActivity(intent);

            }else
                {
                    Toast.makeText(getActivity(), "Incorrect id or password", Toast.LENGTH_SHORT).show();
                }
        }
        });

    return view;}


}
