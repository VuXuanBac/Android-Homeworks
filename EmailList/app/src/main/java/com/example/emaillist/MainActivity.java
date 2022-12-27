package com.example.emaillist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<EmailInfo> emailInfoList;
    ListView listEmail;
    DateFormat dateFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeEmailInfo();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        EmailListAdapter adapter = new EmailListAdapter(this, R.layout.list_item_layout, emailInfoList);
        listEmail = findViewById(R.id.listEmail);
        listEmail.setAdapter(adapter);

        SQLiteDatabase db;
        EditText e; e.get
        listEmail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                EmailInfo selected_item = emailInfoList.get(i);
                String text = String.format("Sender: %s\nTitle: %s\nContent: %s\nDate: %s\nFavorite: %s",
                        selected_item.getSender(),
                        selected_item.getTitle(),
                        selected_item.getContent(),
                        dateFormat.format(selected_item.getSendDate()),
                        Boolean.toString(selected_item.isStar()));
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                ImageView v;
                v.setOnClickListener();
            }
        });
    }

    void initializeEmailInfo(){
        emailInfoList = new ArrayList<EmailInfo>();
        emailInfoList.add(new EmailInfo("Vũ Xuân Bắc",
                "Hello ListView",
                "My first android program using ListView",
                new Date(2022-1900, 6, 12),
                true));
        emailInfoList.add(new EmailInfo("Gmail",
                "Verify email for payment",
                "Your account must be verified before activating payment",
                new Date(2022-1900, 1, 4),
                false));
        emailInfoList.add(new EmailInfo("Nhóm tài khoản Microsoft",
                "Thay đổi mật khẩu tài khoản Microsoft",
                "Tài khoản của bạn đã thay đổi\nMật khẩu cho tài khoản Microsoft ab********@gmail.com của bạn vừa mới được thay đổi\nBlah blah",
                new Date(2020-1900, 9, 9),
                false));
        emailInfoList.add(new EmailInfo("Microsoft account",
                "Verify your email address",
                "Verify your email address\nTo finish setting up your Microsoft account, we just need to make sure this email address is yours.\nTo verify your email address use this security code: 8760",
                new Date(2020-1900, 3, 1),
                true));
        emailInfoList.add(new EmailInfo("Hiến máu",
                "Thư cảm ơn",
                "Kính gửi Quý vị: Vũ Xuân Bắc\n Viện Huyết học-Truyền máu Trung ương trân trọng cảm ơn Quý vị đã tham gia hiến máu vào ngày 21 tháng 9 năm 2019.",
                new Date(2019-1900, 11, 12),
                true));
        emailInfoList.add(new EmailInfo("Cộng đồng",
                "Bắc, chào mừng bạn đến với Tài khoản Google mới",
                "Xin chào Bắc!\nCảm ơn bạn đã tạo Tài khoản Google\nDưới đây là một số lời khuyên để bạn bắt đầu với tài khoản Google của mình.",
                new Date(2019-1900, 8, 25),
                false));
        emailInfoList.add(new EmailInfo("Vũ Xuân Bắc",
                "Hello ListView",
                "My first android program using ListView",
                new Date(2022-1900, 6, 12),
                true));
        emailInfoList.add(new EmailInfo("Gmail",
                "Verify email for payment",
                "Your account must be verified before activating payment",
                new Date(2022-1900, 1, 4),
                false));
        emailInfoList.add(new EmailInfo("Nhóm tài khoản Microsoft",
                "Thay đổi mật khẩu tài khoản Microsoft",
                "Tài khoản của bạn đã thay đổi\nMật khẩu cho tài khoản Microsoft ab********@gmail.com của bạn vừa mới được thay đổi\nBlah blah",
                new Date(2020-1900, 9, 9),
                false));
        emailInfoList.add(new EmailInfo("Microsoft account",
                "Verify your email address",
                "Verify your email address\nTo finish setting up your Microsoft account, we just need to make sure this email address is yours.\nTo verify your email address use this security code: 8760",
                new Date(2020-1900, 3, 1),
                true));
        emailInfoList.add(new EmailInfo("Hiến máu",
                "Thư cảm ơn",
                "Kính gửi Quý vị: Vũ Xuân Bắc\n Viện Huyết học-Truyền máu Trung ương trân trọng cảm ơn Quý vị đã tham gia hiến máu vào ngày 21 tháng 9 năm 2019.",
                new Date(2019-1900, 11, 12),
                true));
        emailInfoList.add(new EmailInfo("Cộng đồng",
                "Bắc, chào mừng bạn đến với Tài khoản Google mới",
                "Xin chào Bắc!\nCảm ơn bạn đã tạo Tài khoản Google\nDưới đây là một số lời khuyên để bạn bắt đầu với tài khoản Google của mình.",
                new Date(2019-1900, 8, 25),
                false));
        emailInfoList.add(new EmailInfo("Vũ Xuân Bắc",
                "Hello ListView",
                "My first android program using ListView",
                new Date(2022-1900, 6, 12),
                true));
        emailInfoList.add(new EmailInfo("Gmail",
                "Verify email for payment",
                "Your account must be verified before activating payment",
                new Date(2022-1900, 1, 4),
                false));
        emailInfoList.add(new EmailInfo("Nhóm tài khoản Microsoft",
                "Thay đổi mật khẩu tài khoản Microsoft",
                "Tài khoản của bạn đã thay đổi\nMật khẩu cho tài khoản Microsoft ab********@gmail.com của bạn vừa mới được thay đổi\nBlah blah",
                new Date(2020-1900, 9, 9),
                false));
        emailInfoList.add(new EmailInfo("Microsoft account",
                "Verify your email address",
                "Verify your email address\nTo finish setting up your Microsoft account, we just need to make sure this email address is yours.\nTo verify your email address use this security code: 8760",
                new Date(2020-1900, 3, 1),
                true));
        emailInfoList.add(new EmailInfo("Hiến máu",
                "Thư cảm ơn",
                "Kính gửi Quý vị: Vũ Xuân Bắc\n Viện Huyết học-Truyền máu Trung ương trân trọng cảm ơn Quý vị đã tham gia hiến máu vào ngày 21 tháng 9 năm 2019.",
                new Date(2019-1900, 11, 12),
                true));
        emailInfoList.add(new EmailInfo("Cộng đồng",
                "Bắc, chào mừng bạn đến với Tài khoản Google mới",
                "Xin chào Bắc!\nCảm ơn bạn đã tạo Tài khoản Google\nDưới đây là một số lời khuyên để bạn bắt đầu với tài khoản Google của mình.",
                new Date(2019-1900, 8, 25),
                false));
    }
}