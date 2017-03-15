package com.example.ramen.menu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ramen.menu.Model.MenuItems;
import com.example.ramen.menu.Model.Order;
import com.example.ramen.menu.Model.OrderStatus;
import com.example.ramen.menu.Model.StaticProperties;

import java.util.List;

/**
 * Created by xitiz on 6/20/16.
 * This is a custom adapter made for presenting our elements.
 * RecyclerView provides two methods that we usually override:
 *      - onCreateViewHolder()
 *      - onBindViewHolder()
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {

//    private List<Movie> moviesList;

    private List<MenuItems> menuList;
    public MyClicks mClicks;
    private Context context;
    /**
     * A viewHolder for the
     * **/
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView title, year, genre;
        public RatingBar ratingBar;

        public MyViewHolder(View view, MyClicks listener) {
            super(view);
            mClicks = listener;
            context = view.getContext();
            imageView = (ImageView) view.findViewById(R.id.image);
            title = (TextView) view.findViewById(R.id.title);
//            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
            imageView.setOnClickListener(this);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            if(v instanceof ImageView){
                mClicks.clickOnImage((ImageView) v, getLayoutPosition());
            } else {
                mClicks.clickOnRow(v,getLayoutPosition());
            }
        }

    }

    /**
     * Interface for checking the clicks and what to do when different clicks occur.
     * **/

    public static interface MyClicks{
        public void clickOnImage(ImageView imgView, int pos);
        public void clickOnRow(View info);
        public void clickOnRow(View info, int pos);
    }


    public MenuAdapter(List<MenuItems> menuList) {
//        this.moviesList = moviesList;
        this.menuList = menuList;
//        this.context = context;
    }

    /**
     * Work of onCreateViewHolder
     * To inflate the view from movie_list_row layout.
     * **/
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        MenuAdapter.MyViewHolder myViewHolder = new MyViewHolder(itemView, new MenuAdapter.MyClicks() {

            public void clickOnImage(ImageView imgView, int pos){
                MenuItems menuItem = menuList.get(pos);
                Toast.makeText(context,"Image Click", Toast.LENGTH_SHORT).show();
                Log.d("Rating ","The click works");
                Intent intent = new Intent(context,PictureActivity.class);
                intent.putExtra("imageReference",menuItem.getImage());
                context.startActivity(intent);
            }

            public void clickOnRow(View info){
                Toast.makeText(context,"Whole row clicked", Toast.LENGTH_SHORT).show();
                Log.d("Movie Adapter","The Second click also works");
            }

            @Override
            public void clickOnRow(View info, int pos) {
                MenuItems menuItem = menuList.get(pos);
//                Toast.makeText(context,"Clicked"+ menuItem.getDishName(), Toast.LENGTH_SHORT).show();
                Order order = new Order(StaticProperties.getTableNo(),menuItem.getDishName(),1, OrderStatus.ORDER_IN.toString(),menuItem.getUnitPrice());

                StaticProperties.getNetworkTask().SendDataToNetwork(order);
                Toast.makeText(context,"Table No:"+StaticProperties.getTableNo()+" Clicked" + menuItem.getDishName(),Toast.LENGTH_SHORT).show();

                //TODO 1: show a dialog box and ask for quantity
                //TODO 2: Make one Order Object with the required details
                //TODO 3: Utilize socket and java networks and send the object to kitchenInterface
            }
        });

        return myViewHolder;
    }

    /**
     * Work of onBindViewHolder
     * Set the appropriate data to each value in the row.
     * Match the different elements with the corresponding value.
     * **/

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MenuItems menuItem = menuList.get(position);
        holder.imageView.setImageResource(menuItem.getImage());
        holder.title.setText(menuItem.getDishName());
//        holder.genre.setText(menuItem.getGenre());
        holder.year.setText("Rs."+menuItem.getUnitPrice());
        holder.ratingBar.setRating(menuItem.getRating());
    }


    @Override
    public int getItemCount() {
        return menuList.size();
    }
}