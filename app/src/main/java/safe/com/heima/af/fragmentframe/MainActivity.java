package safe.com.heima.af.fragmentframe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import safe.com.heima.af.fragmentframe.util.FragmentFactory;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private RadioGroup group;
    private RadioButton bt1;
    private RadioButton bt2;
    private RadioButton bt3;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private FragmentFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        group = (RadioGroup) findViewById(R.id.rg);
        bt1 = findViewById(R.id.rb1);
        bt2 = findViewById(R.id.rb2);
        bt3 = findViewById(R.id.rb3);
        bt1.setChecked(true);

        factory = FragmentFactory.getInstance();

        //Fragment提交需要
        manager = getSupportFragmentManager();

        getFragment("first");


        //选择监听
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                setFragmentSlected(checkedId);
            }
        });
    }

    /*设置Fragment选中*/
    private void setFragmentSlected(int checkedId) {
        switch (checkedId){
            case R.id.rb1:
                getFragment("first");
                break;
            case R.id.rb2:
                getFragment("second");
                break;
            case R.id.rb3:
                getFragment("third");
                break;
        }
    }

    private Fragment currentFragment = null;
    private void getFragment(String fragmentTag) {
        transaction = manager.beginTransaction();
        Fragment fragment = factory.getFragment(fragmentTag);
        if(fragment.isAdded()){
            //添加过
            if(currentFragment != null){
                transaction.hide(currentFragment).show(fragment);
            }

        }else {
            //没添加过
            if(currentFragment != null){
                transaction.hide(currentFragment).add(R.id.container,fragment);
            }else {
                transaction.add(R.id.container,fragment);
            }
        }
        currentFragment = fragment;
        transaction.commit();
    }


}
