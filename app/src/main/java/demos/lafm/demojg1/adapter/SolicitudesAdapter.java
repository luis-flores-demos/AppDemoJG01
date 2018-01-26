package demos.lafm.demojg1.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

import demos.lafm.demojg1.R;
import demos.lafm.demojg1.model.Solicitud;

public class SolicitudesAdapter extends RecyclerView.Adapter<SolicitudesAdapter.ViewHolder>{

    private ArrayList<Solicitud> data;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_id;

        public ViewHolder(View view) {
            super(view);
        }

    }

    public SolicitudesAdapter(ArrayList<Solicitud>  data) {
        this.data = data;
    }

    @Override
    public SolicitudesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_solicitud, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return data.size();
    }

}