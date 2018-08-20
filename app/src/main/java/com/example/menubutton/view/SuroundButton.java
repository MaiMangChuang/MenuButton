package com.example.menubutton.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.menubutton.R;
import com.example.menubutton.animation.AbAnimationInter;
import com.example.menubutton.animation.PopupAnimationInter;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * 类描述：
 *
 * @author maimanchuang
 * @date 2018/8/18
 */

public class SuroundButton extends RelativeLayout {
    private ArrayList<View> viewArrayList;
    private int size;
    private boolean isShow;
    private View mainView;
    private Context context;
    private AbAnimationInter animation;
    private Builder bundle;
    private int mainIconShow;
    private int mainIconClose;
    private HashMap<String,Drawable> mainIcons;
    String type;

    public SuroundButton(Context context) {
        this(context, null);
    }

    public SuroundButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SuroundButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }


    public void setMainView(View view) {
        mainView = view;
    }

    public static class Builder {
        private float angle = 0;
        private float radius = 550f;
        private int showTime;
        private int closeTime;
        private float maxRain = 360;
        private int mainVeiwHight;
        private int mainVeiwWidth;
        private View mainView;
        private boolean showAlpha;
        private boolean showScale;
        private boolean closeAlpha;
        private boolean closeScale;
        private String showInterpolator;
        private String closeInterpolator;

        public boolean isCloseAlpha() {
            return closeAlpha;
        }

        public Builder setCloseAlpha(boolean closeAlpha) {
            this.closeAlpha = closeAlpha;
            return this;
        }

        public boolean isCloseScale() {
            return closeScale;
        }

        public Builder setCloseScale(boolean closeScale) {
            this.closeScale = closeScale;
            return this;
        }

        public String getShowInterpolator() {
            return showInterpolator;
        }

        public Builder setShowInterpolator(String showInterpolator) {
            this.showInterpolator = showInterpolator;
            return this;
        }

        public String getCloseInterpolator() {
            return closeInterpolator;
        }

        public Builder setCloseInterpolator(String closeInterpolator) {
            this.closeInterpolator = closeInterpolator;
            return this;
        }



        public boolean isShowAlpha() {
            return showAlpha;
        }

        public Builder setShowAlpha(boolean showAlpha) {
            this.showAlpha = showAlpha;
            return this;
        }

        public boolean isShowScale() {
            return showScale;
        }

        public Builder setShowScale(boolean showScale) {
            this.showScale = showScale;
            return this;
        }


        public int getShowTime() {
            return showTime;
        }

        public Builder setShowTime(int showTime) {
            this.showTime = showTime;
            return this;
        }

        public int getCloseTime() {
            return closeTime;

        }

        public Builder setCloseTime(int closeTime) {
            this.closeTime = closeTime;
            return this;
        }

        public float getMaxRain() {
            return maxRain;
        }


        public float getAngle() {
            return angle;
        }

        public float getRadius() {
            return radius;
        }


        public int getMainVeiwHight() {
            return mainVeiwHight;
        }

        public int getMainVeiwWidth() {
            return mainVeiwWidth;
        }

        public View getMainView() {
            return mainView;
        }

        public Builder setAngle(float angle) {
            this.angle = angle;
            return this;
        }

        public Builder setRadius(float radius) {
            this.radius = radius;
            return this;
        }

        public Builder setMaxRain(float maxRain) {
            this.maxRain = this.maxRain;
            return this;
        }

        public Builder setMainVeiwHight(int mainVeiwHight) {
            this.mainVeiwHight = mainVeiwHight;
            return this;
        }

        public Builder setMainVeiwWidth(int mainVeiwWidth) {
            this.mainVeiwWidth = mainVeiwWidth;
            return this;
        }

        public Builder setMainView(View mainView) {
            this.mainView = mainView;
            return this;
        }
    }


    private void init(AttributeSet attrs) {
        context = getContext();
        viewArrayList = new ArrayList<View>();
        mainIcons=new HashMap<>(2);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.SuroundButton);
        int mainVeiwHight = array.getInt(R.styleable.SuroundButton_mainVeiwHight, 55);
        int mainVeiwWidth = array.getInt(R.styleable.SuroundButton_mainVeiwWidth, 55);
        int maxRain = array.getInt(R.styleable.SuroundButton_maxRain, 360);
        int radius = array.getInt(R.styleable.SuroundButton_radius, 550);
        int showTime = array.getInt(R.styleable.SuroundButton_showTime, 2000);
        int closeTime = array.getInt(R.styleable.SuroundButton_closeTime, 400);
         boolean showAlpha=array.getBoolean(R.styleable.SuroundButton_showAlpha,true);
         boolean showScale=array.getBoolean(R.styleable.SuroundButton_showScale,true);
         boolean closeAlpha=array.getBoolean(R.styleable.SuroundButton_closeAlpha,true);
         boolean closeScale=array.getBoolean(R.styleable.SuroundButton_closeScale,true);
         Resources resources = context.getResources();
         String showInterpolator=  resources.getString(array.getResourceId(R.styleable.SuroundButton_showInterpolator,R.string.menuButton_Interpolator_Bounce));
         String closeInterpolator=resources.getString(array.getResourceId(R.styleable.SuroundButton_closeInterpolator,R.string.menuButton_Interpolator_Accelerate));
        type = array.getString(R.styleable.SuroundButton_type);
        mainIconShow = array.getResourceId(R.styleable.SuroundButton_mainIcon_show, R.drawable.menu);
        mainIconClose = array.getResourceId(R.styleable.SuroundButton_mainIcon_close,R.drawable.menu_s);
        array.recycle();
        bundle = new Builder();
        bundle.setMainVeiwHight(mainVeiwHight)
                .setMainVeiwWidth(mainVeiwWidth)
                .setRadius(radius)
                .setMaxRain(maxRain)
                .setCloseTime(closeTime)
                .setShowTime(showTime)
                .setCloseAlpha(closeAlpha)
                .setCloseScale(closeScale)
                .setShowAlpha(showAlpha)
                .setShowScale(showScale)
                .setShowInterpolator(showInterpolator)
                .setCloseInterpolator(closeInterpolator);
        if (mainView == null) {
            initMainVeiw();
        }

    }

    private void initMainVeiw() {
        Resources resources = context.getResources();
        Drawable drawableShow = resources.getDrawable(mainIconShow);
        Drawable drawableClose = resources.getDrawable(mainIconClose);
        mainIcons.put("show",drawableShow);
        mainIcons.put("close",drawableClose);
        mainView = new View(context);
        mainView.setBackground(mainIcons.get("close"));
        mainView.setVisibility(VISIBLE);
        int width = ((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bundle.getMainVeiwWidth(), getResources().getDisplayMetrics()));
        int height = ((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bundle.getMainVeiwHight(), getResources().getDisplayMetrics()));
        LayoutParams lp2 = new LayoutParams(
                width, height);
        lp2.addRule(RelativeLayout.CENTER_IN_PARENT);
        mainView.setLayoutParams(lp2);
        mainView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShow) {
                    for (int i = 0; i < viewArrayList.size(); i++) {
                        closeAnimation(viewArrayList.get(i), i);
                        SuroundButton.this.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
                        SuroundButton.this.getLayoutParams().width = ViewGroup.LayoutParams.WRAP_CONTENT;
                    }
                } else {
                    for (int i = 0; i < viewArrayList.size(); i++) {
                        showAnimation(viewArrayList.get(i), i);
                        SuroundButton.this.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
                        SuroundButton.this.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;

                    }
                }
                isShow = !isShow;
            }
        });
    }

    public void show() {
        for (View view : viewArrayList) {
            showAnimation(view, viewArrayList.indexOf(view));
        }
        isShow = true;
    }

    ;

    public void close() {
        for (View view : viewArrayList) {
            closeAnimation(view, viewArrayList.indexOf(view));
        }
        isShow = false;
    }

    ;

    private AbAnimationInter instanceAnimation(String type, Builder bundle) {
        if (type != null && !"".equals(type)) {
            Class aClass = null;
            try {
                aClass = Class.forName("com.example.studymodel.myview." + type);
                AbAnimationInter animation = (AbAnimationInter) aClass.newInstance();
                animation.setBuilder(bundle);
                return animation;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        AbAnimationInter animation = new PopupAnimationInter();
        animation.setBuilder(bundle);
        return animation;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        size = getChildCount();
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
            view.setLayoutParams(layoutParams);
            view.setVisibility(GONE);
            viewArrayList.add(view);
        }
        this.addView(mainView);
        bundle.setAngle(bundle.getMaxRain() / size);
        animation = instanceAnimation(type, bundle);
    }


    private void closeAnimation(final View view, int index) {
        animation.closeAnimation(view, index);
    }

    private void showAnimation(final View view, int index) {
        animation.showAnimation(view, index);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
