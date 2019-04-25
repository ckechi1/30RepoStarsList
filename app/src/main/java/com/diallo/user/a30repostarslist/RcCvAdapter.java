package com.diallo.user.a30repostarslist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class RcCvAdapter extends RecyclerView.Adapter<RcCvAdapter.MyViewHolder> {
     private ArrayList<RepoModel> mylistRepo ;
     private Context myContext;


    public RcCvAdapter(Context context, ArrayList<RepoModel> mylistRepo) {
        myContext = context;
        this.mylistRepo = mylistRepo;
    }
    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int i) {
         View myView = LayoutInflater.from(myContext).inflate(R.layout.repository_items , parent ,false );
        MyViewHolder holder = new MyViewHolder(myView);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int i) {

        holder.repoName.setText(mylistRepo.get(i).getRepoName());
        holder.repoDescription.setText(mylistRepo.get(i).getRepoDescription());
        holder.repoStars.setText(String.valueOf(mylistRepo.get(i).getRepoStars()));
        holder.ownerUsername.setText(mylistRepo.get(i).getOwnerUsername());
      //  ImageManager.setImage(myContext , holder.ownerPhoto , mylistRepo.get(i).getOwnerPhoto());

    }

    @Override
    public int getItemCount() {
        return mylistRepo.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView repoName;
        private TextView repoDescription;
        private TextView repoStars;
        private TextView ownerUsername;
        private ImageView ownerPhoto;

        public MyViewHolder( View itemView) {
            super(itemView);

            repoName = itemView.findViewById(R.id.repoNametv);
            repoDescription = itemView.findViewById(R.id.repoDescriptiontv);
            repoStars = itemView.findViewById(R.id.repostartv);
            ownerUsername = itemView.findViewById(R.id.repoOnwertv);
            ownerPhoto = itemView.findViewById(R.id.phototv);

        }
    }
}
