package secondlibrary.main.Activity.menuprincipal;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import secondlibrary.main.Activity.menuprincipal.OfertaIntercambioViewModel;

public class OfertaIntercambioViewModelFactory implements ViewModelProvider.Factory{
    private final Application application;

    public OfertaIntercambioViewModelFactory(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public<T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new OfertaIntercambioViewModel(application);
    }
}
