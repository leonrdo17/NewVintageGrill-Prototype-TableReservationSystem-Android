package com.leonardo.tableappreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TableOptions extends AppCompatActivity {

    Button reservationOnlyButton, restaurantMenuButton;
    TextView tableNumberView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_options);
        final String selectedTable = getIntent().getStringExtra("tableNumber");


        reservationOnlyButton = findViewById(R.id.reservationOnlyButton);
        restaurantMenuButton = findViewById(R.id.restaurantMenuButton);

        tableNumberView = findViewById(R.id.tableNumberText);

        reservationOnlyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Reservation.class);
                intent.putExtra("tableNumber", selectedTable);
                startActivity(intent);

            }
        });

        restaurantMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RestaurantMenu.class);
                startActivity(intent);
            }
        });

        tableNumberView.setText("You are on table number: "+ selectedTable);
    }
}
