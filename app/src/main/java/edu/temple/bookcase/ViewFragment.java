package edu.temple.bookcase;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class ViewFragment extends Fragment {
    ViewPager mPager;
    PagerAdapter pagerAdapter;

    public ViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);
        mPager = view.findViewById(R.id.pager);
        // Instantiate a ViewPager and a PagerAdapter.
        pagerAdapter = new BookDetailsPagerAdapter(getChildFragmentManager());
        mPager.setAdapter(pagerAdapter);
        return view;
    }

    private class BookDetailsPagerAdapter extends FragmentStatePagerAdapter {
        BookDetailsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        // Returns BookDetailsFragment to display for the specific book currently swiped to in the ViewPager
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    return BookDetailsFragment.newInstance(getResources().getStringArray(R.array.books)[position]);
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return getResources().getStringArray(R.array.books).length;
        }
    }

}
