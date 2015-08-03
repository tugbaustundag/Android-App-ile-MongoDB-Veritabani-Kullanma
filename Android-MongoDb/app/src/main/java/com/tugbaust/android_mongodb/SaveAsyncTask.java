package com.tugbaust.android_mongodb;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import android.os.AsyncTask;
import android.util.Log;

public class SaveAsyncTask extends AsyncTask<MyContact, Void, Boolean> {

    @Override
    protected Boolean doInBackground(MyContact... arg0) {
        try
        {
            //Mmngolab da bulunan veritabanımıza qb.buildContactsSaveURL() ile baglanıp, createContact metodunda hazırladıgımız
            //document formatını sunucuya post ettik bölelikle sunucuya veritabanı kayıtları yapılmış oldu
            MyContact contact = arg0[0];

            QueryBuilder qb = new QueryBuilder();

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost request = new HttpPost(qb.buildContactsSaveURL());

            StringEntity params =new StringEntity(qb.createContact(contact));
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);

            if(response.getStatusLine().getStatusCode()<205)
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {

            String val = e.getMessage();
           // Log.w("val",val);
            return false;
        }
    }

}
