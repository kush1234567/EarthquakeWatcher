package com.bawp.firstmap.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawp.firstmap.R;
import com.bawp.firstmap.model.Earthquake;

import java.text.MessageFormat;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Earthquake>quakeList;
    private View.OnClickListener onItemClickListener;
    public void setItemClickListener(View.OnClickListener clickListener) {
        onItemClickListener = clickListener;
    }

    public RecyclerViewAdapter(Context context, List<Earthquake> quakeList) {
        this.context = context;
        this.quakeList =quakeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_quakes_list, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,final int position) {
         final Earthquake a = quakeList.get(position); // each contact object inside of our list
        viewHolder.information.setText(a.getPlace());
        viewHolder.lat.setText(MessageFormat.format("Lat {0}", a.getLat()));
        viewHolder.lon.setText(MessageFormat.format("Lon {0}", a.getLon()));
        viewHolder.magnitude.setText(MessageFormat.format("Magnitude {0}", a.getMagnitude()));
    }


    @Override
    public int getItemCount()
    {
        return quakeList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView information;
        public TextView lat;
        public TextView magnitude;
        public  TextView lon;
      //  public Button moreInformation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setTag(this);
            itemView.setOnClickListener(onItemClickListener);

            itemView.setOnClickListener(this);
            this.information= itemView.findViewById(R.id.information);
            this.lat=itemView.findViewById(R.id.lat);
            this.lon=itemView.findViewById(R.id.lon);
            this.magnitude=itemView.findViewById(R.id.magnitude);
          //  moreInformation = itemView.findViewById(R.id.Moreinformation);
           // moreInformation.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {


             /*  Intent intent =new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT,"This is a message from Implicit Intent");
            intent.putExtra(Intent.EXTRA_SUBJECT,"Do not worry!");*/
            // Build the intent

            Intent mapIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California"));

// Verify it resolves and always write
            PackageManager packageManager = context.getPackageManager();
            List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
            boolean isIntentSafe = activities.size() > 0;

// Start an activity if it's safe
            if (isIntentSafe) {
                context.startActivity(mapIntent);
            }
            context.startActivity(mapIntent);
        }


        // Log.d("Clicked", "onClick: " + contact.getName());


    }
}

