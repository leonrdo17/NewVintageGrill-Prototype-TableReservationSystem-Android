package com.leonardo.tableappreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Nullable;

public class Reservation extends AppCompatActivity {

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    TextView tableNumberText;
    MaterialSpinner timeSpinner, sizeSpinner;

    Button
            createOrderButton;

    String time;
    String size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        final String selectedTable = getIntent().getStringExtra("tableNumber");


        tableNumberText = findViewById(R.id.tableNumberText);
        timeSpinner = findViewById(R.id.timeSpinner);
        sizeSpinner = findViewById(R.id.sizeSpinner);
        createOrderButton = findViewById(R.id.createOrderButton);

        timeSpinner.setItems("10.00 AM","11.00 AM","12.00 PM",
                "01.00 PM","02.00 PM","03.00 PM","04.00 PM","05.00 PM",
                "06.00 PM","07.00 PM","08.00 PM","09.00 PM");

        sizeSpinner.setItems("One Person", "Two Person", "Three Person",
                "Four Person","Five Person","Six Person");

        timeSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                switch (position) {
                    case 0:
                        time = "10.00 AM";

                        return;
                    case 1:
                        time = "11.00 AM";

                        return;
                    case 2:
                        time = "12.00 PM";

                        return;
                    case 3:
                        time = "01.00 PM";

                        return;
                    case 4:
                        time = "02.00 PM";

                        return;
                    case 5:
                        time = "03.00 PM";

                        return;
                    case 6:
                        time = "04.00 PM";

                        return;
                    case 7:
                        time = "05.00 PM";

                        return;
                    case 8:
                        time = "06.00 PM";

                        return;
                    case 9:
                        time = "07.00 PM";

                        return;
                    case 10:
                        time = "08.00 PM";

                        return;
                    case 11:
                        time = "09.00 PM";

                        return;
                }

            }
        });

        sizeSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                switch (position) {
                    case 0:
                        size = "One Person";

                        return;
                    case 1:
                        size = "Two Person";

                        return;
                    case 2:
                        size = "Three Person";

                        return;
                    case 3:
                        size = "Four Person";

                        return;
                    case 4:
                        size = "Five Person";

                        return;
                    case 5:
                        size = "Six Person";

                        return;

                }
            }
        });

        tableNumberText.setText("You are on table number: " + selectedTable);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        final String[] fullName = new String[1];
        final String[] email = new String[1];
        final String[] phoneNumber = new String[1];

        final String userID = fAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                fullName[0] = documentSnapshot.getString("fullName");
                email[0] = documentSnapshot.getString("email");
                phoneNumber[0] = documentSnapshot.getString("phone");

            }
        });

        createOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String menuOrder = "Reserve Only";
                String orderStatus = "On Progress";


                if(email[0] == null){
                    Toast.makeText(Reservation.this, "Create order failed! Email not found", Toast.LENGTH_SHORT).show();
                }

                if(fullName[0] == null){
                    Toast.makeText(Reservation.this, "Create order failed! Full name not found", Toast.LENGTH_SHORT).show();
                }

                if(phoneNumber[0] == null){
                    Toast.makeText(Reservation.this, "Create order failed! Phone number not found", Toast.LENGTH_SHORT).show();
                }

                if(time == null){
                    Toast.makeText(Reservation.this, "Create order failed! Order time not found", Toast.LENGTH_SHORT).show();
                }

                if(size == null){
                    Toast.makeText(Reservation.this, "Create order failed! Order party size not found", Toast.LENGTH_SHORT).show();
                }

                if(selectedTable == null){
                    Toast.makeText(Reservation.this, "Create order failed! Table not found", Toast.LENGTH_SHORT).show();
                }

                if(orderStatus == null){
                    Toast.makeText(Reservation.this, "Create order failed! Status not found", Toast.LENGTH_SHORT).show();
                }

                if(menuOrder == null){
                    Toast.makeText(Reservation.this, "Create order failed! Menu order not found", Toast.LENGTH_SHORT).show();
                }


                String orderID = UUID.randomUUID().toString();

                DocumentReference documentReference1 = fStore.collection("orders").document(orderID);
                Map<String, Object> order = new HashMap<>();
                order.put("fullName",fullName[0]);
                order.put("email",email[0]);
                order.put("phone",phoneNumber[0]);
                order.put("tableNumber",selectedTable);
                order.put("orderTime",time);
                order.put("partySize",size);
                order.put("menuOrder",menuOrder);
                order.put("orderStatus",orderStatus);
                order.put("orderID", orderID);

                documentReference1.set(order).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Reservation.this, "Order has been created!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                });

            }
        });

    }

}
