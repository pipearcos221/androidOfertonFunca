package unicauca.movil.oferton.attrs;

import android.databinding.BindingAdapter;
import android.net.Uri;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Global {

    @BindingAdapter("app:imgUrl")
    public static void setImage(ImageView img, String url){
        Picasso.with(img.getContext())
                .load(Uri.parse(url))
                .into(img);
    }

}
