package com.example.user.travelhelper;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.util.List;

/**
 * Created by User on 4/8/2017.
 */

public class TheBestWayActivity extends AppCompatActivity {

    TinyTraveler mTinyTraveler;
    TextView mResultsTextView;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.the_best_way);

        mTinyTraveler = new TinyTraveler (TheBestWayActivity.this, "c119b8c5bcc89050ac05ae9c109c3bfe");


        final EditText originEditText = (EditText) findViewById(R.id.origin_edit_text);
        final EditText departDateEditText = (EditText) findViewById(R.id.depart_date_edit_text);
        final EditText returnDateEditText = (EditText) findViewById(R.id.return_date_edit_text);
        Button findTicketsButton = (Button) findViewById(R.id.find_tickets_button);
        mResultsTextView = (TextView) findViewById(R.id.results_text_view);
        mListView = (ListView) findViewById(R.id.list_view);


        findTicketsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String origin = originEditText.getText().toString();
                String destination = "LED";
                String departDate = departDateEditText.getText().toString();
                String returnDate = returnDateEditText.getText().toString();


                TinyTraveler.GetCheapestTicketsCallback callback = new TinyTraveler.GetCheapestTicketsCallback() {

                    @Override
                    public void onTicketsGot(@NonNull List<Ticket> tickets) {
                        showTickets(tickets);
                    }

                    @Override
                    public void onError() {
                        showError();
                    }

                };

                mTinyTraveler.getCheapestTickets(origin, destination, departDate, returnDate, callback);
            }
        });

    }


    private void showTickets(@NonNull List<Ticket> tickets) {
        if (tickets.size() == 0) {
            mResultsTextView.setText("Ничего не найдено :(");
            mListView.setVisibility(View.GONE);
        } else {
            mResultsTextView.setText("Результаты");
            mListView.setVisibility(View.VISIBLE);
            ListAdapter adapter = new ArrayAdapter<>(TheBestWayActivity.this, android.R.layout.simple_list_item_1, tickets);
            mListView.setAdapter(adapter);
        }
    }


    private void showError() {
        mResultsTextView.setText("Ошибка :(");
        mListView.setVisibility(View.GONE);
    }


}
