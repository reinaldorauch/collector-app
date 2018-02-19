package tk.reinaldorauch.collectorapp;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors para rodar tarefas fora da main thread
 * Created by Reinaldo on 18/02/2018.
 */

public class AppExecutors {
    private static final int THREAD_COUNT = 2;

    private final ExecutorService diskIO;
    private final Executor networkIO;
    private final Executor mainThread;

    private AppExecutors(ExecutorService diskIO, Executor networkIO, Executor mainThread) {
        this.diskIO = diskIO;
        this.networkIO = networkIO;
        this.mainThread = mainThread;
    }

    public AppExecutors () {
        this(
                Executors.newSingleThreadExecutor(),
                Executors.newFixedThreadPool(THREAD_COUNT),
                new MainThreadExecutor()
        );
    }

    public ExecutorService diskIO() {
        return diskIO;
    }

    public Executor networkIO() {
        return networkIO;
    }

    public Executor mainThread() {
        return mainThread;
    }

    private static class MainThreadExecutor implements Executor {
        private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}
