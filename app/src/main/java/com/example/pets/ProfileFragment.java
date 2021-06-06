package com.example.pets;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
    @Nullable

    TextView username,mainpetname,mainusername,petname,ownername,email,password,logoutbtn,breed;
    String usernameFromDB,passwordFromDB,petnameFromDB,ownernameFromDB,emailFromDB,breedFromDB;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_profile,container,false);
        username = v.findViewById(R.id.username);
        mainpetname = v.findViewById(R.id.mainpetname);
        mainusername = v.findViewById(R.id.mainusername);
        petname = v.findViewById(R.id.petname);
        ownername = v.findViewById(R.id.ownername);
        email = v.findViewById(R.id.ownermail);
        password = v.findViewById(R.id.password);
        logoutbtn = v.findViewById(R.id.logoutbtn);
        breed = v.findViewById(R.id.breed);

        usernameFromDB = getArguments().getString("username");
        passwordFromDB = getArguments().getString("password");
        emailFromDB = getArguments().getString("email");
        ownernameFromDB = getArguments().getString("ownername");
        petnameFromDB = getArguments().getString("petname");
        breedFromDB = getArguments().getString("breed");

        showUserDetails();
        return  v;
    }

    private void showUserDetails() {

        mainpetname.setText(petnameFromDB);
        mainusername.setText(usernameFromDB);
        petname.setText(petnameFromDB);
        ownername.setText(ownernameFromDB);
        email.setText(emailFromDB);
        password.setText(passwordFromDB);
        breed.setText(breedFromDB);
        username.setText(usernameFromDB);


    }

    private void backtologin(){
        Intent intent = new Intent(getActivity(),MainActivity.class);
        startActivity(intent);
    }


}
