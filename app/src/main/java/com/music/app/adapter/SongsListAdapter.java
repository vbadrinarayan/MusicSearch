package com.music.app.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.music.app.R;
import com.music.app.model.UISearchResult;
import com.music.app.model.UISearchResultList;
import com.music.app.servicemanager.model.SearchMusicResult;
import com.music.app.utility.Util;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Badri on 03/05/16.
 */
public class SongsListAdapter extends RecyclerView.Adapter<SongsListAdapter.SongViewHolder> {

    private List<SearchMusicResult> mListData;

    private Context mContext;

    public SongsListAdapter(Context context, List<SearchMusicResult> listData){
        mListData = listData;
        mContext = context;
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_recycler_view_row
                , parent, false);
        SongViewHolder svh = new SongViewHolder(v);
        return svh;
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        SearchMusicResult result = mListData.get(position);
        holder.trackName.setText(result.getTrackName());
        holder.artistName.setText(result.getArtistName());
        holder.trackLength.setText(Util.getDuration(result.getTrackTimeMillis()));
        Picasso.with(mContext).load(result.getArtworkUrl100()).into(holder.trackImage);
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    public static class SongViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        ImageView trackImage;
        TextView trackName;
        TextView artistName;
        TextView trackLength;
        ImageView trackPlay;

        SongViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            trackName = (TextView)itemView.findViewById(R.id.track_name);
            artistName = (TextView)itemView.findViewById(R.id.artist_name);
            trackLength = (TextView)itemView.findViewById(R.id.track_length);
            trackImage = (ImageView) itemView.findViewById(R.id.track_photo);
            trackPlay = (ImageView) itemView.findViewById(R.id.track_play);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
