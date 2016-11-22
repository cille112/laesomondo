package com.example.cille_000.laesomondo.startscreen;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.cille_000.laesomondo.R;
import com.example.cille_000.laesomondo.logic.StartLogic;
import com.example.cille_000.laesomondo.util.Validator;
import com.google.firebase.auth.FirebaseAuth;

public class CreateUserFragment extends Fragment implements View.OnClickListener {

    private ImageButton avatar;
    private EditText username, password, age;
    private TextView login;
    private AvatarFragment avatarFragment;
    private StartLogic logic;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_createuser, container, false);

        avatarFragment = new AvatarFragment();
        logic = new StartLogic();

        avatarFragment.setOnDoneListener(new AvatarFragment.OnDoneListener() {
            @Override
            public void onDone() {
                setAvatar(avatarFragment.getCurrent());
            }
        });

        avatar = (ImageButton) view.findViewById(R.id.createuser_picturebtn);
        username = (EditText) view.findViewById(R.id.createuser_name);
        password = (EditText) view.findViewById(R.id.createuser_password);
        age = (EditText) view.findViewById(R.id.createuser_age);
        login = (TextView) view.findViewById(R.id.createuser_login);

        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        avatar.setOnClickListener(this);
        login.setOnClickListener(this);

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(logic.checkUsername(s.toString())) {
                    Drawable icon = getResources().getDrawable(R.drawable.checkmark);
                    username.setError(null, icon);
                }
                else {
                    Drawable icon = getResources().getDrawable(R.drawable.errormark);
                    username.setError(null, icon);
                }
            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(logic.checkPassword(s.toString())) {
                    Drawable icon = getResources().getDrawable(R.drawable.checkmark);
                    password.setError(null, icon);
                }
                else {
                    Drawable icon = getResources().getDrawable(R.drawable.errormark);
                    password.setError(null, icon);
                }
            }
        });

        age.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(logic.checkAge(s.toString())) {
                    Drawable icon = getResources().getDrawable(R.drawable.checkmark);
                    age.setError(null, icon);
                }
                else {
                    Drawable icon = getResources().getDrawable(R.drawable.errormark);
                    age.setError(null, icon);
                }
            }
        });

        setAvatar(avatarFragment.getCurrent());


        return view;
    }

    public void setAvatar(int index) {
        avatar.setTag(index);
        avatar.setBackgroundResource(index);
    }

    @Override
    public void onClick(View v) {
        if(v == avatar) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.activity_start, avatarFragment );
            transaction.commit();
        }

        if(v == login) {
            ((CreateUserActivity)getActivity()).close();
        }
    }
}

