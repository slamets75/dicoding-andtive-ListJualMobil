package dicodingac.app.listjualmobil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[][] data = new String[][]{
            {"Honda, Brio, 1.2L CKD S A/T, 2015", "http://imgcdn.rajamobil.com:8080/resize2/public/media/images/databasemobil/mobilbaru/color/Brio%20-%20Brilliant%20Sporty%20Blue%20Metallic.png?v=420","19 Juta"," Jakarta Selatan "},
            {"Honda,Jazz,RS 1.5 A/T, 2015","http://imgcdn.rajamobil.com:8080/resize2/public/media/images/databasemobil/original/2016/12/15/S1V6xervpWJK8rWnOqhxSve86RCb7VxK.JPG?v=493.83983572895","19 Juta","Jakarta Selatan"},
            {"Mazda, Mazda2,V 1.5 M/T,2014","http://imgcdn.rajamobil.com:8080/resize2/public/media/images/databasemobil/mobilbaru/color/mazda2-abutua.jpg?v=420","Rp. 107.500.000","Tangerang"},
            {"Honda, Jazz,A 1.5 M/T,2015","http://imgcdn.rajamobil.com:8080/resize2/public/media/images/databasemobil/original/2016/12/19/otxIMI39Mq7o6QROZ7GJr_sm-TkizvNz.jpg?v=526.36904761905","Rp. 207.500.000","Jakarta Barat"},
            {"Mitsubishi,Outlander,Sport PX, 2015","http://imgcdn.rajamobil.com:8080/resize2/public/media/images/databasemobil/original/2016/11/17/81y5XBNeCNUQ-wUvaB6q7eSYc7D3XGr8.JPG?v=492.82786885246","Rp.117.500.000", " Tangerang"}
    };
    private ListView lvItem;
    private ArrayList listItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvItem = (ListView)findViewById(R.id.lv_item);
        listItem = new ArrayList<>();
        MobilModel mobil = null;
        for (int i = 0; i < data.length; i++){
            mobil = new MobilModel();
            mobil.setTitle(data[i][0]);
            mobil.setImage(data[i][1]);
            mobil.setHarga(data[i][2]);
             mobil.setLokasi(data[i][3]);
            listItem.add(mobil);
        }
        MobilAdapter adapter = new MobilAdapter(MainActivity.this, listItem);
        lvItem.setAdapter(adapter);
        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MobilModel mbl = (MobilModel) listItem.get(position);

                Intent intent = new Intent(MainActivity.this, DetailMobilActivity.class);
                intent.putExtra(DetailMobilActivity.KEY_ITEM, mbl);
                startActivityForResult(intent, 0);
                 }
             });

    }
}
