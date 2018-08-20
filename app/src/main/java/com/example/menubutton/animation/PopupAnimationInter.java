package com.example.menubutton.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;

import static android.view.View.GONE;

/**
 * 类描述：
 *
 * @author maimanchuang
 * @date 2018/8/18
 */
public class PopupAnimationInter extends AbAnimationInter {


    @Override
    public void closeAnimation(final View view, int index) {
        float valueX = (float) (Math.sin(Math.toRadians(builder.getAngle() * index)) * builder.getRadius());
        float valueY = (float) (Math.cos(Math.toRadians(builder.getAngle() * index)) * builder.getRadius());

        AnimatorSet animatorSet = new AnimatorSet();
        //位移动画
        ObjectAnimator translationYAnimator = ObjectAnimator.ofFloat(view, "translationY", valueY, 0f);
        ObjectAnimator translationXAnimator = ObjectAnimator.ofFloat(view, "translationX", valueX, 0f);
        //透明度动画
        if(builder.isCloseAlpha()){
            ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            animatorSet.playTogether(alphaAnimator);
        }
        //缩小动画
        if(builder.isCloseScale()){
            ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.0f);
            ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.0f);
            animatorSet.playTogether(scaleXAnimator,scaleYAnimator);
        }
        animatorSet.playTogether(translationYAnimator, translationXAnimator);
        animatorSet.setDuration(builder.getCloseTime());
        //加速值器
        animatorSet.setInterpolator(instanceInterpolator(builder.getCloseInterpolator()));
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.setVisibility(GONE);
            }
        });
        animatorSet.start();
    }

    @Override
    public void showAnimation(final View view, int index) {
        float valueX = (float) (Math.sin(Math.toRadians(builder.getAngle() * index)) * builder.getRadius());
        float valueY = (float) (Math.cos(Math.toRadians(builder.getAngle() * index)) * builder.getRadius());
        AnimatorSet animatorSet = new AnimatorSet();
        //位移动画
        ObjectAnimator translationYAnimator = ObjectAnimator.ofFloat(view, "translationY", 0f, valueY);
        ObjectAnimator translationXAnimator = ObjectAnimator.ofFloat(view, "translationX", 0f, valueX);


        //透明度动画
        if(builder.isShowAlpha()){
            ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1f);
            animatorSet.playTogether(alphaAnimator);
        }


        //放大动画
        if(builder.isShowScale()){
            ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(view, "scaleX", 0.0f, 1.0f);
            ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(view, "scaleY", 0.0f, 1.0f);
            animatorSet.playTogether(scaleXAnimator, scaleYAnimator);
        }


        animatorSet.playTogether(translationYAnimator, translationXAnimator);
        animatorSet.setDuration(builder.getCloseTime());
        //回弹插值器
        animatorSet.setInterpolator(instanceInterpolator(builder.getCloseInterpolator()));
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                view.setVisibility(View.VISIBLE);
            }

        });
        animatorSet.start();
    }


}
