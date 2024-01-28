package com.example.android2_lab.fragment;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android2_lab.R;
import com.example.android2_lab.database.DbHelper;


public class Home extends Fragment {
    private Button add;

    private EditText name, address, phone;

    DbHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //buttons
        add = view.findViewById(R.id.add);

        //editTexts
        name = view.findViewById(R.id.user_name);
        address = view.findViewById(R.id.user_address);
        phone = view.findViewById(R.id.user_phone);

        dbHelper = new DbHelper(getActivity());

//        //button click
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty() || address.getText().toString().isEmpty() || phone.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Vui lý nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else {
                    //thêm dữ liệu
                    sqLiteDatabase = dbHelper.getWritableDatabase();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("name", name.getText().toString());
                    contentValues.put("address", address.getText().toString());
                    contentValues.put("phone", phone.getText().toString());

                    Long result = sqLiteDatabase.insert("userdb", null, contentValues);


                    if (result!=null) {
                        Toast.makeText(getActivity(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                        cleardata();
                    } else {
                        Toast.makeText(getActivity(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            private void cleardata() {
                name.setText("");
                address.setText("");
                phone.setText("");
            }
        });


        return view;
    }
}