package com.example.lehoa_2210_baitapngay2110;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText editHoTen, editMaSinhVien, editNgaySinh;
    Button btnRegister;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_HO_TEN = "ho_ten";
    private static final String KEY_MA_SINH_VIEN = "ma_sinh_vien";
    private static final String KEY_NGAY_SINH = "ngay_sinh";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editHoTen = findViewById(R.id.editHoTen);
        editMaSinhVien = findViewById(R.id.editMaSinhVien);
        editNgaySinh = findViewById(R.id.editNgaySinh);
        btnRegister = findViewById(R.id.btnRegister);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoTen = editHoTen.getText().toString();
                String maSinhVien = editMaSinhVien.getText().toString();
                String ngaySinh = editNgaySinh.getText().toString();

                if (hoTen.isEmpty() || maSinhVien.isEmpty() || ngaySinh.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    // Lưu thông tin vào SharedPreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_HO_TEN, hoTen);
                    editor.putString(KEY_MA_SINH_VIEN, maSinhVien);
                    editor.putString(KEY_NGAY_SINH, ngaySinh);
                    editor.apply();

                    Toast.makeText(RegisterActivity.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();

                    // Chuyển hướng sang UserInfoActivity
                    Intent intent = new Intent(RegisterActivity.this, UserInfoActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
