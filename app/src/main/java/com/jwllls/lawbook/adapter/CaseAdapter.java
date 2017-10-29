package com.jwllls.lawbook.adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jwllls.lawbook.R;
import com.jwllls.lawbook.activity.MyShareActivity;
import com.jwllls.lawbook.activity.RecordActivity;
import com.jwllls.lawbook.base.BaseActivity;
import com.jwllls.lawbook.model.CaseMain;
import com.jwllls.lawbook.model.CaseModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jwllls on 2017/10/24.
 */

public class CaseAdapter extends RecyclerView.Adapter<CaseAdapter.CaseHolder> {


    private BaseActivity activity;
    private List<CaseModel> cases = new ArrayList<>();
    private List<CaseMain> list = new ArrayList<>();


    private MyLongClickListener longClickListener;

    public interface MyLongClickListener {
        public void mylongClick(View view, int postion, CaseModel caseNo, CaseMain list);
    }

    public void setMyLongClickListener(MyLongClickListener listener) {
        longClickListener = listener;
    }


    public CaseAdapter(BaseActivity activity) {
        this.activity = activity;

    }

    public void setCaseData(List<CaseModel> cases, List<CaseMain> list) {
        this.cases = cases;
        this.list = list;
    }

    @Override
    public CaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_case, parent, false);
        CaseHolder vh = new CaseHolder(view, longClickListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(CaseHolder holder, final int position) {

        holder.nick.setText(cases.get(position).getNick());
        holder.phone.setText(cases.get(position).getPhone());

        holder.item_caseNo.setText(cases.get(position).getCaseNo());
        holder.item_caseName.setText(cases.get(position).getCaseName());

        holder.time.setText(cases.get(position).getCreatedAt());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(activity, RecordActivity.class);
                it.putExtra("caseModel", cases.get(position));
                it.putExtra("caseMain", list.get(position));
                activity.startActivity(it);

            }
        });

    }


    @Override
    public int getItemCount() {
        return cases.size();
    }


    class CaseHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {

        MyLongClickListener longClickListener;

        TextView nick, phone, item_caseNo, item_caseName, time;

        CardView cardView;

        public CaseHolder(View itemView, MyLongClickListener longClickListener) {
            super(itemView);
            nick = (TextView) itemView.findViewById(R.id.item_nick);
            phone = (TextView) itemView.findViewById(R.id.item_phone);
            item_caseNo = (TextView) itemView.findViewById(R.id.item_caseNo);
            item_caseName = (TextView) itemView.findViewById(R.id.item_caseName);
            time = (TextView) itemView.findViewById(R.id.item_time);
            cardView = (CardView) itemView.findViewById(R.id.cardView);

            this.longClickListener = longClickListener;

            if (activity instanceof MyShareActivity)
                cardView.setOnLongClickListener(this);
        }

        @Override
        public boolean onLongClick(View v) {

            int index = getAdapterPosition();

            if (longClickListener != null) {
                longClickListener.mylongClick(v, index, cases.get(index), list.get(index));
            }
            return true;
        }
    }


}
