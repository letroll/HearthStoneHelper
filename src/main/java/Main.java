import org.apache.commons.lang3.SystemUtils;

import java.io.*;

/**
 * Created by jquievreux on 28/07/2014.
 */
public class Main implements Constants{

/*   static{
       try {

           System.loadLibrary("jpcap");

       } catch (UnsatisfiedLinkError e) {
           System.err.println("Native code library failed to load.\n" + e);
           System.exit(1);
       }
    }*/

    public static void main(String[] args) {
        init();

        if(SystemUtils.IS_OS_MAC){
            initForMac();
        }else if(SystemUtils.IS_OS_WINDOWS){
            initForWindows();
        }else{
            System.exit(0);
        }

    }

    private static void init() {
//        System.getProperties().list(System.out);
//        System.out.println(System.getProperty("java.library.path"));


        //Obtain the list of network interfaces
//        jpcap.NetworkInterface[] devices = JpcapCaptor.getDeviceList();
//            report(devices[0].toString());

    }

    private static void initForWindows() {
        report("its a windob");
    }

    private static void initForMac() {
        report("its a mac");
        String home = System.getProperty("user.home");
        File logConfig = new File(home,MAC_LOG_CONFIG_PATH);
        boolean logExist = logConfig.exists();

        if(logExist){
            report("log file exist");
        } else createLogConfigForMac(logConfig);
    }

    private static void createLogConfigForMac(File logConfig) {
        boolean fileCreated = false;
        try {
            fileCreated = logConfig.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (fileCreated) {
            WriteLogFile(logConfig);
        } else {
            report("log config file not created");
        }
    }

    private static void WriteLogFile(File logConfig) {
        InputStream stream = Main.class.getResourceAsStream("log.config");

        try {
            OutputStream os = new FileOutputStream(logConfig);
            byte[] buffer = new byte[1024];
            int bytesRead;
            //read from is to buffer
            while ((bytesRead = stream.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            stream.close();
            //flush OutputStream to write any buffered data to file
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            logConfig.deleteOnExit();
        }
    }

    private static void report(String txd){
        System.out.println(txd);
    }
}
