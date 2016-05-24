package cm.my.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.my.view.CarouselFigureView;
import com.my.view.switchanimotion.DepthPageTransformer;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CarouselFigureView carouselFigureView;

    private Button add_url;
    private Button remove_url;
    private Button show_point;
    private Button dismiss_point;
    private Button start_autoplay;
    private Button close_autoplay;
    private Button start_loop;
    private Button close_loop;


    private ArrayList<String> url = new ArrayList<>();
    private ArrayList<Integer> resourceList =new ArrayList<>();

    /*
    http://o.ypgimg.com/content/2016/5/16/3b61698c-cf8b-4abe-9c39-d474b454d790.jpg
    http://o.ypgimg.com/content/2016/5/16/88d50d38-09fb-4d3e-bd0c-fc52e2a26c74.jpg
    http://o.ypgimg.com/content/2016/5/16/e5a7b0e3-1a21-4e66-adc8-17a1b7c1a92f.jpg
    http://o.ypgimg.com/content/2016/5/16/8bae5357-d542-4e52-ad5f-ad7d021fc163.jpg
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carouselFigureView = (CarouselFigureView) findViewById(R.id.carousel_figure_view);
        add_url = (Button) findViewById(R.id.add_url);
        remove_url = (Button) findViewById(R.id.remove_url);
        dismiss_point = (Button) findViewById(R.id.dismiss_point);
        show_point = (Button) findViewById(R.id.show_point);
        start_autoplay = (Button) findViewById(R.id.start_autoplay);
        close_autoplay = (Button) findViewById(R.id.close_autoplay);
        start_loop = (Button) findViewById(R.id.start_loop);
        close_loop = (Button) findViewById(R.id.close_loop);
        add_url.setOnClickListener(this);
        remove_url.setOnClickListener(this);
        dismiss_point.setOnClickListener(this);
        show_point.setOnClickListener(this);
        start_autoplay.setOnClickListener(this);
        close_autoplay.setOnClickListener(this);
        start_loop.setOnClickListener(this);
        close_loop.setOnClickListener(this);

        url.add("http://o.ypgimg.com/content/2016/5/16/3b61698c-cf8b-4abe-9c39-d474b454d790.jpg");
//        url.add("http://o.ypgimg.com/content/2016/5/16/88d50d38-09fb-4d3e-bd0c-fc52e2a26c74.jpg");
//        url.add("http://o.ypgimg.com/content/2016/5/16/e5a7b0e3-1a21-4e66-adc8-17a1b7c1a92f.jpg");
        url.add("http://o.ypgimg.com/content/2016/5/16/8bae5357-d542-4e52-ad5f-ad7d021fc163.jpg");

        resourceList.add(R.drawable.aaa);
        resourceList.add(R.mipmap.ic_launcher);
        resourceList.add(R.mipmap.img_empty);
//
        carouselFigureView.setURL(url);
//        carouselFigureView.setResourceList(resourceList);
        carouselFigureView.setViewPagerSwitchStyle(new DepthPageTransformer());
        carouselFigureView.setViewPagerSwitchSpeed(200);
        carouselFigureView.setCarouselFigureItemClickListener(new CarouselFigureView.CarouselFigureItemClickListener() {
            @Override
            public void onClick(View view, int position) {

                Log.i("mengyuan","position:::"+position);
            }
        });

    }

    private void updateState(){
        if(url.size() <= 1){
            carouselFigureView.setIndicationPointState(false);
            carouselFigureView.setAutoPlayState(false);
            carouselFigureView.setInfiniteLoopState(false);
        }else{
            carouselFigureView.setIndicationPointState(true);
            carouselFigureView.setAutoPlayState(true);
            carouselFigureView.setInfiniteLoopState(true);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_url:
                url.add("http://o.ypgimg.com/content/2016/5/16/88d50d38-09fb-4d3e-bd0c-fc52e2a26c74.jpg");
                updateState();
                carouselFigureView.setURL(url);
                break;
            case R.id.remove_url:
                if(url.size()>1){
                    url.remove(0);
                }
                carouselFigureView.setURL(url);
                updateState();
                break;
            case R.id.show_point:
                carouselFigureView.setIndicationPointState(true);
                break;
            case R.id.dismiss_point:
                carouselFigureView.setIndicationPointState(false);
                break;
            case R.id.close_loop:
                carouselFigureView.setInfiniteLoopState(false);
                break;
            case R.id.start_loop:
                carouselFigureView.setInfiniteLoopState(true);
                break;
            case R.id.start_autoplay:
                carouselFigureView.setAutoPlayState(true);

                break;
            case R.id.close_autoplay:
                carouselFigureView.setAutoPlayState(false);
                break;
        }

    }
}
