package com.example.myproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MobileActivity extends AppCompatActivity {
    TextView tvTitle, tvDescription;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_properties);
        tvTitle = findViewById(R.id.text_view1);
        tvDescription = findViewById(R.id.text_view2);
        if (getIntent().getExtras() == null) return;

        Bundle bundle = getIntent().getExtras();
        String[] title = getResources().getStringArray(R.array.mobiles);
        String[] description = getResources().getStringArray(R.array.mobiles_description);

        for (String mobile : title) {
            if (mobile.matches(bundle.getString("title"))) {
                tvTitle.setText(mobile);
            }
        }

        for (int i = 0; i < description.length; i++) {
            if (i == bundle.getInt("description")) {
                tvDescription.setText(description[i]);
            }
        }

    }
}
