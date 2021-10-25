package id.vidya.menumakansqlite;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private List<MainData> dataList;
    private Activity context;
    private DBHandler dbHandler;

    public MainAdapter(Activity context, List<MainData> dataList){
        this.context = context;
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_makanan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainData data = dataList.get(position);
        dbHandler =   new DBHandler(context);
        holder.tvNamaMakanan.setText(data.getName());
//        holder.btnEdit.setOnClickListener(v -> {
//            MainData d = dataList.get(holder.getAdapterPosition());
//            int sID = d.getID();
//            String sName = d.getName();
//            Dialog dialog = new Dialog(context);
//            dialog.setContentView(R.layout.update_dialog);
//            int width = WindowManager.LayoutParams.MATCH_PARENT;
//            int height = WindowManager.LayoutParams.WRAP_CONTENT;
//            dialog.getWindow().setLayout(width, height);
//            dialog.show();
//
//            EditText edtRevisiNamaMakanan = dialog.findViewById(R.id.edtRevisiNamaMakanan);
//            Button update_btn = dialog.findViewById(R.id.btnUpdate);
//
//            edtRevisiNamaMakanan.setText(sName);
//            update_btn.setOnClickListener(v1 -> {
//                dialog.dismiss();
//                String uName = edtRevisiNamaMakanan.getText().toString().trim();
//                database.mainDao().update(sID, uName);
//                dataList.clear();
//                dataList.addAll(database.mainDao().getAll());
//                notifyDataSetChanged();
//            });
//        });
//        holder.btnDelete.setOnClickListener(v -> {
//            MainData d = dataList.get(holder.getAdapterPosition());
//            dbHandler.mainDao().delete(d);
//            int position1 = holder.getAdapterPosition();
//            dataList.remove(position1);
//            notifyItemRemoved(position1);
//            notifyItemRangeChanged(position1, dataList.size());
//        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaMakanan;
        Button btnDelete, btnEdit;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNamaMakanan = itemView.findViewById(R.id.tvNamaMakanan);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
