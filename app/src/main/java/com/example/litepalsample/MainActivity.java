package com.example.litepalsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.litepalsample.bean.Album;
import com.example.litepalsample.bean.Song;

import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListener();
    }

    private void setListener() {
        findViewById(R.id.btn_save).setOnClickListener(view -> saveData());
        findViewById(R.id.btn_update).setOnClickListener(view -> updateData());
        findViewById(R.id.btn_del).setOnClickListener(view -> delData());
        findViewById(R.id.btn_query).setOnClickListener(view -> queryData());
    }

    private void saveData() {
        Album album = new Album();
        album.setName("album");
        album.setPrice(10.99f);
        album.setNumber(100);
        album.save();

        Song song1 = new Song();
        song1.setName("song1");
        song1.setDuration(150);
        song1.save();

        Song song2 = new Song();
        song2.setName("song2");
        song2.setDuration(200);
        song2.save();
        Toast.makeText(this, "数据已保存" , Toast.LENGTH_SHORT).show();
    }

    private void updateData() {
        //第一种
        Song songToUpdate = DataSupport.find(Song.class, 1);
        songToUpdate.setDuration(300);
        songToUpdate.save();
        Toast.makeText(this, "数据已更新" , Toast.LENGTH_SHORT).show();
        //第二种
//        Song songToUpdate = new Song();
//        songToUpdate.setDuration(300); // raise the price
//        songToUpdate.update(1);
    }

    private void delData() {
        //删除某一个
        //DataSupport.delete(Song.class, 1);
        DataSupport.deleteAll(Song.class, "duration > ?", "100");
    }

    private void queryData() {
        List<Song> allSongs = DataSupport.findAll(Song.class);
        Toast.makeText(this, "查询=" + allSongs, Toast.LENGTH_SHORT).show();
    }
}
