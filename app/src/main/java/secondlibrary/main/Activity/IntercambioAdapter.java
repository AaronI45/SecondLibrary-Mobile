//package secondlibrary.main.Activity;
//
//import android.content.Context;
//import android.widget.AdapterView;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.DiffUtil;
//import androidx.recyclerview.widget.RecyclerView;
//import org.jetbrains.annotations.NotNull;
//import secondlibrary.domain.Intercambio;
//
//public class IntercambioAdapter extends ListAdapter<Intercambio, IntercambioAdapter.IntercambioAdapterViewHolder>{
//    public static final DiffUtil.ItemCallback<Intercambio> DIFF_CALLBACK =
//            new DiffUtil.ItemCallback<Intercambio>() {
//                @Override
//                public boolean areItemsTheSame(@NonNull Intercambio oldItem, @NotNull Intercambio newItem) {
//                    return oldItem.getIdIntercambio() == newItem.getIdIntercambio();
//                }
//
//                @Override
//                public boolean areContentsTheSame( @NotNull Intercambio oldItem, @NotNull Intercambio newItem) {
//                    return oldItem.equals(newItem);
//                }
//            };
//    Context context;
//
//    public IntercambioAdapter(Context context) {
//        super(DIFF_CALLBACK);
//        this.context = context;
//    }
//
//    private OnItemClickListener onItemClickListener;
//
//    class IntercambioAdapterViewHolder extends RecyclerView.ViewHolder {
//        private final  binding;
//
//        public IntercambioAdapterViewHolder(OfertaIntercambioListItemBinding binding) {
//            super(binding.getRoot());
//            this.binding = binding;
//        }
//
//        public void bind(OfertaIntercambio ofertaIntercambio) {
//            binding.setOfertaIntercambio(ofertaIntercambio);
//            binding.executePendingBindings();
//        }
//    }
//
//}
