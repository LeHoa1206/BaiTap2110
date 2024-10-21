package com.example.lehoa_2210_baitapngay2110;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class UserInfoActivity extends AppCompatActivity {

    private TextView txtHoTen, txtMaSinhVien, txtNgaySinh;
    private Button btnLogout;
    private SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_HO_TEN = "ho_ten";
    private static final String KEY_MA_SINH_VIEN = "ma_sinh_vien";
    private static final String KEY_NGAY_SINH = "ngay_sinh";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        initializeViews();
        loadUserInfo();
        setupLogoutButton();
    }

    private void initializeViews() {
        txtHoTen = findViewById(R.id.txtHoTen);
        txtMaSinhVien = findViewById(R.id.txtMaSinhVien);
        txtNgaySinh = findViewById(R.id.txtNgaySinh);
        btnLogout = findViewById(R.id.btnLogout);
    }

    private void loadUserInfo() {
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        String hoTen = sharedPreferences.getString(KEY_HO_TEN, "N/A");
        String maSinhVien = sharedPreferences.getString(KEY_MA_SINH_VIEN, "N/A");
        String ngaySinh = sharedPreferences.getString(KEY_NGAY_SINH, "N/A");

        txtHoTen.setText("Họ tên: " + hoTen);
        txtMaSinhVien.setText("Mã sinh viên: " + maSinhVien);
        txtNgaySinh.setText("Ngày sinh: " + ngaySinh);
    }

    private void setupLogoutButton() {
        btnLogout.setOnClickListener(v -> {
            clearUserData();
            navigateToRegisterActivity();
        });
    }

    private void clearUserData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    private void navigateToRegisterActivity() {
        Intent intent = new Intent(UserInfoActivity.this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }
}
