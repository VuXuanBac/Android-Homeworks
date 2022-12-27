package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {

    Drawable defaultEditTextBackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSubmit = (Button)findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(this);

        CheckBox checkTermAgree = (CheckBox)findViewById(R.id.checkAgree);
        checkTermAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                buttonSubmit.setEnabled(b);
            }
        });

        defaultEditTextBackground = findViewById(R.id.editMSSV).getBackground();

        setOnFocusChangeListener(R.id.editMSSV);
        setOnFocusChangeListener(R.id.editName);
        setOnFocusChangeListener(R.id.editCCCD);
        setOnFocusChangeListener(R.id.editPhone);
        setOnFocusChangeListener(R.id.editEmail);

        DatePicker date = (DatePicker) findViewById(R.id.pickerBirthdate);
        date.init(2000, 0, 1, null);
    }

    private void setOnFocusChangeListener(int id){
        View view = findViewById(id);
        view.setOnFocusChangeListener(this);
    }

    private void applyHighlightBorder(View view){
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(Color.parseColor("#00FFFFFF"));
        gd.setStroke(4, Color.RED);
        view.setBackground(gd);
    }

    private boolean checkAndApplyHighlightBorderForEditText(int id){
        EditText ed = (EditText) findViewById(id);
        if(ed.length() == 0){
            applyHighlightBorder(ed);
            return false;
        }
        return true;
    }

    private void buttonSubmitClickAction(){
        View view = getCurrentFocus();
        if(view != null)
            view.clearFocus();
        boolean success = true;
        success &= checkAndApplyHighlightBorderForEditText(R.id.editMSSV);
        success &= checkAndApplyHighlightBorderForEditText(R.id.editName);
        success &= checkAndApplyHighlightBorderForEditText(R.id.editCCCD);
        success &= checkAndApplyHighlightBorderForEditText(R.id.editPhone);
        success &= checkAndApplyHighlightBorderForEditText(R.id.editEmail);
        if(success){
            Toast.makeText(this, "Thông tin của bạn được cập nhật thành công", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Bạn chưa nhập một số trường bắt buộc.", Toast.LENGTH_SHORT).show();
            ((CheckBox)findViewById(R.id.checkAgree)).setChecked(false);
        }
    }
    private void setDefaultBackground(View view){
        view.setBackground(defaultEditTextBackground);
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.buttonSubmit:
                buttonSubmitClickAction();
                break;
            default:
                return;
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        int id = view.getId();
        switch (id){
            case R.id.editMSSV:
            case R.id.editName:
            case R.id.editCCCD:
            case R.id.editPhone:
            case R.id.editEmail:
                setDefaultBackground(view);
                break;
            default:
                return;
        }
    }
}