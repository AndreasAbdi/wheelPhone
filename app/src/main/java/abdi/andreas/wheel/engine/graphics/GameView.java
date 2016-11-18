package abdi.andreas.wheel.engine.graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.google.common.base.Optional;

public class GameView extends SurfaceView {
    SurfaceHolder surfaceHolder;
    Canvas canvas;

    public GameView(Context context) {
        super(context);
        surfaceHolder = getHolder();
    }

    public Optional<Canvas> drawTo() {
        if(surfaceHolder.getSurface().isValid()) {
            canvas = surfaceHolder.lockCanvas();
            return Optional.of(canvas);
        }
        return Optional.absent();
    }

    public void unlock() {
        surfaceHolder.unlockCanvasAndPost(canvas);
    }

}
