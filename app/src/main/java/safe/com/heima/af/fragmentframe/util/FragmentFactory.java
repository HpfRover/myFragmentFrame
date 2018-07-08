package safe.com.heima.af.fragmentframe.util;

import android.support.v4.app.Fragment;

import java.util.HashMap;
import java.util.Map;

import safe.com.heima.af.fragmentframe.fragment.FirstFragment;
import safe.com.heima.af.fragmentframe.fragment.SecondFragment;
import safe.com.heima.af.fragmentframe.fragment.ThirdFragment;

/**
 * author: AF on 2018/7/2.
 * 995543053@qq.com
 * 电话：15993455475
 * 说明：用于创建Fragment并存储
 */

public class FragmentFactory {


    private FragmentFactory(){}

    public static FragmentFactory getInstance(){
        return FragmentHolder.factory;
    }

    private static class FragmentHolder{
        private static FragmentFactory factory = new FragmentFactory();
    }

    public Map<String,Fragment> fragmentMap = null;

    public Fragment getFragment(String tag){
        Fragment fragment = null;

        if(fragmentMap == null){
            fragmentMap = new HashMap<>();
        }

        if(fragmentMap.get(tag) == null){
            if(tag.equals("first")){
                fragment = new FirstFragment();
            }else if(tag.equals("second")){
                fragment = new SecondFragment();
            }else if(tag.equals("third")){
                fragment = new ThirdFragment();
            }
            fragmentMap.put(tag,fragment);
        }else {
           fragment = fragmentMap.get(tag);
        }

        return fragment;
    }
}
