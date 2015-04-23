# AdSanjal 
AdSanjal is a mobile networking platform that is aimed at helping advertiser promote their business via mobile apps. With the increase in android and ios users in Nepal, there are various apps being built in Nepal. The advantage with advertising with mobile apps is that you can get your ads directly visible to the end users. 

#Implementing AdSanjal SDK
Implementation of AdSanjal SDK is very easy.
#####Download
 - Download AdSanjal SDK library for Eclipse from [here](https://github.com/AdSanjal/AdSanjal/blob/master/downloads/AdSanjalLib_1.0.zip?raw=true).
  
 **or**
 
 - Download AdSanjal SDK library for Android Studio (.aar) from [here](https://github.com/AdSanjal/AdSanjal/blob/master/downloads/adSanjalLibrary-release_1.0.aar?raw=true).

#####Write Code
 - Include the following code : 
````
<com.adsanjal.AdView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        ads:app_id="<my_app_id>" />
````
 **or** 
````
	LinearLayout adWrapper = (LinearLayout) findViewById(R.id.ad_wrapper);
	AdView adView = new AdView(getApplicationContext(), <my_app_id>);
	adWrapper.addView(adView);
````
 - Thats it!  :D
  
Note :- You must create an Application to get **app_id** from [AdSanjal dashboard](https://adsanjal.com/admin).

Sample apk : [AdSanjal Sample](https://github.com/AdSanjal/AdSanjal/blob/master/downloads/AdSanjal_Sample_1.0.apk?raw=true).

**Create campaign and promote your business via AdSanjal Network.**

For more info check https://adsanjal.com
