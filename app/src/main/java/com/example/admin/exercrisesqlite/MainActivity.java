package com.example.admin.exercrisesqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

class TaiKhoan {
    String tenTK, matKhau, tenChuTK, diaChi, soDT;

    public String getTenTK() {
        return tenTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getTenChuTK() {
        return tenChuTK;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setTenChuTK(String tenChuTK) {
        this.tenChuTK = tenChuTK;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }
}

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextTaiKhoan, editTextMatKhau, editTextNhapLaiMatKhau, editTextTenChuTaiKhoan, editTextDiaChi, editTextSoDienThoai;
    SQLiteDatabase db;
    Button buttonDangKy;
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextTaiKhoan = (EditText) findViewById(R.id.editTaiKhoan);
        editTextMatKhau = (EditText) findViewById(R.id.editMatKhau);
        editTextNhapLaiMatKhau = (EditText) findViewById(R.id.editNhapLaiMatKhau);
        editTextTenChuTaiKhoan = (EditText) findViewById(R.id.editTenChuTaiKhoan);
        editTextSoDienThoai = (EditText) findViewById(R.id.editSoDienThoai);
        buttonDangKy = (Button) findViewById(R.id.buttonDangKy);
        editTextDiaChi = (EditText) findViewById(R.id.editDiaChi);
        buttonDangKy.setOnClickListener(this);
        Context context = MainActivity.this;
        helper = new DatabaseHelper(context);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonDangKy:
                if (editTextMatKhau.getText().toString().equals(editTextNhapLaiMatKhau.getText().toString())) {
                    TaiKhoan kh = new TaiKhoan();
                    kh.setTenTK(editTextTaiKhoan.getText().toString());
                    kh.setMatKhau(editTextMatKhau.getText().toString());
                    kh.setTenChuTK(editTextTenChuTaiKhoan.getText().toString());
                    kh.setDiaChi(editTextDiaChi.getText().toString());
                    kh.setSoDT(editTextSoDienThoai.getText().toString());
                    helper.insertTK(kh);
                    Toast.makeText(getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getApplicationContext(), "Mật khẩu không khớp", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }
}
