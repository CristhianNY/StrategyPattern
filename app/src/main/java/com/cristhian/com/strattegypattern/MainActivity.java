package com.cristhian.com.strattegypattern;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public SinglePrice singlePrice = SinglePrice.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        singlePrice.setPrice(2.5f);

        Button actionCash = (Button) findViewById(R.id.action_cash);
        Button actionCard = (Button) findViewById(R.id.action_card);
        Button actionCupon = (Button) findViewById(R.id.action_cuoupun);

        actionCard.setOnClickListener(this);
        actionCash.setOnClickListener(this);
        actionCupon.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        Payment p;

        switch (v.getId()){

            case R.id.action_card:
                p = new Payment(new Card());
                break;
            case R.id.action_cuoupun:
                p = new Payment(new Card());
                break;
            case R.id.action_cash:

                default:
                    p = new Payment(new Cash());
                    break;
        }

        String finalPrice = new StringBuilder().append("Precio Final: ").append(p.employStrategy(singlePrice.getPrice())).append("$").toString();

        Toast.makeText(this,finalPrice,Toast.LENGTH_LONG).show();

    }
}
