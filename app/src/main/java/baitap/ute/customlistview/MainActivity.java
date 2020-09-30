package baitap.ute.customlistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String mTitle[] = {"Facebook", "Youtube", "Instagram", "Twitter"};
    String mDescription[] = {"Facebook Description", "Youtube Description", "Instagram Description", "Twitter Description"};
    int images[] = {R.drawable.facebook, R.drawable.youtube, R.drawable.instagram, R.drawable.twiter};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.Lv);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    if (position == 0) {
                        Toast.makeText(MainActivity.this, "Facebook Description", Toast.LENGTH_SHORT).show();
                    }
                    if (position == 0) {
                        Toast.makeText(MainActivity.this, "Youtube Description", Toast.LENGTH_SHORT).show();
                    }
                    if (position == 0) {
                        Toast.makeText(MainActivity.this, "Instagram Description", Toast.LENGTH_SHORT).show();
                    }
                    if (position == 0) {
                        Toast.makeText(MainActivity.this, "Twiter Description", Toast.LENGTH_SHORT).show();
                    }
                }
        });


    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        String rDescription[];
        int rimgs[];

        MyAdapter(Context c, String title[], String description[], int img[]) {
            super(c, R.layout.row, R.id.tv1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rimgs = img;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.tv1);
            TextView myDescription = row.findViewById(R.id.tv2);

            images.setImageResource(rimgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }
    }
}