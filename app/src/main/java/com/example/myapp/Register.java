package com.example.myapp;



import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Register extends Fragment {
EditText e1,e2,e3;
Button b1;
View view;
DatabaseHelper db;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_register, container, false);
        e1=view.findViewById(R.id.email_1);
        e2=view.findViewById(R.id.pass_1);
        e3=view.findViewById(R.id.cpass_1);
        b1=view.findViewById(R.id.button_1);
        db=new DatabaseHelper(getActivity());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1,s2,s3;
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals("")){
                    Toast.makeText(getActivity(), "Fields are Empty", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    if(s2.equals(s3))
                    {
                        boolean chkmail=db.chkmail(s1);
                        if(chkmail){
                            boolean insert=db.insert(s1,s2);
                            if(insert){
                                Toast.makeText(getActivity(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getActivity(), "Email already exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(getActivity(), "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return view;
    }


    }



