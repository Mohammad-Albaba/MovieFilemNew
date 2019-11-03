package com.example.moviefilem.DataBase;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviefilem.R;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AdapterRecylerView extends RecyclerView.Adapter<AdapterRecylerView.ViewHolder> {
    private Context context;
    private ArrayList<Movie> list ;

    public AdapterRecylerView() {
    }

    public AdapterRecylerView(Context context, ArrayList<Movie> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterRecylerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecylerView.ViewHolder holder, int position) {
            holder.movie.setText(list.get(position).getMovie());
            holder.year.setText(list.get(position).getYear()+"");
            holder.rating.setText(list.get(position).getReating()+"");
            holder.director.setText(list.get(position).getDirocter());
            holder.duration.setText(list.get(position).getDuration());
            holder.story.setText(list.get(position).getStory());
            holder.cast.setText(list.get(position).getCast());
            holder.tagline.setText(list.get(position).getTagline());


            if (list.get(position).getImage()!=null& URLUtil.isValidUrl(list.get(position).getImage())){
                Picasso.get().load(list.get(position).getImage()).placeholder(R.drawable.sss).into(holder.img);
            }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img ;
        TextView story ;
        TextView movie ;
        TextView year ;
        TextView rating ;
        TextView duration ;
        TextView director ;
        TextView cast ;
        TextView tagline ;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.image_Url);
            story = itemView.findViewById(R.id.story);
            movie = itemView.findViewById(R.id.movie);
            rating = itemView.findViewById(R.id.rating);
            director = itemView.findViewById(R.id.director);
            duration = itemView.findViewById(R.id.duration);
            year = itemView.findViewById(R.id.year);
            cast = itemView.findViewById(R.id.cast);
            tagline = itemView.findViewById(R.id.tagline);



        }
    }
}
