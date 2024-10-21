package com.example.lehoa_2210_baitapngay2110;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_HO_TEN = "ho_ten";
    private static final String KEY_MA_SINH_VIEN = "ma_sinh_vien";
    private static final String KEY_NGAY_SINH = "ngay_sinh";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Kiểm tra trạng thái đã đăng ký
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        String hoTen = sharedPreferences.getString(KEY_HO_TEN, null);
        String maSinhVien = sharedPreferences.getString(KEY_MA_SINH_VIEN, null);
        String ngaySinh = sharedPreferences.getString(KEY_NGAY_SINH, null);

        if (hoTen != null && maSinhVien != null && ngaySinh != null) {
            // Chuyển hướng đến UserInfoActivity nếu đã đăng ký
            Toast.makeText(MainActivity.this, "Chào mừng trở lại!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, UserInfoActivity.class);
            startActivity(intent);
            finish();
        } else {
            // Chuyển hướng đến RegisterActivity nếu chưa đăng ký
            Toast.makeText(MainActivity.this, "Vui lòng đăng ký tài khoản!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
