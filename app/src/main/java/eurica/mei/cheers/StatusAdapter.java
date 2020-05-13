package eurica.mei.cheers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.StatusViewHolder> {

    private ArrayList<Status> dataList;

    public StatusAdapter(ArrayList<Status> dataList) {
        this.dataList = dataList;
    }

    @Override
    public StatusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.status_row, parent, false);
        return new StatusViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StatusViewHolder holder, int position) {
        holder.tvUser.setText(dataList.get(position).getUser());
        holder.tvStatus.setText(dataList.get(position).getStatus());
        holder.tvTime.setText(dataList.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class StatusViewHolder extends RecyclerView.ViewHolder{
        private TextView tvUser, tvStatus, tvTime;

        public StatusViewHolder(View itemView) {
            super(itemView);
            tvUser = (TextView) itemView.findViewById(R.id.tvUser);
            tvStatus = (TextView) itemView.findViewById(R.id.tvStatus);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
        }
    }

}
