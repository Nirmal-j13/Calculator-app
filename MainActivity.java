package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
    private TextView previousCalculation;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        previousCalculation = findViewById(R.id.previousCalculationView);
        display = findViewById(R.id.displayEdittext);

        display.setShowSoftInputOnFocus(false);
    }

    private void updateText(String strToAdd) {
        String oldstr = display.getText().toString();

        int cursorpos = display.getSelectionStart();
        String leftstr = oldstr.substring(0, cursorpos);
        String rightstr = oldstr.substring(cursorpos);

        display.setText(String.format("%s%s%s", leftstr, strToAdd, rightstr));
        display.setSelection(cursorpos + strToAdd.length());
    }

    public void zeroBTNPush(View view) {
        updateText(getResources().getString(R.string.zeroText));
    }

    public void oneBTNPush(View view) {
        updateText(getResources().getString(R.string.oneText));
    }

    public void twoBTNPush(View view) {
        updateText(getResources().getString(R.string.twoText));
    }

    public void threeBTNPush(View view) {
        updateText(getResources().getString(R.string.threeText));
    }

    public void fourBTNPush(View view) {
        updateText(getResources().getString(R.string.fourText));
    }

    public void fiveBTNPush(View view) {
        updateText(getResources().getString(R.string.fiveText));
    }

    public void sixBTNPush(View view) {
        updateText(getResources().getString(R.string.sixText));
    }

    public void sevenBTNPush(View view) {
        updateText(getResources().getString(R.string.sevenText));
    }

    public void eightBTNPush(View view) {
        updateText(getResources().getString(R.string.eightText));
    }

    public void nineBTNPush(View view) {
        updateText(getResources().getString(R.string.nineText));
    }

    public void openparenthesesBTNPush(View view) {
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }

    public void closepararentheseBTNPush(View view) {
        updateText(getResources().getString(R.string.parenthesesCloseText));
    }

    public void decimalBTNPush(View view) {
        updateText(getResources().getString(R.string.decimal));
    }

    public void clearBTNPush(View view)
    {
        display.setText("");
        previousCalculation.setText("");
    }

    public void equalBTNPush(View view) {
        String userExp = display.getText().toString();

        previousCalculation.setText(userExp);
        userExp = userExp.replaceAll(getResources().getString(R.string.divideText), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyText), "*");
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());
    }

    public void backspaceBTNPush(View view) {
        int cursorPos = display.getSelectionStart();
        int textlen = display.getText().length();

        if (cursorPos != 0 && textlen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }

    public void addBTNPush(View view) {
        updateText(getResources().getString(R.string.addText));
    }

    public void subBTNPush(View view) {
        updateText(getResources().getString(R.string.subtractText));
    }

    public void multiplyBTNPush(View view) {
        updateText(getResources().getString(R.string.multiplyText));
    }

    public void divideBTNPush(View view) {
        updateText(getResources().getString(R.string.divideText));
    }

    public void sinBTNPush(View view)
    {
      updateText("sin(");
    }

    public void cosBTNPush(View view)
    {
      updateText("cos(");
    }

    public void tanBTNPush(View view)
    {
     updateText("tan(");
    }

    public void sininverseBTNPush(View view)
    {
      updateText("arcsin(");
    }
    public void cosinverseBTBPush(View view)
    {
       updateText("arccos(");
    }
    public void taninverseBTNPush(View view)
    {
      updateText("arctan(");
    }
    public void naturallogBTNPush(View view)
    {
      updateText("ln");
    }
    public void logBTNPush(View view)
    {
      updateText("log(");
    }
    public void squarerootBTNPush(View view)
    {
      updateText("sqrt(");
    }
    public void absoluteBTNPush(View view)
    {
     updateText("abs(");
    }
    public void piBTNPush(View view)
    {
     updateText("pi(");
    }
    public void eBTNPush(View view)
    {
     updateText("e");
    }
    public void xsquareBTNPush(View view)
    {
        updateText("^(2)");
    }
    public void xsquarepoweryBTNPush(View view)
    {
        updateText("^(");
    }
    public void isprimeBTNPush(View view)
    {
       updateText("ispr(");
    }
}