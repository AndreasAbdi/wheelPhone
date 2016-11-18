package abdi.andreas.wheel.engine.graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView {
    SurfaceHolder surfaceHolder;
    Canvas canvas;

    public GameView(Context context) {
        super(context);
        surfaceHolder = getHolder();
    }

    public Canvas drawTo() {
        if(surfaceHolder.getSurface().isValid()) {
            canvas = surfaceHolder.lockCanvas();
            return canvas;
        }
        return null;
    }

    public void unlock() {
        surfaceHolder.unlockCanvasAndPost(canvas);
    }

}
