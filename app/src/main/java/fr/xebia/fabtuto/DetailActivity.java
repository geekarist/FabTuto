package fr.xebia.fabtuto;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String EXTRA_ITEM = "EXTRA_ITEM";

    public static void navigate(@NonNull Context context, @NonNull String text) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_ITEM, text);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        TextView detailTextView = findViewById(R.id.detail_title);
        String title = getTitleExtra();
        detailTextView.setText(title);

        ActionBar supportActionBar = getSupportActionBar();
        assert supportActionBar != null;
        supportActionBar.setDisplayHomeAsUpEnabled(true);
    }

    @NonNull
    private String getTitleExtra() {
        return getIntent().getStringExtra(EXTRA_ITEM);
    }
}
