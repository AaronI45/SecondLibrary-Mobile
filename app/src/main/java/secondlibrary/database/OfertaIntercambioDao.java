package secondlibrary.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import secondlibrary.domain.OfertaIntercambio;

import java.util.List;

@Dao
public interface OfertaIntercambioDao {
    @Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    void insertAll(List<OfertaIntercambio> listaOfertaIntercambios);
    @Query("SELECT * FROM oferta_intercambios")
    LiveData<List<OfertaIntercambio>> getOfertaIntercambios();
}
