package secondlibrary.main.Activity.menuprincipal;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import secondlibrary.api.Book.ApiBookClient;
import secondlibrary.api.Book.LibroResponseJSON;
import secondlibrary.domain.Libro;
import secondlibrary.domain.OfertaIntercambio;
import secondlibrary.main.databinding.OfertaIntercambioListItemBinding;

import static secondlibrary.main.databinding.OfertaIntercambioListItemBinding.inflate;

public class OfertaIntercambioAdapter extends ListAdapter<OfertaIntercambio, OfertaIntercambioAdapter.OfertaIntercambioViewHolder> {

    public static final DiffUtil.ItemCallback<OfertaIntercambio> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<OfertaIntercambio>() {
                @Override
                public boolean areItemsTheSame(
                        @NonNull OfertaIntercambio oldOfertaIntercambio, @NonNull OfertaIntercambio newOfertaIntercambio) {
                    return oldOfertaIntercambio.getIdIntercambio() == newOfertaIntercambio.getIdIntercambio();
                }

                @Override
                public boolean areContentsTheSame(
                        @NonNull OfertaIntercambio oldOfertaIntercambio, @NonNull OfertaIntercambio newOfertaIntercambio) {
                    // NOTE: if you use equals, your object must properly override Object#equals()
                    // Incorrectly returning false here will result in too many animations.
                    return oldOfertaIntercambio.equals(newOfertaIntercambio);
                }
            };

    Context context;

    public OfertaIntercambioAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    private OnItemClickListener onItemClickListener;

    interface OnItemClickListener {
        void onItemClick(OfertaIntercambio ofertaIntercambio);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NotNull
    @Override
    public OfertaIntercambioAdapter.OfertaIntercambioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OfertaIntercambioListItemBinding binding = OfertaIntercambioListItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new OfertaIntercambioViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull OfertaIntercambioAdapter.OfertaIntercambioViewHolder holder, int position) {
        OfertaIntercambio intercambio = getItem(position);
        holder.bind(intercambio);
    }

    class OfertaIntercambioViewHolder extends RecyclerView.ViewHolder {

        private final OfertaIntercambioListItemBinding binding;

        public OfertaIntercambioViewHolder(@NonNull OfertaIntercambioListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(OfertaIntercambio ofertaIntercambio) {
            ApiBookClient.BookService service = ApiBookClient.getInstance().getService();
            service.getBook(ofertaIntercambio.getIsbnComerciante()).enqueue(new Callback<LibroResponseJSON>() {
                @Override
                public void onResponse(Call<LibroResponseJSON> call, Response<LibroResponseJSON> response) {
                    LibroResponseJSON libroResponseJSON = response.body();
                    Libro libro = libroResponseJSON.getLibroResponse();
                    if (libro != null) {
                        binding.tvTitulo.setText(libro.getTitulo());
                        binding.tvAutor.setText(libro.getAutores().get(0));
                        binding.tvEstadoIntercambio.setText(ofertaIntercambio.getEstadoIntercambio());
                        ImageLoader imageLoader = Coil.imageLoader(context);

                        ImageRequest request = new ImageRequest.Builder(context)
                                .data(libro.getImagenUrl())
                                .target(binding.ivLibro)
                                .build();
                        imageLoader.enqueue(request);

                        Log.i("SDI", libro.getTitulo());
                    }
                }

                @Override
                public void onFailure(Call<LibroResponseJSON> call, Throwable t) {
                    Log.i("SDI", t.getMessage());
                }
            });


            binding.getRoot().setOnClickListener(v -> {
                onItemClickListener.onItemClick(ofertaIntercambio);
            });

            binding.executePendingBindings();
        }
    }
}
