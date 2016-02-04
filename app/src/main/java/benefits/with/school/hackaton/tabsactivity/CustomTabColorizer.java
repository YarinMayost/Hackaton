package benefits.with.school.hackaton.tabsactivity;

import benefits.with.school.hackaton.tabsactivity.lib.SlidingTabLayout;

public class CustomTabColorizer implements SlidingTabLayout.TabColorizer
{
    private int color;

    public CustomTabColorizer(int _color)
    {
        this.color = _color;
    }

    @Override
    public int getIndicatorColor(int position)
    {
        return this.color;
    }
}
