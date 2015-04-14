package hdnf39.edu.umkc.homeworkreminder.service;

import android.content.ServiceConnection;


import java.util.Calendar;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import hdnf39.edu.umkc.homeworkreminder.service.ScheduleService;

public class ScheduleClient {

    // The hook into our service
    private ScheduleService mBoundService;
    // The context to start the service in
    private Context mContext;
    // A flag if we are connected to the service or not
    private boolean mIsBound;

    public ScheduleClient(Context context) {
        mContext = context;
    }

    /**
     * Call this to connect your activity to your service
     */
    public void doBindService() {
        // Establish a connection with our service
        mContext.bindService(new Intent(mContext, ScheduleService.class), mConnection, Context.BIND_AUTO_CREATE);
        mIsBound = true;
        System.out.println("doBindSevice");
    }

    /**
     * When you attempt to connect to the service, this connection will be called with the result.
     * If we have successfully connected we instantiate our service object so that we can call methods on it.
     */
       private ServiceConnection mConnection = new ServiceConnection() {
                //Binding service could cause ExceptionInInitializerError
                //This is where that might throw excepttion
                public void onServiceConnected(ComponentName className, IBinder service) throws ExceptionInInitializerError{
                    // This is called when the connection with our service has been established,
                    // giving us the service object we can use to interact with our service.
                    mBoundService = ((ScheduleService.ServiceBinder) service).getService();
                    System.out.println("doBindSevice connected");
                }
                public void onServiceDisconnected(ComponentName className) {
                    mBoundService = null;
                }
            };

    /**
     * Tell our service to set an alarm for the given date
     * @param c a date to set the notification for
     */
    public void setAlarmForNotification(Calendar c){
        mBoundService.setAlarm(c);
    }

    /**
     * When you have finished with the service call this method to stop it
     * releasing your connection and resources
     */
    public void doUnbindService() {
        if (mIsBound) {
            // Detach our existing connection.
            try {
                mContext.unbindService(mConnection);
                mIsBound = false;
            }
            //If binding service is failed
            //Catch ExceptionInInitializerError and print the message
            catch (ExceptionInInitializerError e){
                System.out.println("Unable to bind service");
            }
        }
    }
}