package com.example.admin.week2weekendhw;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
public class DialogFragmentActivity extends Activity implements MyDialogFragment.UserNameListener {

    public static final String TAG = "DIALOGTAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fragment);
    }
    @Override
    public void onFinishUserDialog(String user) {
        Toast.makeText(this, "Hello, " + user, Toast.LENGTH_SHORT).show();
    }

    public void onClicking(View view) {
        // close existing dialog fragments
        FragmentManager manager = getFragmentManager();
        Fragment frag = manager.findFragmentByTag("fragment_edit_name");
        if (frag != null) {
            manager.beginTransaction().remove(frag).commit();
        }
        switch (view.getId()) {
            case R.id.showCustomFragment:
                final MyDialogFragment editNameDialog = new MyDialogFragment();
                editNameDialog.show(manager, "fragment_edit_name");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {

                        editNameDialog.dismiss();
                    }


                }, 3000);
                break;

            case R.id.showDefaultDialog:

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        this);


                alertDialogBuilder.setTitle("Your Title");

                alertDialogBuilder
                        .setMessage("Click yes to exit!")
                        .setCancelable(false)

                        .setNegativeButton("Exit",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {

                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
                break;

            case R.id.showCustomDialog:
                // custom dialog
                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.custom);
                dialog.setTitle("Title...");



                TextView text = (TextView) dialog.findViewById(R.id.text);
                text.setText("Android custom dialog example!");
                ImageView image = (ImageView) dialog.findViewById(R.id.image);
                image.setImageResource(R.drawable.boa_icon);

                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);

                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();



                break;

            case R.id.showListOptionsDialog:
                String[] animals = getResources().getStringArray(R.array.animalsSelection);

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Select");
                builder.setItems(animals, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {

                    }
                });
                AlertDialog alert = builder.create();
                alert.show();

break;

            case R.id.addNotification:
                Intent intent = new Intent(this, HomeActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);


                Notification noti = new Notification.Builder(this)
                        .setContentTitle("New mail from " + "test@gmail.com")
                        .setContentText("Subject").setSmallIcon(R.drawable.boa_icon)
                        .setContentIntent(pIntent)
                        .addAction(R.drawable.boa_icon, "Call", pIntent)
                        .addAction(R.drawable.heart, "More", pIntent)
                        .addAction(R.drawable.heart, "And more", pIntent).build();
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                noti.flags |= Notification.FLAG_AUTO_CANCEL;

                notificationManager.notify(0, noti);


                break;

            case R.id.sendMessage:
                SmsManager smsManager = SmsManager.getDefault();
            try {
                smsManager.sendTextMessage("8134516294", null, "yellow", null, null);
            }
            catch (Exception e){
                Log.d(TAG, "onClicking err: " + e.toString());
            }
                break;

        }
    }

}