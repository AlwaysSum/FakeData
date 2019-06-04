package com.maguangcan.fake.example;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.maguangcan.fake.example.bean.TestFake;

import java.util.List;

/**
 * 简单的适配器
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.TestFakeHolder> {

    private List<TestFake> datas;

    public MainAdapter(List<TestFake> datas) {
        this.datas = datas;
    }

    public void setNewDatas(List<TestFake> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public TestFakeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_list, null);
        return new TestFakeHolder(view);
    }

    @Override
    public void onBindViewHolder(TestFakeHolder holder, int position) {
        holder.tvName.setText(datas.get(position).getTestName());
        holder.tvPhone.setText(datas.get(position).getTestPhone());
        holder.tvEmails.setText(datas.get(position).getTestEmails());
        holder.tvAge.setText(datas.get(position).getTestAge() + "岁");
        //头像
        Glide.with(holder.itemView.getContext()).load(datas.get(position).getTestHeader())
                .placeholder(R.mipmap.ic_launcher_round).into(holder.ivHeader);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class TestFakeHolder extends RecyclerView.ViewHolder {

        private AppCompatImageView ivHeader;
        private AppCompatTextView tvName;
        private AppCompatTextView tvPhone;
        private AppCompatTextView tvEmails;
        private AppCompatTextView tvAge;

        public TestFakeHolder(View itemView) {
            super(itemView);
            ivHeader = itemView.findViewById(R.id.ivHeader);
            tvName = itemView.findViewById(R.id.tvName);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvEmails = itemView.findViewById(R.id.tvEmails);
            tvAge = itemView.findViewById(R.id.tvAge);
        }
    }
}
