package com.xuhai.androiddesignpattern;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.xuhai.androiddesignpattern.s_adapter.CircleMenuLayout;
import com.xuhai.study.UpdateUIActivity;

public class MainActivity extends AppCompatActivity {

    private Button mButton;

    private CircleMenuLayout mCircleMenuLayout;

    private String[] mItemTexts = new String[]{"安全中心 ", "特色服务", "投资理财",
            "转账汇款", "我的账户", "信用卡"};
    private int[] mItemImgs = new int[]{R.drawable.home_mbank_1_normal,
            R.drawable.home_mbank_2_normal, R.drawable.home_mbank_3_normal,
            R.drawable.home_mbank_4_normal, R.drawable.home_mbank_5_normal,
            R.drawable.home_mbank_6_normal};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ImageView imageView = findViewById(R.id.imageView);
        // ImageLoader imageLoader = new ImageLoader();
        // imageLoader.setImageCache(new MemoryCache());
        // imageLoader.displayImage(MainActivity.this, "http://q9-di-img.oss-cn-hangzhou.aliyuncs.com/201903_60f69eaf-d165-422d-8101-b298023c16b2?Expires=1574682305&OSSAccessKeyId=STS.NSfqq3cqmtQrMc666D89Tg8jJ&Signature=HS8SJ3Zpj35Ba2gHeSE5Ty4jDvU%3D&security-token=CAIS9gF1q6Ft5B2yfSjIr5DTOsuHjq5Mw5OZT0WH0jYRNLZ4iP3BqDz2IHlJfXlpA%2BwXt%2Fk%2Fmm1R6PoSlqZ8RoN9X0H%2FbMR245hq6wf5vQ5MQk7wv9I%2Bk5SANTW5KXyShb3%2FAYjQSNfaZY3eCTTtnTNyxr3XbCirW0ffX7SClZ9gaKZ8PGD6F00kYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gX6wo9y9zmmZPDsUSB0QKilr9O%2Bd6sGPX%2BMZkwZqUYesyuwel7epDG1CNt8BVQ%2FM909vcdpG6X54vBUgAMs0vbarSIoscPNV48aqk7HqFUbUNXb0TjZIYagAF396c%2FpaOqPnO2tmo%2FpePrBjZxwxg2%2FeVyXC9JdgueJyaoWQZc9eZtjFtwDEPNklh3tYRfMr2%2B2ZD3L9r4%2FxcuwOWeOmvseXzitVA9X96YWCoCcic%2BX4yZrTk2vaIoX%2BD8p7Pa%2F4G3VRoI70yPQwGQlLQY1oZXXMXqV1hr6IXLQA%3D%3D", imageView);
        // Client.test();
        // ClientCoffee.test();
        // mButton = findViewById(R.id.btn);
        // mButton.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View v) {
        //         startActivity(new Intent(MainActivity.this, NodeMainActivity.class));
        //     }
        // });

        mCircleMenuLayout = findViewById(R.id.id_menulayout);
        mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);

        mCircleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {

            @Override
            public void itemClick(View view, int pos) {
                Toast.makeText(MainActivity.this, mItemTexts[pos],
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void itemCenterClick(View view) {
                Toast.makeText(MainActivity.this,
                        "you can do something just like ccb  ",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, UpdateUIActivity.class));
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
