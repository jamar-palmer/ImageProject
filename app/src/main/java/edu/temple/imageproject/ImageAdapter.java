package edu.temple.imageproject;

import android.content.Context;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> items;
    ArrayList<Integer> pics;

    public ImageAdapter(Context context, ArrayList items, ArrayList pics){
        this.context = context;
        this.items = items;
        this.pics = pics;
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        //Pair<String, Integer> dogs = new Pair(items.get(position), pics.get(position));
        //return dogs;
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(context);
        textView.setText(items.get(position));
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20);
        return textView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        TextView desc = new TextView(context);
        ImageView pic = new ImageView(context);
        linearLayout.addView(desc);
        linearLayout.addView(pic);
        //View text1 = super.getDropDownView(position, convertView, parent);
        pic.getLayoutParams().height= 50;
        desc.setTextSize(15);

        desc.setText(items.get(position));
        if(position == 0){}else {
            pic.setImageResource(pics.get(position-1));
        }

        return linearLayout;
    }








}


