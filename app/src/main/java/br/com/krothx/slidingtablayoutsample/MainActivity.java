package br.com.krothx.slidingtablayoutsample;

import android.graphics.Color;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import br.com.krothx.slidingtablayoutsample.adapters.TabsAdapter;
import br.com.krothx.slidingtablayoutsample.extras.SlidingTabLayout;
import br.com.krothx.slidingtablayoutsample.fragments.FragmentDois;
import br.com.krothx.slidingtablayoutsample.fragments.FragmentTres;
import br.com.krothx.slidingtablayoutsample.fragments.FragmentUm;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Inicializa ViewPager e carrega as tabs
        initViewPager();
    }

    private void initViewPager() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        if (viewPager != null) {
            setupViewPager(viewPager);
        }

        SlidingTabLayout tabLayout = (SlidingTabLayout) findViewById(R.id.tabs);
        //noinspection ConstantConditions
        tabLayout.setSelectedIndicatorColors(Color.WHITE);
        tabLayout.setTextColorResId(R.color.tabs_text_color);
        tabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener()  {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                Log.i(TAG, "Tab #" + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        tabLayout.setViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        TabsAdapter adapter = new TabsAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentUm(), "PRIMEIRO");
        adapter.addFragment(new FragmentDois(), "SEGUNDO");
        adapter.addFragment(new FragmentTres(), "TERCEIRO");
        viewPager.setAdapter(adapter);
    }
}
