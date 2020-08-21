package com.example.votingapp;

import android.app.PendingIntent;
import android.content.Intent;

import androidx.media.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class Notification extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        shownNotification(remoteMessage.getNotification().getBody());

    }
    public void shownNotification(String message)
    {
        PendingIntent pendingInten= PendingIntent.getActivity(this,0,new Intent(this,Nevigation.class),0);
    //  Notification notification=new NotificationCompat.Builder(this)

    }
}
