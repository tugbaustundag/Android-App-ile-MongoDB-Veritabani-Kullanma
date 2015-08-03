package com.tugbaust.android_mongodb;


public class QueryBuilder {

    /**
     * Veritabanı ismini yazmamız gereken metod
     * @return
     */
    public String getDatabaseName() {
        return "android";
    }

    /**
     * Makalede bahsetiğim MongoLab API key bilgisini yazdım
     * @return
     */
    public String getApiKey() {
        return "hN7GbzUIE2jbjPjP6PZPoYycBdwcDjLu";
    }

    /**
     * Veritabanındaki collections ve documents ile ilgili işlemler yapabilmemiz icn mongolab'da bulunan veritabanımıza
     * baglanmayı saglayan temel  URL hazırladım
     * @return
     */
    public String getBaseUrl()
    {
        return "https://api.mongolab.com/api/1/databases/"+getDatabaseName()+"/collections/";
    }

    /**
     * Hazırlanan BaseUrl'ye MongoLab API key ekledim
     * @return
     */
    public String docApiKeyUrl()
    {
        return "?apiKey="+getApiKey();
    }

    /**
     * collections ismini yazmamız gereken metod
     * @return
     */
    public String documentRequest()
    {
        return "kullanici";
    }

    /**
     * mongolab'da bulunan veritabanımıza baglanmayı saglayan URL tamamını hazırlayan metod
     * @return
     */
    public String buildContactsSaveURL()
    {
        return getBaseUrl()+documentRequest()+docApiKeyUrl();
    }

    /**
     * Android arayüzden alınan bilgilerin, veritabanımızda collections' a eklenecek documents formatlarını belirledim
     * @return
     */
    public String createContact(MyContact contact)
    {
        return String
                .format("{\"document\"  : {\"first_name\": \"%s\", "
                                + "\"last_name\": \"%s\", \"email\": \"%s\", "
                                + "\"phone\": \"%s\"}, \"safe\" : true}",
                        contact.first_name, contact.last_name, contact.email, contact.phone);
    }



}
