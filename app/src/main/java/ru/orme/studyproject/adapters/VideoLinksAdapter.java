package ru.orme.studyproject.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.orme.studyproject.R;
import ru.orme.studyproject.model.VideoLinkModel;

public class VideoLinksAdapter extends RecyclerView.Adapter<VideoLinksAdapter.LinkViewHolder> {

    Context context;
    ArrayList<VideoLinkModel> linksArray;
    private OnLinkListener mOnLinkListener;

    public VideoLinksAdapter(Context context, ArrayList<VideoLinkModel> linksArray, OnLinkListener onLinkListener){
        this.context = context;
        this.linksArray = linksArray;
        this.mOnLinkListener = onLinkListener;
    }



    @NonNull
    @Override
    public LinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.video_link_item, parent, false);
        return new LinkViewHolder(view, mOnLinkListener);
    }

    @Override
    public void onBindViewHolder(@NonNull LinkViewHolder holder, int position) {
        VideoLinkModel link = linksArray.get(position);
        holder.title.setText(link.getTitle());
    }

    @Override
    public int getItemCount() {
        return linksArray.size();
    }

    public class LinkViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        OnLinkListener onLinkListener;
        public LinkViewHolder(@NonNull View itemView, OnLinkListener onLinkListener) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_link_title);
            this.onLinkListener = onLinkListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onLinkListener.onLinkClick(getAdapterPosition());
        }
    }

    public interface OnLinkListener{
        void onLinkClick(int position);
    }
}
