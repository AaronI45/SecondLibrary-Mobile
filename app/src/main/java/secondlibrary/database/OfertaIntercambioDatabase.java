package secondlibrary.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import secondlibrary.domain.OfertaIntercambio;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {OfertaIntercambio.class}, version = 1)
public abstract class OfertaIntercambioDatabase extends RoomDatabase {

    public abstract OfertaIntercambioDao ofertaIntercambioDao();

    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static volatile OfertaIntercambioDatabase INSTANCE;

    public static OfertaIntercambioDatabase getDatabase(final android.content.Context context) {
        if (INSTANCE == null) {
            synchronized (OfertaIntercambioDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = androidx.room.Room.databaseBuilder(context.getApplicationContext(), OfertaIntercambioDatabase.class, "oferta_intercambios_db").build();
                }
            }
        }
        return INSTANCE;
    }
}
