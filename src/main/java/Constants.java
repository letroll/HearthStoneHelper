/**
 * Created by jquievreux on 30/07/2014.
 */
public interface Constants {
    public static final String LOG_CONFIG_FILE = "log.config";
    public static final String MAC_CONFIG_PATH ="%LOCALAPPDATA%/Blizzard/Hearthstone/";
    public static final String WINDOWS_CONFIG_PATH ="/Library/Preferences/Blizzard/Hearthstone/";
    public static final String MAC_LOG_CONFIG_PATH =MAC_CONFIG_PATH + LOG_CONFIG_FILE;
    public static final String WINDOWS_LOG_CONFIG_PATH =WINDOWS_CONFIG_PATH + LOG_CONFIG_FILE;
    public static final String MAC_LOG_OUTPUT = "~/Library/Logs/Unity/Player.log";
//    public static final String WINDPWS_LOG_OUTPUT_X64 = "C:\Program Files (x86)\Hearthstone\Hearthstone_Data\output_log.txt";
//    public static final String WINDPWS_LOG_OUTPUT = "C:\Program Files\Hearthstone\Hearthstone_Data\output_log.txt";
}
