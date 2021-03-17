package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity =2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private int calculateprice()
    {
        int price =quantity*5;
        return price;
    }
    private String createOrderSummary(int price,boolean addicecream,String name){
        String priceMessage="Name: "+name;
        priceMessage+="\nAdd Ice cream? "+addicecream;
        priceMessage=priceMessage+"\nQuantity: "+quantity;
        priceMessage= priceMessage+"\nPrice $"+price+"\nThankyou";
        return priceMessage;
    }
    /**
     * This method is called when the plus button is clicked.
     */
    public void increament(View view) {

        quantity=quantity+1;
        display(quantity);

    }
    /**
     * This method is called when the minus  button is clicked.
     */
    public void decreament(View view) {

        quantity =quantity - 1;
        display(quantity);

    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText text=(EditText) findViewById(R.id.TextPersonName);
        String value=text.getText().toString();
        Log.v("MainActivity","Name: " +value);
        CheckBox iceCreamCheckbox= (CheckBox) findViewById(R.id.ice_cream_checkBox);
        boolean hasIcecream= iceCreamCheckbox.isChecked();
        int price=calculateprice();
        String priceMessage=createOrderSummary(price,hasIcecream,value);
         displayMessage(priceMessage);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary__text_view);
        orderSummaryTextView.setText(message);
    }
}