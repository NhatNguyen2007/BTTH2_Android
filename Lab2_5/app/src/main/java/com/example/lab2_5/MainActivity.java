package com.example.lab2_5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lab2_5.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Spinner spnThumbnail;
    ThumbnailAdapter thumbnailAdapter;

    EditText editName;
    CheckBox checkboxPromotion;
    Button btnAdd;
    GridView gridView;
    String[] DishName = {};
    int[] DishImg = {};
    int[] Promotion = {};

    List<Thumbnail> list = new ArrayList<>();
    DishAdapter dishAdapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName=(EditText) findViewById(R.id.edit_Name);
        checkboxPromotion=(CheckBox) findViewById(R.id.checkbox_Promotion);
        btnAdd=(Button) findViewById(R.id.btn_AddANewDish);

        gridView=(GridView) findViewById(R.id.gvDish);

        dishAdapter = new DishAdapter(this,
                DishName,
                DishImg,
                Promotion);
        gridView.setAdapter(dishAdapter);

        spnThumbnail = findViewById(R.id.spn_Thumbnail);
        thumbnailAdapter = new ThumbnailAdapter(this,
                R.layout.item_selected_thumbnail,
                getListThumbnail());
        spnThumbnail.setAdapter(thumbnailAdapter);

        spnThumbnail.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, thumbnailAdapter.getItem(i).getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                processNhap();
            }
        });
    }

    private List<Thumbnail> getListThumbnail(){
        list.add(Thumbnail.Thumbnail1);
        list.add(Thumbnail.Thumbnail2);
        list.add(Thumbnail.Thumbnail3);
        list.add(Thumbnail.Thumbnail4);
        return list;
    }

    public void processNhap(){
        String name=editName.getText()+"";
        String imgName=spnThumbnail.getSelectedItem().toString();
        int img = list.get(positionOf(list, imgName)).getImg();

        DishName = addString(DishName.length, DishName, name);
        DishImg = addint(DishImg.length, DishImg, img);
        if(checkboxPromotion.isChecked()){
            Promotion = addint(Promotion.length, Promotion, 1);
        }
        else{
            Promotion = addint(Promotion.length, Promotion, 0);
        }
        dishAdapter = new DishAdapter(this,
                DishName,
                DishImg,
                Promotion);
        gridView.setAdapter(dishAdapter);

        editName.setText("");
        editName.requestFocus();
    }

    public static String[] addString(int n, String arr[], String x)
    {
        int i;
        String newarr[] = new String[n + 1];
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];
        newarr[n] = x;
        return newarr;
    }

    public static int[] addint(int n, int arr[], int x)
    {
        int i;
        int newarr[] = new int[n + 1];
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];
        newarr[n] = x;
        return newarr;
    }

    public int positionOf(List<Thumbnail> list, String x) {
        for(int i=0; i<list.size(); i++){
            String temp = list.get(i).getName().replace(" ", "");
            if(x.equals(temp)){
                return i;
            }
        }
        return -1;
    }

}