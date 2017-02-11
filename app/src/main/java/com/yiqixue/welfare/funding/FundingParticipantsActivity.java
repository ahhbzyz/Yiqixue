package com.yiqixue.welfare.funding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.GridView;

import com.yiqixue.R;
import com.yiqixue.welfare.volunteer.VolunteerParticipantsGvAdapter;

/**
 * 文件名：FundingParticipantsActivity
 * 描  述：筹款详情的参与用户界面
 * 作  者：Yaozhong
 * 时  间：
 */
public class FundingParticipantsActivity extends AppCompatActivity {

    private int[] participantsPhotos = {R.mipmap.head1, R.mipmap.head2, R.mipmap.head3, R.mipmap.head1,
            R.mipmap.head2, R.mipmap.head3, R.mipmap.head1};//模拟数据
    private String myDataset[] = {"小王", "小明", "张丽", "小王", "小明", "张丽", "小王"};//模拟数据

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funding_participants);

        setUpToolbar();

        //设置参与用户的网格列表
        GridView mParticipantsPhotoGv = (GridView) findViewById(R.id.gv_participants_photo);
        mParticipantsPhotoGv.setAdapter(new FundingParticipantsGvAdapter(this, myDataset, participantsPhotos));

    }

    private void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}