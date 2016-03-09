package co.xinyue.wms.safeguard.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import co.xinyue.wms.safeguard.R;
import co.xinyue.wms.safeguard.util.Constant;

/**
 * Created by wms on 2016/3/4 0004.
 */
public class WelcomePageAdapter extends PagerAdapter {
    private Context context;
    static final private int[] welcomeViewIds = Constant.WELCOMELISTVIEWIDS;
    private List<View> views;
    private LayoutInflater inflater;

    public WelcomePageAdapter(Context context,LinearLayout points) {
        this.context = context;
        views = new ArrayList<>();

        this.inflater = LayoutInflater.from(context);
        for (int i = 0, length = welcomeViewIds.length; i < length; i++) {
            views.add(inflater.inflate(welcomeViewIds[i], null));
            ImageView point=new ImageView(context);
            point.setLayoutParams(new LinearLayout.LayoutParams(-2,-2));
            point.setImageResource(R.drawable.point);
            points.addView(point);
        }
    }

    @Override
    public int getCount() {
        return welcomeViewIds.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    @Override
    public int getItemPosition(Object object) {
        return views.indexOf(object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
