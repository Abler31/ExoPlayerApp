package ru.orme.studyproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import ru.orme.studyproject.adapters.VideoLinksAdapter;
import ru.orme.studyproject.model.VideoLinkModel;

public class ClickActivity extends AppCompatActivity implements VideoLinksAdapter.OnLinkListener {

    RecyclerView recyclerView;
    VideoLinksAdapter adapter;
    ArrayList<VideoLinkModel> linksArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);

        linksArray = new ArrayList<>();

        initArray();

        recyclerView = findViewById(R.id.recycler_view_link);

        recyclerView.hasFixedSize();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new VideoLinksAdapter(this, linksArray, this);

        recyclerView.setAdapter(adapter);
    }


    private void initArray(){
        VideoLinkModel link1 = new VideoLinkModel();
        link1.setTitle("Lesson №1");

        VideoLinkModel link2 = new VideoLinkModel();
        link2.setTitle("Lesson №2");

        VideoLinkModel link3 = new VideoLinkModel();
        link3.setTitle("Lesson №3");

        VideoLinkModel link4 = new VideoLinkModel();
        link4.setTitle("Lesson №4");

        VideoLinkModel link5 = new VideoLinkModel();
        link5.setTitle("Lesson №5");

        VideoLinkModel link6 = new VideoLinkModel();
        link6.setTitle("Lesson №6");

        VideoLinkModel link7 = new VideoLinkModel();
        link7.setTitle("Lesson №7");

        VideoLinkModel link8 = new VideoLinkModel();
        link8.setTitle("Lesson №8");

        VideoLinkModel link9 = new VideoLinkModel();
        link9.setTitle("Lesson №9");

        VideoLinkModel link10 = new VideoLinkModel();
        link10.setTitle("Lesson №10");

        linksArray.add(link1);
        linksArray.add(link2);
        linksArray.add(link3);
        linksArray.add(link4);
        linksArray.add(link5);
        linksArray.add(link6);
        linksArray.add(link7);
        linksArray.add(link8);
        linksArray.add(link9);
        linksArray.add(link10);
    }


    @Override
    public void onLinkClick(int position) {
        Intent intent = new Intent(this, VideoActivity.class);
        startActivity(intent);
    }
}
