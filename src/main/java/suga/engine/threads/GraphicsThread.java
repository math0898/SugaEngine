package suga.engine.threads;

import suga.engine.GameEngine;
import suga.engine.graphics.GraphicsPanelInterface;

/**
 * A thread used to refresh the graphics of a panel as fast as possible.
 *
 * @author Sugaku
 */
public class GraphicsThread extends AbstractThread implements SugaThread {

    /**
     * The panel that should be redrawn every frame.
     */
    private final GraphicsPanelInterface panel;

    /**
     * Creates a new graphics thread with the given panel.
     *
     * @param panel     The panel to refresh for every frame.
     * @param frameRate The target frequency to draw frames at.
     */
    public GraphicsThread (GraphicsPanelInterface panel, int frameRate) {
        super(frameRate);
        this.panel = panel;
        this.frameRate = frameRate;
        panel.setThread(this);
    }

    /**
     * Called to run the Graphics thread.
     */
    @Override
    public void run () {
        startTime = System.currentTimeMillis();
        frames = 0;
        while (!stopped) {
            long runtime = 0;
            if (!paused) {
                long frameStart = System.currentTimeMillis();
                try {
                    panel.repaint();
                } catch (Exception e) {
                    GameEngine.getLogger().log(e);
                }
                runtime = System.currentTimeMillis() - frameStart;
            }
            try {
                long toWait = Math.round(((1000.0 - ((System.currentTimeMillis() - startTime) % 1000)) / (frameRate - (frames % frameRate) )) - runtime);
                if (toWait < 0) toWait = 0;
                //noinspection BusyWait
                sleep(toWait);
            } catch (InterruptedException e) {
                GameEngine.getLogger().log(e);
            }
            frames++;
        }
    }
}
