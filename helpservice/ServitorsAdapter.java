package com.example.helpservice;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.jar.Attributes;

public class ServitorsAdapter extends RecyclerView.Adapter<ServitorsAdapter.ServitorsViewAdapter>{

    private List<ServitorsData>list;
    private Context context;

    public ServitorsAdapter(List<ServitorsData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ServitorsViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.servitors_layout,parent,false);
        return new ServitorsViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServitorsAdapter.ServitorsViewAdapter holder, int position) {

        ServitorsData item=list.get(position);
        holder.Name.setText(item.getServitorName());
        holder.Phone.setText(item.getServitorPhoneno());
        holder.Address.setText(item.getServitorAddress());
        holder.Age.setText(item.getServitorAge());

        try {
            Picasso.get().load(item.getImage()).into(holder.imageView);
        }catch (Exception e){
            e.printStackTrace();
        }
        holder.updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context,Booking.class);
                context.startActivity(intent);

               // Toast.makeText(context, "Update Servitors", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class ServitorsViewAdapter extends RecyclerView.ViewHolder {

        private TextView Name,Phone,Address,Age;
        private Button updateBtn;
        private ImageView imageView;

        public ServitorsViewAdapter(@NonNull View itemView) {
            super(itemView);

            Name=itemView.findViewById(R.id.Name);
            Phone=itemView.findViewById(R.id.Phone);
            Address=itemView.findViewById(R.id.Address);
            Age=itemView.findViewById(R.id.Age);

            imageView=itemView.findViewById(R.id.updateImage);
            updateBtn=itemView.findViewById(R.id.updateBtn);
        }
    }
}
