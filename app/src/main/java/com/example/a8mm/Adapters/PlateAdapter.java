package com.example.a8mm.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a8mm.Models.PlateModel;
import com.example.a8mm.R;

import java.util.List;

public class PlateAdapter extends RecyclerView.Adapter<PlateAdapter.PlateViewHolder> {
    public static final String TAG = "adapter";
    private List<PlateModel> plateModelList;
    private Context context;

    public PlateAdapter(List<PlateModel> plateModelList, Context context) {
        this.plateModelList = plateModelList;
        this.context = context;
    }

    @Override
    public PlateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_plates, parent, false);
        Log.d(TAG, "onCreateViewHolder: Inflation ok");
        return new PlateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlateViewHolder holder, int position) {
        PlateModel plateModel = plateModelList.get(position);

        Glide.with(context).load(plateModel.getPlate_img()).into(holder.plateImg);

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "size of list is: "+plateModelList.size());
        return plateModelList.size();
    }

    public class PlateViewHolder extends RecyclerView.ViewHolder {

        private ImageView plateImg;

        public PlateViewHolder(View itemView) {
            super(itemView);
            plateImg = itemView.findViewById(R.id.imageView2);
        }
    }
}
