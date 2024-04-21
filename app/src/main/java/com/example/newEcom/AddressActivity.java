package com.example.newEcom;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newEcom.activities.PaymentActivity;

public class AddressActivity extends AppCompatActivity {
    EditText nameEditText, emailEditText, phoneEditText, addressEditText, commentEditText;
    Button checkoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        addressEditText = findViewById(R.id.addressEditText);
        commentEditText = findViewById(R.id.commentEditText);
        checkoutBtn = findViewById(R.id.checkoutBtn);

        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    // Proceed with order placement
                    placeOrder();
                }
            }
        });
    }

    private boolean validateInputs() {
        String name = nameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();
        String address = addressEditText.getText().toString().trim();

        if (name.isEmpty()) {
            nameEditText.setError("Name is required");
            return false;
        }

        if (email.isEmpty()) {
            emailEditText.setError("Email is required");
            return false;
        }

        if (phone.isEmpty()) {
            phoneEditText.setError("Phone number is required");
            return false;
        }

        if (address.isEmpty()) {
            addressEditText.setError("Address is required");
            return false;
        }

        // Additional validation logic can be added here for email format, phone number format, etc.

        return true;
    }

    private void placeOrder() {
        Intent intent = new Intent(AddressActivity.this, PaymentActivity.class);
        startActivity(intent);
        finish();
    }
}