package safe.com.heima.af.fragmentframe.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import safe.com.heima.af.fragmentframe.R;

/**
 * author: AF on 2018/7/2.
 * 995543053@qq.com
 * 电话：15993455475
 * 说明：
 */

public class ThirdFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third_fragment_layout,null);
        return view;
    }
}
