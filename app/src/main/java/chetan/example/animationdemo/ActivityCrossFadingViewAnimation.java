package chetan.example.animationdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;


public class ActivityCrossFadingViewAnimation extends AppCompatActivity
{

    ImageView mShowImage;
    ProgressBar mProgressBar;
    int mShortAnimTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_cross_fading_animation );
        mShowImage = ( ImageView )findViewById( R.id.show_image );
        mProgressBar = ( ProgressBar )findViewById( R.id.progress_loading );
        mShowImage.setVisibility( View.GONE );
        mShortAnimTime = 3000;
                //getResources().getInteger( android.R.integer.config_longAnimTime );
    }

    @Override
    protected void onStart() {
        super.onStart();
        CrossFadeAnimation();
    }

    private void CrossFadeAnimation()
    {
        // Set the image view to 0% opacity but visible, so that it is visible
        // (but fully transparent) during the animation.
        mShowImage.setAlpha(0f);
        mShowImage.setVisibility( View.VISIBLE );

        // Animate the content view to 100% opacity, and clear any animation
        // listener set on the view.
        mShowImage.animate()
                  .alpha(1f)
                  .setDuration( mShortAnimTime )
                  .setListener( null );

        // Animate the loading view to 0% opacity. After the animation ends,
        // set its visibility to GONE as an optimization step (it won't
        // participate in layout passes, etc.)
        mProgressBar.animate()
                    .alpha(0f)
                    .setDuration( mShortAnimTime )
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            mProgressBar.setVisibility( View.GONE );
                        }
                    });
    }

}
