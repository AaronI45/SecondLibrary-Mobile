package secondlibrary.main.Activity;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import org.jetbrains.annotations.NotNull;
import secondlibrary.RequestStatus;
import secondlibrary.api.StatusWithDescription;
import secondlibrary.database.OfertaIntercambioDatabase;
import secondlibrary.domain.Intercambio;
import secondlibrary.domain.OfertaIntercambio;
import secondlibrary.domain.Prestamo;

import java.util.List;

public class OfertaIntercambioViewModel extends AndroidViewModel {

    private MutableLiveData<StatusWithDescription> statusWithDescriptionMutableLiveData = new MutableLiveData<>();

    public OfertaIntercambioViewModel(@NotNull Application application) {
        super(application);
        OfertaIntercambioDatabase database = OfertaIntercambioDatabase.getDatabase(application);
        repositorio = new RepositorioOfertaIntercambios(database);
    }
    public LiveData<List<OfertaIntercambio>> getListaIntercambios(){
        return repositorio.getListaOfertaIntercambios();
    }
    private final RepositorioOfertaIntercambios repositorio;

    public void descargarOfertaIntercambios(){
        statusWithDescriptionMutableLiveData.setValue(new StatusWithDescription(RequestStatus.LOADING, ""));
        repositorio.descargarYGuardarOfertaPrestamos(new RepositorioOfertaIntercambios.DownloadStatusListener() {
            @Override
            public void downloadSuccess() {
                statusWithDescriptionMutableLiveData.setValue(new StatusWithDescription(RequestStatus.DONE, ""));
            }

            @Override
            public void downloadError(String message) {
                Log.e("SDI", "downloadError: "+message);
                statusWithDescriptionMutableLiveData.setValue(new StatusWithDescription(RequestStatus.ERROR, message));
            }
        });
    }

    public LiveData<StatusWithDescription> getStatusWithDescriptionMutableLiveData(){
        return statusWithDescriptionMutableLiveData;
    }
}
