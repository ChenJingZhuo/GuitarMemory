package com.cjz.guitarmemory;

import android.content.DialogInterface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.cjz.guitarmemory.util.MyToast;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SoundPool soundpool;
    private HashMap<Integer, Integer> map = new HashMap<>();
    private char key[][] = new char[7][13];

    private TextView mTvAsk;
    private Button mShowAnswer;
    private TextView mTvAnswer;
    private Button mNext;
    private ImageView mIvDo;
    private ImageView mIvRe;
    private ImageView mIvMi;
    private ImageView mIvFa;
    private ImageView mIvSo;
    private ImageView mIvLa;
    private ImageView mIvSi;
    private char answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("GuitarMemory");
        toolbar.setBackgroundColor(0xFF6200EE);
        setSupportActionBar(toolbar);
        mTvAsk = findViewById(R.id.tv_ask);
        mShowAnswer = findViewById(R.id.show_answer);
        mTvAnswer = findViewById(R.id.tv_answer);
        mTvAnswer.setSelected(true);
        mNext = findViewById(R.id.next);
        mIvDo = findViewById(R.id.iv_do);
        mIvRe = findViewById(R.id.iv_re);
        mIvMi = findViewById(R.id.iv_mi);
        mIvFa = findViewById(R.id.iv_fa);
        mIvSo = findViewById(R.id.iv_so);
        mIvLa = findViewById(R.id.iv_la);
        mIvSi = findViewById(R.id.iv_si);
        mShowAnswer.setOnClickListener(this);
        mNext.setOnClickListener(this);
        mIvDo.setOnClickListener(this);
        mIvRe.setOnClickListener(this);
        mIvMi.setOnClickListener(this);
        mIvFa.setOnClickListener(this);
        mIvSo.setOnClickListener(this);
        mIvLa.setOnClickListener(this);
        mIvSi.setOnClickListener(this);
        initData();
        initSoundPool();
        playGuitarRandomFingerboardSoundMemory();
    }

    private void initSoundPool() {
        if (soundpool == null) {
            //创建SoundPool对象
            soundpool = new SoundPool(7, AudioManager.STREAM_MUSIC, 0);
        }
        //加载音频文件，并将文件存储到HashMap的集合中
        map.put(R.id.iv_do, soundpool.load(this, R.raw.music_do, 1));
        map.put(R.id.iv_re, soundpool.load(this, R.raw.music_re, 1));
        map.put(R.id.iv_mi, soundpool.load(this, R.raw.music_mi, 1));
        map.put(R.id.iv_fa, soundpool.load(this, R.raw.music_fa, 1));
        map.put(R.id.iv_so, soundpool.load(this, R.raw.music_so, 1));
        map.put(R.id.iv_la, soundpool.load(this, R.raw.music_la, 1));
        map.put(R.id.iv_si, soundpool.load(this, R.raw.music_si, 1));
    }

    private void initData() {
        key[2][1] = key[5][3] = key[3][5] = key[6][8] = key[1][8] = key[4][10] = 'C';
        key[4][0] = key[2][3] = key[5][5] = key[3][7] = key[1][10] = key[6][10] = key[4][12] = 'D';
        key[1][0] = key[6][0] = key[4][2] = key[2][5] = key[5][7] = key[3][9] = key[1][12] = key[6][12] = 'E';
        key[1][1] = key[6][1] = key[4][3] = key[2][6] = key[5][8] = key[3][10] = 'F';
        key[3][0] = key[1][3] = key[6][3] = key[4][5] = key[2][8] = key[5][10] = key[3][12] = 'G';
        key[5][0] = key[3][2] = key[1][5] = key[6][5] = key[4][7] = key[2][10] = key[5][12] = 'A';
        key[2][0] = key[5][2] = key[3][4] = key[1][7] = key[6][7] = key[4][9] = key[2][12] = 'B';
    }

    //吉他随机指板音记忆
    private void playGuitarRandomFingerboardSoundMemory() {
        mTvAnswer.setText("请回答");
        Random random = new Random();
        int x = random.nextInt(6) + 1;
        int y = random.nextInt(13);
        mTvAsk.setText("判断相应位置的音：\n" + x + "弦 " + y + "品");
        answer = key[x][y];
    }

    private void play(int i) {
        //播放音频
        soundpool.play(map.get(i), 1.0f, 1.0f, 0, 0, 1.0f);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.show_answer:
                if (answer == '\0') {
                    mTvAnswer.setText("答案：带升降号的音，自己猜");
                } else {
                    mTvAnswer.setText("答案：" + answer);
                }
                break;
            case R.id.next:
                playGuitarRandomFingerboardSoundMemory();
                break;
            case R.id.iv_do://C
                play(view.getId());
                if (answer == 'C') {
                    mTvAnswer.setText("恭喜你！答对了！");
                } else {
                    mTvAnswer.setText("答案不正确");
                }
                break;
            case R.id.iv_re://D
                play(view.getId());
                if (answer == 'D') {
                    mTvAnswer.setText("恭喜你！答对了！");
                } else {
                    mTvAnswer.setText("答案不正确");
                }
                break;
            case R.id.iv_mi://E
                play(view.getId());
                if (answer == 'E') {
                    mTvAnswer.setText("恭喜你！答对了！");
                } else {
                    mTvAnswer.setText("答案不正确");
                }
                break;
            case R.id.iv_fa://F
                play(view.getId());
                if (answer == 'F') {
                    mTvAnswer.setText("恭喜你！答对了！");
                } else {
                    mTvAnswer.setText("答案不正确");
                }
                break;
            case R.id.iv_so://G
                play(view.getId());
                if (answer == 'G') {
                    mTvAnswer.setText("恭喜你！答对了！");
                } else {
                    mTvAnswer.setText("答案不正确");
                }
                break;
            case R.id.iv_la://A
                play(view.getId());
                if (answer == 'A') {
                    mTvAnswer.setText("恭喜你！答对了！");
                } else {
                    mTvAnswer.setText("答案不正确");
                }
                break;
            case R.id.iv_si://B
                play(view.getId());
                if (answer == 'B') {
                    mTvAnswer.setText("恭喜你！答对了！");
                } else {
                    mTvAnswer.setText("答案不正确");
                }
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.about) { // 点击了关于菜单项
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.about, null, false);
            builder.setView(view);
            builder.setCancelable(true);
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}