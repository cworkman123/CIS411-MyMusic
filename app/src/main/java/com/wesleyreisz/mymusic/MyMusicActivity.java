package com.wesleyreisz.mymusic;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wesleyreisz.mymusic.model.Song;
import com.wesleyreisz.mymusic.service.MockMusicService;

import java.util.ArrayList;
import java.util.List;


public class MyMusicActivity extends Activity {

    private ArrayAdapter<String> listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_music);

        //Initialize List View and Populate List<Song> Values via findAll() method
        ListView listView = (ListView) findViewById(R.id.listview);
        List<Song> songs = new MockMusicService().findAll();

        ArrayList<String> songList = new ArrayList<String>();

        for(Song song : songs ){
            String songTitle = song.getSongTitle();
            String artist = song.getArtistName();
            String album = song.getAlbumTitle();
            String date = song.getSongPublishedDate().toString();
            String newLine = System.getProperty("line.separator");

            String record = songTitle + newLine + "" + artist + newLine + "" + album + newLine +"" + date;

            songList.add(record);


        }

        //Create ArrayAdapter using the songlist
        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, songList);

        //Set the ArrayAdapter as the ListView's adapter.
        listView.setAdapter(listAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_music, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
