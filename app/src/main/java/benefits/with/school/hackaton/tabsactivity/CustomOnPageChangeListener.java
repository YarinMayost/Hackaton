package benefits.with.school.hackaton.tabsactivity;

import android.support.v4.view.ViewPager;

public class CustomOnPageChangeListener implements ViewPager.OnPageChangeListener
{
    private TabsActivity activity;

    public CustomOnPageChangeListener(TabsActivity _activity)
    {
        this.activity = _activity;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
    {

    }

    @Override
    public void onPageSelected(int position)
    {
        this.activity.onTabChanged(position);
    }

    @Override
    public void onPageScrollStateChanged(int state)
    {

    }
}
