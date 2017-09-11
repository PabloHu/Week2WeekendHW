package com.example.admin.week2weekendhw;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    Intent detailsIntent;
    PendingIntent pendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


    }

    public void navigationClicks(View view) {
switch (view.getId()){
    case R.id.btnListView:
        detailsIntent = new Intent(this, ListViewActivity.class);
        pendingIntent =
                TaskStackBuilder.create(this)
                        .addNextIntentWithParentStack(detailsIntent)
                        .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        startActivity(detailsIntent);
    break;


    case R.id.btnListViewAdv:
        detailsIntent = new Intent(this, ListViewAdvActivity.class);
        pendingIntent =
                TaskStackBuilder.create(this)
                        .addNextIntentWithParentStack(detailsIntent)
                        .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        startActivity(detailsIntent);
        break;

    case R.id.btnDialogFragment:
        detailsIntent = new Intent(this, DialogFragmentActivity.class);
        pendingIntent =
                TaskStackBuilder.create(this)
                        .addNextIntentWithParentStack(detailsIntent)
                        .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        startActivity(detailsIntent);
        break;

}

    }
}
