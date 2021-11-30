
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.investmentmanagement.GuideFragment;
import com.example.investmentmanagement.InvestmentFragment;
import com.example.investmentmanagement.R;
import com.example.investmentmanagement.SettingsFragment;
import com.example.investmentmanagement.TransactionsFragment;
import com.google.android.material.navigation.NavigationView;

public class MainPage extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav=findViewById(R.id.navmenu);
        drawerLayout=findViewById(R.id.drawer);

        toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new InvestmentFragment()).commit();
        nav.setCheckedItem(R.id.investment_fragment);

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            Fragment temp;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.investment_fragment:
                        temp=new InvestmentFragment();

                        break;
                    case R.id.transactions_fragment:
                        temp=new TransactionsFragment();
                        break;
                    case R.id.guide_fragment:
                        temp=new GuideFragment();
                        break;
                    case R.id.setting_fragment:
                        temp= new SettingsFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container,temp).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}