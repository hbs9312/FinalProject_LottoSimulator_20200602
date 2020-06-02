package kr.co.tjoeun.finalproject_lottosimulator_20200602;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Arrays;

import kr.co.tjoeun.finalproject_lottosimulator_20200602.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;

    int[] winLottoNumArr = new int[6];
    int bonusNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setupEvent();
        setValues();
    }

    @Override
    public void setupEvent() {

        binding.buyOneLottoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeLottoWinNum();
            }
        });

    }

    @Override
    public void setValues() {

    }

    void makeLottoWinNum() {

        for (int i=0; i < winLottoNumArr.length; i++) {
            winLottoNumArr[i] = 0;
        }

        for(int i=0; i < winLottoNumArr.length; i++) {

            while(true) {

                int randomNum = (int) (Math.random()*45 + 1);

                boolean isDuplOk = true;
                for (int num : winLottoNumArr) {

                    if (num == randomNum) {
                        isDuplOk = false;
                        break;
                    }

                }

                if(isDuplOk){
                    winLottoNumArr[i] = randomNum;
                    break;
                }

            }

        }

        Arrays.sort(winLottoNumArr);

        for(int winNum : winLottoNumArr) {
            Log.d("당첨번호", winNum+"");
        }

    }

}
