package co.xinyue.wms.safeguard.listener;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import co.xinyue.wms.safeguard.R;
import co.xinyue.wms.safeguard.activity.SplashActivity;
import co.xinyue.wms.safeguard.activity.WelcomeActivity;
import co.xinyue.wms.safeguard.util.Constant;

/**
 * Created by wms on 2016/3/4 0004.
 */
public class ViewPageChangeListener implements ViewPager.OnPageChangeListener{
    private Context context;
    private TextView tv_pagerstate;
    private LinearLayout points;
    private int lastPoint;
    private int preState;
    public ViewPageChangeListener(Context context,TextView tv_pagerstate,LinearLayout points) {
        this.context = context;
        this.tv_pagerstate=tv_pagerstate;
        this.points=points;
        lastPoint=0;
        preState=0;
        ((ImageView) points.getChildAt(lastPoint)).setImageResource(R.drawable.point_red);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//        Toast.makeText(context,"onPageScrolled:"+"position:"+position+";positionOffset:"+positionOffset+";positionOffsetPixels:"+positionOffsetPixels,Toast.LENGTH_SHORT).show();
//        tv_pagerstate.setText("onPageScrolled:\n"+"position:"+position+"\npositionOffset:"+positionOffset+"\npositionOffsetPixels:"+positionOffsetPixels);
    }

    @Override
    public void onPageSelected(int position) {
//        Toast.makeText(context,"onPageSelected:"+"position:"+position,Toast.LENGTH_SHORT).show();
        ((ImageView) points.getChildAt(lastPoint)).setImageResource(R.drawable.point);
        ((ImageView) points.getChildAt(position)).setImageResource(R.drawable.point_red);
        lastPoint=position;
//        tv_pagerstate.setText("onPageSelected:"+"position:"+position);
    }

    /**
     *
     * @param state
     */
    @Override
    public void onPageScrollStateChanged(int state) {
        //0表示没有滑动，1表示正在用手滑动，2表示滑动到一半松手后的自动复位
//        Toast.makeText(context,"onPageScrollStateChanged:"+"state:"+state,Toast.LENGTH_SHORT).show();
//        tv_pagerstate.setText("onPageScrollStateChanged:"+"\nstate:"+state+"\npreState:"+preState+"\nlastPoint:"+lastPoint);
        if(preState==1&&state==0){
            if(lastPoint==(points.getChildCount()-1)){
                Intent intent=new Intent(context, SplashActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
                context.getSharedPreferences(Constant.SHARED_PREFERENCE,Context.MODE_PRIVATE).edit().putBoolean(Constant.SHOWSTARTPAGE,false).commit();
            }
        }
        preState=state;
    }
}
