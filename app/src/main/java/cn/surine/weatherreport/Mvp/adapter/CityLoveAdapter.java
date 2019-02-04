package cn.surine.weatherreport.Mvp.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.surine.weatherreport.Mvp.Bean.CityLove;
import cn.surine.weatherreport.R;

/**
 * Created by Surine on 2018/12/26.
 */

public class CityLoveAdapter extends BaseQuickAdapter<CityLove,BaseViewHolder> {
    public CityLoveAdapter(int layoutResId, @Nullable List<CityLove> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CityLove item) {
        helper.setText(R.id.textView8,item.getCityName());
        helper.addOnClickListener(R.id.delete);
    }
}
