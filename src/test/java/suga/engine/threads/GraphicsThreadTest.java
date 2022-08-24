package suga.engine.threads;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;
import suga.engine.graphics.DrawListener;
import suga.engine.graphics.GraphicsPanelInterface;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests written for the GraphicsThread.
 *
 * @author Sugaku
 */
class GraphicsThreadTest {

    /**
     * A dummy GraphicsPanel which should be runnable at incredible rates, unlike Mocks.
     *
     * @author Sugaku
     */
    private static class DummyPanel implements GraphicsPanelInterface {
        public void drawing (int width, int height) {}
        public void setThread (SugaThread thread) {}
        public void registerListener (DrawListener listener) {}
        public void registerListener (DrawListener.Priorities priority, DrawListener listener) {}
        public void clearListeners () {}
        public void setPixel (int x, int y, Color c) {}
        public void setRectangle (int x, int y, int width, int height, Color c) {}
        public void setBigPixel (int x, int y, int r, Color c) {}
        public void addImage (int x, int y, int width, int height, String path) {}
        public void addImage (int x, int y, int width, int height, BufferedImage image) {}
        public void repaint () {}
    }

    /**
     * The thread currently under testing.
     */
    private GraphicsThread thread;

    /**
     * A mock GraphicsPanelInterface without any logic in .repaint();
     */
    private GraphicsPanelInterface graphicsPanelInterface = Mockito.mock(GraphicsPanelInterface.class);

    /**
     * Reset the mocks used in the GraphicsThread test.
     */
    @BeforeEach
    void reset () {
        graphicsPanelInterface = Mockito.mock(GraphicsPanelInterface.class);
        thread = new GraphicsThread(graphicsPanelInterface, 60);
    }

    /**
     *
     */
    @Test
    void setPaused() {
    }

    @Test
    void getPaused() {
    }

    @Test
    void setStopped() {
    }

    @Test
    void getStopped() {
    }

    /**
     * Tests whether running the GraphicsThread reaches the intended frame rate.
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/suga/engine/threads/run.csv", numLinesToSkip = 1, delimiter = ',')
    void run (int targetFps, long sampleTime) {
        final double error = 0.01; // We allow a 1% deviation from the target frame rate.
        thread = new GraphicsThread(graphicsPanelInterface, targetFps);
        thread.start();
        try {
            Thread.sleep(sampleTime * 1000);
        } catch (InterruptedException exception) {
            fail("Failed to wait for given duration.");
        }
        thread.setStopped(true);
        assertEquals(targetFps, GraphicsThread.getFPS(), error, "Graphics thread should run within " + error + "% of target fps.");
    }
}
