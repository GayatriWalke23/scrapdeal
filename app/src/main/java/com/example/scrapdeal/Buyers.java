package com.example.scrapdeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class Buyers extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener{
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        //SearchView search = (SearchView) item.getActionView();
        //search.setLayoutParams(new ActionBar.LayoutParams(Gravity.RIGHT));

        setContentView(R.layout.buyers_page);
        // data to populate the RecyclerView with
        ArrayList<String> industry_names = new ArrayList<>();
        ArrayList<Buyer_details> dataset = new ArrayList<>();
        industry_names.add("Horse");
        industry_names.add("Cow");
        industry_names.add("Camel");
        industry_names.add("Sheep");
        industry_names.add("Goat");
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvIndustries);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, industry_names, dataset);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

   /* private void filter(String text) {
        // creating a new array list to filter our data.
        ArrayList<String> filteredlist = new ArrayList<>();

        // running a for loop to compare elements.
        for (String item : courseModalArrayList) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.getCourseName().toLowerCase().contains(text.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            adapter.filterList(filteredlist);
        }
    }*/

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }


}