package net.simplifiedcoding.androidtablayout.UI_t;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import net.simplifiedcoding.androidtablayout.R;


/**
 * Created by Nicholas on 6/11/2016.
 */
public class PicassoClient_t {
    public static  void downloadImage(final Context c, final String imageUrl, final ImageView img)
    {
        if(imageUrl!=null && imageUrl.length()>0)
        {//trying to cache some things

                        Picasso.with(c).load(imageUrl)
                                .networkPolicy(NetworkPolicy.OFFLINE)
                                 .placeholder(R.mipmap.ic_launcher).
                                into(img, new Callback() {
            @Override
            public void onSuccess() {


            }
                                    @Override
                                    public void onError() {

                                        // Try again online if cache failed
                                        Picasso.with(c)
                                                .load(imageUrl)
                                                .placeholder(R.mipmap.ic_launcher)
                                                .error(R.mipmap.ic_launcher)
                                                .into(img);

                                    }});





/**
            .placeholder(R.mipmap.ic_launcher).into(img);
        }else{
            Picasso.with(c).load(R.mipmap.ic_launcher).into(img);
        }
 **/

                                }
    }
}
