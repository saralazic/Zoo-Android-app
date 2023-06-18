package com.example.pandicazoovrt.tickets;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pandicazoovrt.AboutActivity;
import com.example.pandicazoovrt.AccountActivity;
import com.example.pandicazoovrt.constants.Errors;
import com.example.pandicazoovrt.animals.AnimalsActivity;
import com.example.pandicazoovrt.EventsActivity;
import com.example.pandicazoovrt.NotificationsActivity;
import com.example.pandicazoovrt.constants.Prices;
import com.example.pandicazoovrt.constants.PromoCodes;
import com.example.pandicazoovrt.R;
import com.example.pandicazoovrt.utils;

public class AdultsTicketsActivity extends AppCompatActivity {

    private int price = 0;
    private String message;
    private NumberPicker picker1, picker2, picker3, picker4;
    private int cnt1 =0, cnt2 = 0, cnt3 = 0, cnt4 = 0;
    private String code;

    private String promo_code = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets_adults);

        TextView priceText = findViewById(R.id.priceText);
        EditText promoCodeInput = findViewById(R.id.promocode);


        TextView linkTextView = findViewById(R.id.aboutLink);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle link click event here
                // For example, navigate to another activity/page in your app
                Intent intent = new Intent(AdultsTicketsActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

        ImageButton ticketsImgBtn = findViewById(R.id.ticketsIconButton);
        ticketsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdultsTicketsActivity.this, TicketsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton eventsImgBtn = findViewById(R.id.eventsIconButton);
        eventsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdultsTicketsActivity.this, EventsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton animalsImgBtn = findViewById(R.id.animalsIconButton);
        animalsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdultsTicketsActivity.this, AnimalsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton notificationsImgBtn = findViewById(R.id.notificationsIconButton);
        notificationsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdultsTicketsActivity.this, NotificationsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton accountImgBtn = findViewById(R.id.accountIconButton);
        accountImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdultsTicketsActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });

        picker1 = findViewById(R.id.numberpicker_1);
        picker1.setMaxValue(100);
        picker1.setMinValue(0);

        picker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                code = String.valueOf(promoCodeInput.getText());
                cnt1 = picker1.getValue();
                cnt2 = picker2.getValue();
                cnt3 = picker3.getValue();
                cnt4 = picker4.getValue();
                int price = calculatePrice(cnt1, cnt2, cnt3, cnt4, code);
                priceText.setText("Cena: "+ price);
            }
        });

        picker2 = findViewById(R.id.numberpicker_2);
        picker2.setMaxValue(100);
        picker2.setMinValue(0);

        picker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                code = String.valueOf(promoCodeInput.getText());
                cnt1 = picker1.getValue();
                cnt2 = picker2.getValue();
                cnt3 = picker3.getValue();
                cnt4 = picker4.getValue();
                int price = calculatePrice(cnt1, cnt2, cnt3, cnt4, code);
                priceText.setText("Cena: "+ price);
            }
        });

        picker3 = findViewById(R.id.numberpicker_3);
        picker3.setMaxValue(100);
        picker3.setMinValue(0);

        picker3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                code = String.valueOf(promoCodeInput.getText());
                cnt1 = picker1.getValue();
                cnt2 = picker2.getValue();
                cnt3 = picker3.getValue();
                cnt4 = picker4.getValue();
                int price = calculatePrice(cnt1, cnt2, cnt3, cnt4, code);
                priceText.setText("Cena: "+ price);
            }
        });

        picker4 = findViewById(R.id.numberpicker_4);
        picker4.setMaxValue(100);
        picker4.setMinValue(0);

        picker4.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                code = String.valueOf(promoCodeInput.getText());
                cnt1 = picker1.getValue();
                cnt2 = picker2.getValue();
                cnt3 = picker3.getValue();
                cnt4 = picker4.getValue();
                int price = calculatePrice(cnt1, cnt2, cnt3, cnt4, code);
                priceText.setText("Cena: "+ price);
            }
        });

        promoCodeInput.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE || event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                // Input is done, perform your desired actions here
                // This will be triggered when the user presses "Done" or "Enter" on the keyboard
                code = String.valueOf(promoCodeInput.getText());
                cnt1 = picker1.getValue();
                cnt2 = picker2.getValue();
                cnt3 = picker3.getValue();
                cnt4 = picker4.getValue();
                Log.d("AdultsTicketsActivity",""+code);
                int price = calculatePrice(cnt1, cnt2, cnt3, cnt4, code);
                priceText.setText("Cena: "+ price);
                return true;
            }
            return false;
        });


        Button confirmButton = findViewById(R.id.confirm_button);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code = String.valueOf(promoCodeInput.getText());
                cnt1 = picker1.getValue();
                cnt2 = picker2.getValue();
                cnt3 = picker3.getValue();
                cnt4 = picker4.getValue();
                int price = calculatePrice(cnt1, cnt2, cnt3, cnt4, code);
                priceText.setText("Zahtev je u obradi!");
            }
        });

    }

    protected int calculatePrice(int zoo, int aq, int feed, int full, String promo_code) {
        Log.d("AdultsTicketsActivity","calc "+code);
        if (utils.validNumberOfTickets(zoo, aq, feed, full)) {
          int priceFeed =
                        promo_code.equals(PromoCodes.free_feeding)
                        ? Prices.ADULT_ZOO
                        : Prices.ADULT_FEED;

          int priceFull =
                        promo_code.equals(PromoCodes.free_feeding)
                        ? Prices.ADULT_AQ
                        : Prices.ADULT_FULL;

          int [] discounted = utils.discount(zoo, aq, feed, full, promo_code);

          int sumZoo = discounted[0] * Prices.ADULT_ZOO;
          int sumAq = discounted[1] * Prices.ADULT_AQ;
          int sumFeed = discounted[2] * priceFeed;
          int sumFull = discounted[3] * priceFull;
          this.price = sumZoo + sumAq + +sumFeed + sumFull;
        } else {
            this.message = Errors.INVALID_TICKET_INPUT;
        }
        return this.price;
    }
}