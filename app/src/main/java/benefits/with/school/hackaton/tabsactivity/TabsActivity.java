package benefits.with.school.hackaton.tabsactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;


import benefits.with.school.hackaton.tabsactivity.lib.SlidingTabLayout;
import benefits.with.school.hackaton.tabsactivity.lib.ViewPagerAdapter;

/**
 * Activity interface to take care of tabs. <br>
 * Makes tab control easier.
 * @author Tomer Gandler
 */
public abstract class TabsActivity extends AppCompatActivity
{
    private ViewPager pager;
    private ViewPagerAdapter adapter;
    private SlidingTabLayout tabs;
    private CustomOnPageChangeListener onPageChangeListener;
    private int[] tabMenus;
    private int currentTabIndex;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    /**
     * Should be called in <b>onCreate</b> to initialize tab setup.
     * @param _titles An array of wanted tab display titles.
     * @param _pager ViewPager for the tabs.
     * @param _tabsLayout SlidingTabLayout for the tabs.
     */
    public final void tabsActivityInit(CharSequence[] _titles, ViewPager _pager, SlidingTabLayout _tabsLayout)
    {
        this.tabMenus = null;
        this.currentTabIndex = 0;
        this.adapter = new ViewPagerAdapter(this, getSupportFragmentManager(), _titles, _titles.length);
        this.pager = _pager;
        this.pager.setAdapter(this.adapter);
        this.tabs = _tabsLayout;
        this.tabs.setDistributeEvenly(true);
        int color = getResources().getColor(android.R.color.white);
        this.tabs.setCustomTabColorizer(new CustomTabColorizer(color));
        this.tabs.setViewPager(this.pager);
        this.onPageChangeListener = new CustomOnPageChangeListener(this);
        this.pager.addOnPageChangeListener(this.onPageChangeListener);
        this.onTabChanged(this.currentTabIndex);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        super.onPrepareOptionsMenu(menu);

        if (this.tabMenus != null)
        {
            menu.clear();
            getMenuInflater().inflate(this.tabMenus[getCurrentTabIndex()], menu);
        }

        return true;
    }

    /**
     * <i>Optional</i> - if called, sets up a unique menu for each tab.
     * @param menus Array of menu resIDs. One for each tab, in the same order.
     */
    public final void setTabMenus(int[] menus)
    {
        this.tabMenus = menus;
    }

    /**
     * @return The current displayed tab index.
     */
    public final int getCurrentTabIndex()
    {
        return this.currentTabIndex;
    }

    /**
     * Scrolls to the tab in the given index position.
     */
    public final void goToTab(int index)
    {
        this.pager.setCurrentItem(index);
    }

    /**
     * Called when the displayed tab is changed.
     * @param position New current tab.
     */
    public void onTabChanged(int position)
    {
        this.currentTabIndex = position;
        if (this.tabMenus != null)
            invalidateOptionsMenu();
    }

    /**
     * When called by the tab manager, should return a Fragment instance of the tab to be displayed for this index.
     * @param position the index of the tab requested.
     * @return an instance of a Fragment tab the meets the position parameter
     */
    public abstract Fragment getTab(int position);
}
