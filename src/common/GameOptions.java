package common;

/**
 *
 * @author Barrionuevo Diego
 */
public class GameOptions {

    public static int DEFAULT_SCREEN_WIDTH = 800;
    public static int DEFAULT_SCREEN_HEIGHT = 600;
    public static int DEFAULT_FPS = 60;
    public static boolean DEFAULT_FULL_SCREEN = false;

    private int screenWidth, screenHeight, fps;
    private boolean fullScreen;

    public GameOptions(int screenWidth, int screenHeight, boolean fullScreen, int fps) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.fps = fps;
        this.fullScreen = fullScreen;
    }
    
    public GameOptions(int screenWidth, int screenHeight, boolean fullScreen) {
        this(screenWidth, screenHeight, fullScreen, DEFAULT_FPS);
    }

    public GameOptions(int screenWidth, int screenHeight) {
        this(screenWidth, screenHeight, DEFAULT_FULL_SCREEN, DEFAULT_FPS);
    }

    public GameOptions() {
        this(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT, DEFAULT_FULL_SCREEN, DEFAULT_FPS);
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public boolean isFullScreen() {
        return fullScreen;
    }

    public int getFps() {
        return fps;
    }

}
