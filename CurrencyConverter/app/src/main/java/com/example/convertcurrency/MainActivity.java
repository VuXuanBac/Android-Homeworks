package com.example.convertcurrency;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    final int CURRENCY_FROM_INDEX = 0;
    final int CURRENCY_TO_INDEX = 1;
    ArrayList<CurrencyInfo> currencyInfos;
    private Spinner spinnerCurrencyFrom;
    private Spinner spinnerCurrencyTo;
    private TextView textCurrencyFromSymbol;
    private TextView textCurrencyToSymbol;
    private TextView[] textValues;
    private TextView textRate;
    private int activateIndex;

    CurrencyInfo[] selected_currency;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeCurrencyInfos();

        populateViews();
        addOnClickListeners();

        CurrencySpinnerAdapter adapter = new CurrencySpinnerAdapter
                (this, R.layout.spinner_item_layout, currencyInfos);
        spinnerCurrencyFrom.setAdapter(adapter);
        spinnerCurrencyTo.setAdapter(adapter);

        spinnerCurrencyFrom.setOnItemSelectedListener(this);
        spinnerCurrencyTo.setOnItemSelectedListener(this);

        selected_currency = new CurrencyInfo[2];
        selected_currency[CURRENCY_FROM_INDEX] = currencyInfos.get(0);
        selected_currency[CURRENCY_TO_INDEX] = currencyInfos.get(1);

        spinnerCurrencyFrom.setSelection(0);
        spinnerCurrencyFrom.setSelection(1);

        activateIndex = CURRENCY_FROM_INDEX;
        textValues[activateIndex].setTypeface(null, Typeface.BOLD);
    }

    private void addOnClickListeners(){
        ((Button)findViewById(R.id.btn0)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn1)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn2)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn3)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn4)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn5)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn6)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn7)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn8)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn9)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnDot)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnClearEntry)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnBackSpace)).setOnClickListener(this);

        textValues[CURRENCY_FROM_INDEX].setOnClickListener(this);
        textValues[CURRENCY_TO_INDEX].setOnClickListener(this);
    }

    private void populateViews() {
        spinnerCurrencyFrom = findViewById(R.id.spinnerCurrencyFrom);
        spinnerCurrencyTo = findViewById(R.id.spinnerCurrencyTo);

        textCurrencyFromSymbol = findViewById(R.id.textCurrencyFromSymbol);
        textCurrencyToSymbol = findViewById(R.id.textCurrencyToSymbol);
        textValues = new TextView[2];
        textValues[0] = findViewById(R.id.textValueFrom);
        textValues[1] = findViewById(R.id.textValueTo);
        textRate = findViewById(R.id.textRate);
    }

    private void initializeCurrencyInfos() {
        currencyInfos = new ArrayList<CurrencyInfo>();
        currencyInfos.add(new CurrencyInfo("Dollar", "United States", "USD", "\uFF04", 1.0f));
        currencyInfos.add(new CurrencyInfo("Dong", "Vietnam", "VND", "\u20AB", 23192.0535f));
        currencyInfos.add(new CurrencyInfo("Kip", "Laos", "LAK", "\u20AD", 13982.3178f));
        currencyInfos.add(new CurrencyInfo("Riel", "Cambodia", "KHR", "\u17DB", 4068.9645f));
        currencyInfos.add(new CurrencyInfo("Baht", "Thailand", "THB", "\u0E3F", 34.293f));
        currencyInfos.add(new CurrencyInfo("Renminbi", "China", "CNY", "\u00A5", 6.6603f));
        currencyInfos.add(new CurrencyInfo("Yen", "Japan", "JPY", "\u00A5", 130.84f));
        currencyInfos.add(new CurrencyInfo("Won", "Korea", "KPW", "\uFFE6", 900.001f));
        currencyInfos.add(new CurrencyInfo("Ruble", "Russia", "RUB", "\u20BD", 63.3604f));
        currencyInfos.add(new CurrencyInfo("Euro", "France", "EUR", "\u20AC", 0.9328f));
        currencyInfos.add(new CurrencyInfo("Sterling", "United Kingdom", "GBP", "\u00A3", 0.8007f));
        currencyInfos.add(new CurrencyInfo("Dollar", "Australia", "AUD", "\uFF04", 1.3875f));
    }

    private void onNumberButtonClick(CharSequence chars){
        TextView current = textValues[activateIndex];
        if(current.length() == 1 && current.getText().charAt(0) == '0')
            current.setText(chars);
        else {
            current.append(chars);
        }
    }

    private void onDotButtonClick(){
        TextView current = textValues[activateIndex];
        if(current.length() == 0)
            current.append("0.");
        else if(current.getText().toString().indexOf(".") < 0) {
            current.append(".");
        }
    }

    private void onBackSpaceClick(){
        TextView current = textValues[activateIndex];
        int length = current.length();
        if(length > 1) {
            current.setText(current.getText().subSequence(0, length - 1));
        }
        else if(length == 1)
            current.setText("0");
    }

    private void onClearEntryClick(){
        textValues[activateIndex].setText("0");
        textValues[1-activateIndex].setText("0"); // update value
    }

    private void onTextViewValueClick(int index){
        activateIndex = index;
        textValues[index].setTypeface(null, Typeface.BOLD);
        textValues[1 - index].setTypeface(null, Typeface.NORMAL);
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.btnBackSpace:
                onBackSpaceClick();
                updateValue();
                break;
            case R.id.btnClearEntry:
                onClearEntryClick();
                break;
            case R.id.btn0:
            case R.id.btn1:
            case R.id.btn2:
            case R.id.btn3:
            case R.id.btn4:
            case R.id.btn5:
            case R.id.btn6:
            case R.id.btn7:
            case R.id.btn8:
            case R.id.btn9:
                onNumberButtonClick(((Button)view).getText());
                updateValue();
                break;
            case R.id.btnDot:
                onDotButtonClick();
                break;
            case R.id.textValueFrom:
                onTextViewValueClick(CURRENCY_FROM_INDEX);
                break;
            case R.id.textValueTo:
                onTextViewValueClick(CURRENCY_TO_INDEX);
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        CurrencyInfo item = currencyInfos.get(i);
        int id = adapterView.getId();
        if(id == R.id.spinnerCurrencyFrom){
            textCurrencyFromSymbol.setText(item.getSymbol());
            selected_currency[CURRENCY_FROM_INDEX] = item;
        }
        else if(id == R.id.spinnerCurrencyTo){
            textCurrencyToSymbol.setText(item.getSymbol());
            selected_currency[CURRENCY_TO_INDEX] = item;
        }
            updateRate();
            updateValue();

    }
    void updateRate() {
        float rate = selected_currency[CURRENCY_TO_INDEX].getWeight()
                / selected_currency[CURRENCY_FROM_INDEX].getWeight();
        String fromISO = selected_currency[CURRENCY_FROM_INDEX].getISOCode();
        String toISO = selected_currency[CURRENCY_TO_INDEX].getISOCode();
        textRate.setText("1 " + fromISO + " = " + rate + " " + toISO);
    }
    void updateValue(){
        float value = selected_currency[activateIndex].convertToCurrency(
                Float.parseFloat(textValues[activateIndex].getText().toString()),
                selected_currency[1-activateIndex]
        );
        String valuetext = value == 0f ? "0" : String.format("%.3f",value);
        textValues[1-activateIndex].setText(valuetext);
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}