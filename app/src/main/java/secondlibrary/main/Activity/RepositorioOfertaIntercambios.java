package secondlibrary.main.Activity;

import android.util.Log;
import androidx.lifecycle.LiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import secondlibrary.api.ApiClient;
import secondlibrary.database.OfertaIntercambioDatabase;
import secondlibrary.domain.Intercambio;
import secondlibrary.domain.OfertaIntercambio;

import java.util.List;

public class RepositorioOfertaIntercambios {
    public interface DownloadStatusListener{
        void downloadSuccess();
        void downloadError(String mensaje);
    }

    private final OfertaIntercambioDatabase database;
    public RepositorioOfertaIntercambios(OfertaIntercambioDatabase database) {
        this.database = database;
    }

    public LiveData<List<OfertaIntercambio>> getListaOfertaIntercambios(){
        return database.ofertaIntercambioDao().getOfertaIntercambios();
    }
    public void descargarYGuardarOfertaPrestamos(DownloadStatusListener listener){
        ApiClient.OfertaIntercambioService service = ApiClient.getInstance().getOfertaIntercambioService();
        service.getOfertasIntercambios().enqueue(new Callback<List<OfertaIntercambio>>(){
            @Override
            public void onResponse(Call<List<OfertaIntercambio>> call,
                                   Response<List<OfertaIntercambio>> response) {
                List<OfertaIntercambio> ofertaIntercambios = response.body();
                OfertaIntercambioDatabase.databaseWriteExecutor.execute(() -> {
                    database.ofertaIntercambioDao().insertAll(ofertaIntercambios);
                });
                listener.downloadSuccess();
            }
            @Override
            public void onFailure(Call<List<OfertaIntercambio>> call, Throwable t) {

                Log.e("SDI", "onFailure: "+t.getMessage());
                listener.downloadError(t.getMessage());
            }
        });
    }
}
