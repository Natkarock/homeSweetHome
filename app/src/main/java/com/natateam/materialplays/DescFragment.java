package com.natateam.materialplays;

import android.animation.Animator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.InjectView;

/**
 * Created by macbook on 29/01/ 15.
 */
public class DescFragment extends Fragment {
    @InjectView(R.id.overlay)
    RelativeLayout overlayLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_description,null);
        ((ImageView) view.findViewById(R.id.ivProfile)).setTransitionName("profile");
        ((ImageView) view.findViewById(R.id.ivProfile)).setImageDrawable(
                getResources().getDrawable(R.drawable.manul1));
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        overlayLayout=(RelativeLayout)getView().findViewById(R.id.overlay);
        //animateRevealShow(overlayLayout);


    }




    public void animateRevealShow(View viewRoot) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            int cx = 40; //middle of button
            int cy = 140; //middle of button
            int radius = 2000; //hypotenuse to top left
            Animator anim = ViewAnimationUtils.createCircularReveal(viewRoot, 10, 10, 0, radius);
            viewRoot.setVisibility(View.VISIBLE);
            anim.setInterpolator(new DecelerateInterpolator());
            anim.setDuration(1000);
            anim.start();
        }else {
            viewRoot.setVisibility(View.VISIBLE);
        }


    }
}
