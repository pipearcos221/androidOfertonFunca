package unicauca.movil.oferton.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import unicauca.movil.oferton.R;
import unicauca.movil.oferton.databinding.TemplateNovedadBinding;
import unicauca.movil.oferton.models.Novedad;


public class NovedadAdapter extends RecyclerView.Adapter<NovedadAdapter.NovedadHolder> {

    public interface OnNovedadListener{
        void onNovedadClick(int position);
    }

    LayoutInflater inflater;
    List<Novedad> data;
    OnNovedadListener listener;

    public NovedadAdapter(LayoutInflater inflater, List<Novedad> data, OnNovedadListener listener) {
        this.inflater = inflater;
        this.data = data;
        this.listener = listener;
    }

    @Override
    public NovedadHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_novedad, parent, false);
        return new NovedadHolder(v);
    }

    @Override
    public void onBindViewHolder(NovedadHolder holder, int position) {
        holder.binding.setNovelty(data.get(position));
        holder.binding.card.setTag(position);
        holder.binding.setHandler(this);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void onItemClick(int position){
        listener.onNovedadClick(position);
    }

    //region ViewHolders
    static class NovedadHolder extends RecyclerView.ViewHolder{

        TemplateNovedadBinding binding;

        public NovedadHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
    //endregion


}
