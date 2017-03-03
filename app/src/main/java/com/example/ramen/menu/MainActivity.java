package com.example.ramen.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ramen.menu.Model.MenuItems;
import com.example.ramen.menu.Model.Order;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    private List<Movie> movieList = new ArrayList<>();

    private List<MenuItems> menuList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MenuAdapter mAdapter;
    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        order = new Order();

        Toast.makeText(getApplicationContext(),""+order.getTableNo(),Toast.LENGTH_LONG ).show();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MenuAdapter(menuList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        //RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

      /*      menuList = MenuItems.generateMenu();
        for(MenuItems menuItems: menuList){
            Toast.makeText(getApplicationContext(),menuItems.getDishName(),Toast.LENGTH_SHORT);
        }*/

        prepareMenuData();

        mAdapter.notifyDataSetChanged();
    }

    private void prepareMenuData() {

        menuList.add(new MenuItems("Chicken Roast", 200, R.drawable.chicken_roast,5));
        menuList.add(new MenuItems("Chowmin", 120, R.drawable.chowmin,5));
        menuList.add(new MenuItems("Fried Rice", 140, R.drawable.friedrice,5));
        menuList.add(new MenuItems("Momo", 200, R.drawable.momo,5));
        menuList.add(new MenuItems("Sizzler", 200, R.drawable.sizzler,5));
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                Toast.makeText(getApplicationContext(),"Socket Setting in process", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.info:
                Toast.makeText(getApplicationContext(),"Restro App v0.SuperBeta", Toast.LENGTH_LONG).show();
                return true;

            case R.id.favourite:
                Toast.makeText(getApplicationContext(),"Rating Comming Soon", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}