import org.apache.commons.lang3.SystemUtils;

import java.io.File;

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
        }else createLogConfigForMac();
    }

    private static void createLogConfigForMac() {

    }

    private static void report(String txd){
        System.out.println(txd);
    }
}
