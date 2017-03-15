package com.example.ramen.menu;

import android.content.Intent;
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
import com.example.ramen.menu.Model.StaticProperties;

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

        menuList.add(new MenuItems("Chicken Roast", 200, R.drawable.chicken_roast,3));
        menuList.add(new MenuItems("Fried Rice", 140, R.drawable.friedrice,5));
        menuList.add(new MenuItems("Buff Momo", 200, R.drawable.momo,5));
        menuList.add(new MenuItems("Buff Sizzler", 200, R.drawable.sizzler_sizzler,3));
        menuList.add(new MenuItems("Chicken Chow mein", 350, R.drawable.recipechicken_chow_mein,3));
        menuList.add(new MenuItems("Chicken Momo", 180, R.drawable.chicken_momo,3));

        menuList.add(new MenuItems("Fried Momo", 350, R.drawable.friedmomo,3));
        menuList.add(new MenuItems("Coke", 70, R.drawable.coke,3));


//        menuList.add(new MenuItems("Tuborg Beer", 350, R.drawable.tuborg,3));
        menuList.add(new MenuItems("Carlsberg Beer", 350, R.drawable.carlsberg,3));


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
                Toast.makeText(getApplicationContext(),"Socket Setting in the making", Toast.LENGTH_SHORT).show();
//                Intent i = new Intent(getApplicationContext(),SocketSettingActivity.class);
//                startActivity(i);
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

    @Override
    protected void onDestroy() {
        StaticProperties.getNetworkTask().cancel(true);
        super.onDestroy();
    }
}