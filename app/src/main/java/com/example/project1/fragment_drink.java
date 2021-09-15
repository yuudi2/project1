package com.example.project1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Adapter.CoffeeViewAdapter;
import Data.CoffeeData;


public class fragment_drink extends Fragment {


    private RecyclerView recyclerView = null;
    private CoffeeViewAdapter adapter = null;

    ArrayList<CoffeeData> coffeeList = new ArrayList<>();

    int [] coffee_img = {R.drawable.coffee1, R.drawable.coffee2, R.drawable.coffee3,
            R.drawable.coffee4, R.drawable.coffee5, R.drawable.coffee6};
    String [] coffee_name = {"헤이즐넛아메리카노IB","단팥IB","인절미IB","블랙다이몬 아이스커피","블랙다이몬 카페라떼(R)","블랙다이몬 카페수아(R)"};
    int [] coffee_price = {6000,6900,6800,5800,6300,7000};




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_drink, container, false);

        //recyclerview 어댑터 set
        recyclerView = v.findViewById(R.id.recyclerView);
        adapter = new CoffeeViewAdapter(coffeeList);
        recyclerView.setAdapter(adapter);

        for (int i=0;i<6;i++){
            coffeeList.add (new CoffeeData(coffee_img[i], coffee_name[i], coffee_price[i]));
        }


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        return v;
    }

    public void additem(int img, String name, int price){
        CoffeeData item = new CoffeeData(img,name,price);

        item.setImg(img);
        item.setName(name);
        item.setprice(price);

        coffeeList.add(item);
    }
}