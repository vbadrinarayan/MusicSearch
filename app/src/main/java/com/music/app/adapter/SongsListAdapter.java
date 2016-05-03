package com.music.app.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.music.app.R;
import com.music.app.inter.ListItemClickCallback;
import com.music.app.servicemanager.model.SearchMusicResult;
import com.music.app.utility.Util;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * SongsListAdapter binds data with the songs list.
 */
public class SongsListAdapter extends RecyclerView.Adapter<SongsListAdapter.SongViewHolder> {

    private List<SearchMusicResult> mListData;

    private Context mContext;

    private static ListItemClickCallback mCallback;

    public SongsListAdapter(Context context, List<SearchMusicResult> listData){
        mListData = listData;
        mContext = context;
        mCallback = (ListItemClickCallback) context;
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_recycler_view_row
                , parent, false);
        return new SongViewHolder(v);
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

    public static class SongViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
        LinearLayout layout;
        CardView cv;
        ImageView trackImage;
        TextView trackName;
        TextView artistName;
        TextView trackLength;
        ImageView trackPlay;

        SongViewHolder(View itemView) {
            super(itemView);
            layout = (LinearLayout)itemView.findViewById(R.id.layout);
            cv = (CardView)itemView.findViewById(R.id.cv);
            trackName = (TextView)itemView.findViewById(R.id.track_name);
            artistName = (TextView)itemView.findViewById(R.id.artist_name);
            trackLength = (TextView)itemView.findViewById(R.id.track_length);
            trackImage = (ImageView) itemView.findViewById(R.id.track_photo);
            trackPlay = (ImageView) itemView.findViewById(R.id.track_play);

            layout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mCallback.OnHandleItemCLick(getAdapterPosition());
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
