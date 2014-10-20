package com.wesleyreisz.mymusic.service;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wesleyreisz.mymusic.R;
import com.wesleyreisz.mymusic.model.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Channing on 10/20/2014.
 */
public class FragmentList extends Fragment{

    private ArrayAdapter<String> listAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_fragment, container, false);
    }


    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        //Initialize List View and Populate List<Song> Values via findAll() method
        ListView listView = (ListView) getActivity().findViewById(R.id.listviewfragment);
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
        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simplerow, songList);

        //Set the ArrayAdapter as the ListView's adapter.
        listView.setAdapter(listAdapter);
    }

}
