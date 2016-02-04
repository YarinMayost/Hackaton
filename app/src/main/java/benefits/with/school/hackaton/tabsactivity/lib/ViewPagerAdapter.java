package benefits.with.school.hackaton.tabsactivity.lib;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import benefits.with.school.hackaton.tabsactivity.TabsActivity;


public class ViewPagerAdapter extends FragmentStatePagerAdapter
{
    private TabsActivity activity;
    private CharSequence titles[];
    private int tabCount;

    public ViewPagerAdapter(TabsActivity _activity, FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb)
    {
        super(fm);
        this.activity = _activity;
        this.titles = mTitles;
        this.tabCount = mNumbOfTabsumb;
    }

    @Override
    public Fragment getItem(int position)
    {
        return this.activity.getTab(position);
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return titles[position];
    }

    @Override
    public int getCount()
    {
        return tabCount;
    }
}
