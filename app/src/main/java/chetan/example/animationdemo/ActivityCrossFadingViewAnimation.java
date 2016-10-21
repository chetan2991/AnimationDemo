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
        mShortAnimTime = getResources().getInteger( android.R.integer.config_mediumAnimTime );
    }

    private void CrossFadeAnimation()
    {
        mShowImage.setAlpha(0f);
        mShowImage.setVisibility( View.VISIBLE );

        mShowImage.animate()
                  .alpha(1f)
                  .setDuration( mShortAnimTime )
                  .setListener( null );

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
