package cise.cisev02;

/**
 * Created by Dylan on 11/24/2015.
 */

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;

public class ProfileFragment extends Fragment {
    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // If activity recreated (such as from screen rotate), restore
        // the previous article selection set by onSaveInstanceState().
        // This is primarily necessary when in the two-pane layout.
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.profile, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the article text.
        Bundle args = getArguments();
        if (args != null) {
            // Set article based on argument passed in
            updateArticleView(args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1) {
            // Set article based on saved instance state defined during onCreateView
            updateArticleView(mCurrentPosition);
        }
    }

    public void updateArticleView(int position) {

        /** Leaving all of this for an example of taking a parameter to alter an element inside
         * the fragment. Was initially used to decide the image when everything was on one fragment.
         * This is why NavDrawer passes position into the function. Odds are, that will be taken out
         * of NavDrawer. */


        //TextView article = (TextView) getActivity().findViewById(R.id.profile_text);
        //article.setText(Content.Articles[position]);
//        if(position==0) {
//            //Set profile page code here
//            ImageView image = (ImageView) getActivity().findViewById(R.id.batman);
//            image.setImageResource(R.drawable.man);
//        }else if(position==1){
//            //Set workouts page code here
//            ImageView image = (ImageView) getActivity().findViewById(R.id.batman);
//            image.setImageResource(R.drawable.ic_menu_workout);


        mCurrentPosition = position;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current article selection in case we need to recreate the fragment
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }
}