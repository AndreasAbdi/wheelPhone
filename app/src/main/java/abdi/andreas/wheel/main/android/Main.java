package abdi.andreas.wheel.main.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

import abdi.andreas.wheel.game.main.GameInstance;

public class Main extends Activity {

    private GameInstance instance;
    private MainView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new MainView(this);
        setContentView(view);
        instance = new GameInstance(view);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    protected void onResume() {
        super.onResume();
        instance.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        instance.pause();
    }
}
