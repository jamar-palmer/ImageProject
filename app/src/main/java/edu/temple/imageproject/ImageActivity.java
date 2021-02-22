package edu.temple.imageproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class ImageActivity extends AppCompatActivity {

    Spinner spinner;
    ImageView imageView;
    int[] dogImages;
    ArrayList dogImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList dogList = new ArrayList<String>();
        dogList.add("Please Select A Dog From The List");
        dogList.add("German Shepard");
       dogList.add("Bulldog");
       dogList.add("Poodle");
       dogList.add("Siberian Husky");
       dogList.add("Dachshund");
       dogList.add("Pomeranian");

        dogImages = new int[]{R.drawable.german_shepherd, R.drawable.bulldog,
                R.drawable.poodle, R.drawable.siberian_husky, R.drawable.daschund, R.drawable.pomeranian};

        dogImage = new ArrayList<Integer>();
        dogImage.add(R.drawable.german_shepherd);
        dogImage.add(R.drawable.bulldog);
        dogImage.add( R.drawable.poodle);
        dogImage.add(R.drawable.siberian_husky);
        dogImage.add(R.drawable.daschund);
        dogImage.add(R.drawable.pomeranian);


        spinner = findViewById(R.id.spinner);
        imageView = findViewById(R.id.imageView);

        ImageAdapter adapter = new ImageAdapter(this, dogList, dogImage);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    showPicture(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
        }
    private void showPicture(int position){
        if(position!=0) {
            imageView.setImageResource(dogImages[position-1]);
        }else{
            imageView.setImageResource(0);
        }
    }


}