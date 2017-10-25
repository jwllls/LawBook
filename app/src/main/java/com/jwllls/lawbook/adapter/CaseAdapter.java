package com.jwllls.lawbook.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jwllls.lawbook.R;
import com.jwllls.lawbook.activity.MainActivity;
import com.jwllls.lawbook.model.CaseModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jwllls on 2017/10/24.
 */

public class CaseAdapter extends RecyclerView.Adapter<CaseAdapter.CaseHolder> {




    private MainActivity activity;
    private List<CaseModel> cases = new ArrayList<>();

    public CaseAdapter(MainActivity activity,List<CaseModel> cases) {
        this.activity = activity;
        this.cases = cases;
    }

    @Override
    public CaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_case, parent, false);
        CaseHolder vh = new CaseHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(CaseHolder holder, int position) {

        holder.nick.setText(cases.get(position).getNick());
        holder.phone.setText(cases.get(position).getPhone());

        holder.item_caseNo.setText(cases.get(position).getCaseNo()+". ");
        holder.item_caseName.setText(cases.get(position).getCaseName());

        holder.time.setText(cases.get(position).getCreatedAt());
    }




    @Override
    public int getItemCount() {
        return cases.size();
    }

   static class CaseHolder extends RecyclerView.ViewHolder {

        TextView nick, phone, item_caseNo,item_caseName, time;

        public CaseHolder(View itemView) {
            super(itemView);
            nick = (TextView) itemView.findViewById(R.id.item_nick);
            phone = (TextView) itemView.findViewById(R.id.item_phone);
            item_caseNo =(TextView) itemView.findViewById(R.id.item_caseNo);
            item_caseName = (TextView) itemView.findViewById(R.id.item_caseName);
            time = (TextView) itemView.findViewById(R.id.item_time);

        }
    }
}
