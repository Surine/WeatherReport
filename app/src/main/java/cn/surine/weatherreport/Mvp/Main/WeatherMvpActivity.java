package cn.surine.weatherreport.Mvp.Main;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;

import org.litepal.LitePalApplication;
import org.litepal.crud.DataSupport;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.surine.weatherreport.Data.Data;
import cn.surine.weatherreport.Mvp.Bean.CityLove;
import cn.surine.weatherreport.Mvp.Bean.Forecast;
import cn.surine.weatherreport.Mvp.Bean.WeatherBean;
import cn.surine.weatherreport.Mvp.adapter.CityLoveAdapter;
import cn.surine.weatherreport.Mvp.adapter.WeatherListAdapter;
import cn.surine.weatherreport.Mvp.base.BaseMvpActivity;
import cn.surine.weatherreport.R;

/**
 * Created by Surine on 2018/9/2.
 */

public class WeatherMvpActivity extends BaseMvpActivity implements WeatherView<WeatherBean> {


    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.textView2)
    TextView textView2;

    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.type)
    TextView typer;
    @BindView(R.id.rec)
    RecyclerView rec;

    BottomSheetDialog bottomSheetDialog;
    @BindView(R.id.star)
    ImageView star;
    @BindView(R.id.backImage)
    ImageView backImage;

    private WeatherPresenter mPresenter;
    private String TAG = this.getClass().getName();
    private WeatherListAdapter weatherListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LitePalApplication.initialize(this);
        mPresenter = new WeatherPresenter(this);
        //绑定view
        mPresenter.attachView(this);


        Glide.with(this).load(Data.API_PIC).into(backImage);

        final String c = "天津";
        getWeatherInfo(c);

        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<CityLove> cityLoves = DataSupport.findAll(CityLove.class);
                Boolean test = false;
                for (CityLove c : cityLoves) {
                    if (c.getCityName().equals(textView.getText().toString())) {
                        test = true;
                        break;
                    }
                }
                if (test) {
                    Toast.makeText(WeatherMvpActivity.this, "您已收藏", Toast.LENGTH_SHORT).show();
                } else {
                    CityLove cityLove = new CityLove();
                    cityLove.setCityName(textView.getText().toString());
                    cityLove.save();
                    Toast.makeText(WeatherMvpActivity.this, "收藏成功！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getWeatherInfo(String c) {
        mPresenter.getWeatherInfo(c);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑
        mPresenter.detachView();
    }

    @Override
    public void showData(final WeatherBean data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    textView.setText(data.getCity());
                    textView2.setText(data.getWendu() + "°C");
                    configIcon(data.getForecast().get(0).getType());
                    configList(data.getForecast());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void configList(List<Forecast> forecast) {
        weatherListAdapter = new WeatherListAdapter(R.layout.item_weather, forecast);
        rec.setLayoutManager(new LinearLayoutManager(WeatherMvpActivity.this));
        rec.setAdapter(weatherListAdapter);
    }

    private void configIcon(String type) {
        typer.setText(type);
    }

    @OnClick(R.id.imageView2)
    public void onViewClicked() {
        bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.dialog_city);
        bottomSheetDialog.show();
        final EditText editText = bottomSheetDialog.findViewById(R.id.input);
        Button button = bottomSheetDialog.findViewById(R.id.get);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().equals("")) {
                    getWeatherInfo(editText.getText().toString());
                    bottomSheetDialog.dismiss();
                }
            }
        });
        final RecyclerView recyclerView = bottomSheetDialog.findViewById(R.id.loveRec);
        final Button b3 = bottomSheetDialog.findViewById(R.id.button3);
        final Button b4 = bottomSheetDialog.findViewById(R.id.button4);
        final Button b5 = bottomSheetDialog.findViewById(R.id.button5);
        final Button b6 = bottomSheetDialog.findViewById(R.id.button6);
        final Button b7 = bottomSheetDialog.findViewById(R.id.button7);
        final Button b8 = bottomSheetDialog.findViewById(R.id.button8);
        final Button b9 = bottomSheetDialog.findViewById(R.id.button9);
        final Button b10 = bottomSheetDialog.findViewById(R.id.button10);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWeatherInfo(b3.getText().toString());
                bottomSheetDialog.dismiss();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWeatherInfo(b4.getText().toString());
                bottomSheetDialog.dismiss();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWeatherInfo(b5.getText().toString());
                bottomSheetDialog.dismiss();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWeatherInfo(b6.getText().toString());
                bottomSheetDialog.dismiss();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWeatherInfo(b7.getText().toString());
                bottomSheetDialog.dismiss();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWeatherInfo(b8.getText().toString());
                bottomSheetDialog.dismiss();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWeatherInfo(b9.getText().toString());
                bottomSheetDialog.dismiss();
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWeatherInfo(b10.getText().toString());
                bottomSheetDialog.dismiss();
            }
        });
        CityLoveAdapter cityLoveAdapter = new CityLoveAdapter(R.layout.item_city, DataSupport.findAll(CityLove.class));
        recyclerView.setLayoutManager(new LinearLayoutManager(WeatherMvpActivity.this));
        recyclerView.setAdapter(cityLoveAdapter);
        cityLoveAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                getWeatherInfo(DataSupport.findAll(CityLove.class).get(position).getCityName());
                bottomSheetDialog.dismiss();
            }
        });
        cityLoveAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                List<CityLove> cityLoves = DataSupport.findAll(CityLove.class);
                if (view == adapter.getViewByPosition(recyclerView,position,R.id.delete)) {
                    int id = cityLoves.get(position).getId();
                    DataSupport.delete(CityLove.class, id);
                    Toast.makeText(WeatherMvpActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                    bottomSheetDialog.dismiss();
                    getWeatherInfo(DataSupport.findLast(CityLove.class).getCityName());
                }
            }
        });
    }


}
