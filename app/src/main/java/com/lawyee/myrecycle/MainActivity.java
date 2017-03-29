package com.lawyee.myrecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

import static com.lawyee.myrecycle.R.mipmap.b;
import static com.lawyee.myrecycle.R.mipmap.g;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private RecyclerView recyclerview;
    private ArrayList<Fruit> fruits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruist();
        initView();
    }

    private void initFruist() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit(
                    getRandomlengName("Apple")
//                    "Apple"
                    , R.mipmap.a);
            fruits.add(apple);
            Fruit fruit = new Fruit(
//                    "Banana"
             getRandomlengName("Banana")
                    , R.mipmap.ax);
            fruits.add(fruit);
            Fruit fruit1 = new Fruit("orange", b);
            fruits.add(fruit1);
            Fruit fruit2 = new Fruit("waterrmelon", R.mipmap.c);
            fruits.add(fruit2);

            Fruit fruit3 = new Fruit("vragap", R.mipmap.d);
            fruits.add(fruit3);
            Fruit fruit4 = new Fruit("Grape", g);
            fruits.add(fruit4);
            Fruit fruit5 = new Fruit("aPinaiang", R.mipmap.n);
            fruits.add(fruit5);
            Fruit fruit6 = new Fruit("andiasd", R.mipmap.s);
            fruits.add(fruit6);
            Fruit fruit7 = new Fruit("asdad", R.mipmap.timg);
            fruits.add(fruit7);

        }

    }

    private void initView() {
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setOnClickListener(this);
        Fruitadapter fruitadapter = new Fruitadapter(this,fruits);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(staggeredGridLayoutManager);
        recyclerview.setAdapter(fruitadapter);


    }

    @Override
    public void onClick(View v) {

    }
    private  String getRandomlengName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
         builder.append(name);
        }
        return builder.toString();
    }
}
