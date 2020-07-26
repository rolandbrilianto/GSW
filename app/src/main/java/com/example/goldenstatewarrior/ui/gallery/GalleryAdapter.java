package com.example.goldenstatewarrior.ui.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goldenstatewarrior.R;
import com.example.goldenstatewarrior.UserHelperClass;

import org.w3c.dom.Text;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
    private Context mcontext;
    private List<UserHelperClass> users;

    public GalleryAdapter(Context mcontext, List<UserHelperClass> users) {
        this.mcontext = mcontext;
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.user_list_item,parent,false);
        return new GalleryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserHelperClass userHelperClass = users.get(position);
        String versus = userHelperClass.getVersus();
        String tanggal = userHelperClass.getTanggal();
        String time = userHelperClass.getTime();
        String finalScore = userHelperClass.getFinalScore();
        holder.Versus.setText(versus);
        holder.Tanggal.setText(tanggal);
        holder.Time.setText(time);
        holder.FinalScore.setText(finalScore);

    }

    @Override
    public int getItemCount() {
       return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       TextView Versus, Tanggal, Time, FinalScore;
        public ViewHolder(View itemView){
            super(itemView);
            Versus=itemView.findViewById(R.id.textViewVersus);
            Tanggal=itemView.findViewById(R.id.textViewTanggal);
            Time=itemView.findViewById(R.id.textViewTime);
            FinalScore=itemView.findViewById(R.id.textViewFinalScore);

        }
    }
}
