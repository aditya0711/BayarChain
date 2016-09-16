package com.bayarchain.Adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bayarchain.R;
import java.util.List;
import com.bayarchain.Model.Contract;

/**
 * Created by Aditya Aggarwal on 16-09-2016.
 */
public class CustomContractAdapter extends RecyclerView.Adapter<CustomContractAdapter.MyViewHolder> {
    private List<Contract> contractList;
    TextView Created_with, event, contract_amount, amount_label, createTitle, principal_amount;
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contract_list_display, parent, false);

        return new MyViewHolder(itemView);
    }

    public CustomContractAdapter(List<Contract> contractList) {
        this.contractList = contractList;
    }
    @Override
    public void onBindViewHolder(MyViewHolder convertView, int position) {
        Contract object = contractList.get(position);

        Created_with.setText(object.getCreator_username());
        event.setText("Event Name: " + object.getContract_event());
        principal_amount.setText("Principal Amount: " + object.getContract_principal() );


        if(object.getContract_status().toString().trim().equals("1")){
            amount_label.setText("Settled!!");
            amount_label.setTextColor(Color.parseColor("#1b5e20"));
        }
        contract_amount.setText("$ " + object.getContract_amount());

//        if(tab.equals("credit")){
//            createTitle.setText("You will get from..");
//            contract_amount.setTextColor(Color.parseColor("#1b5e20"));
//            amount_label.setTextColor(Color.parseColor("#4caf50"));
//        }
//        else if(tab.equals("debit")){
//            createTitle.setText("You owe..");
//
//            contract_amount.setTextColor(Color.parseColor("#b71c1c"));
//            amount_label.setTextColor(Color.parseColor("#e53935"));
//        }
    }

    @Override
    public int getItemCount() {
        return contractList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View convertView) {
            super(convertView);

            Created_with = (TextView) convertView.findViewById(R.id.contractID);
            event= (TextView) convertView.findViewById(R.id.event_naa);
            contract_amount = (TextView) convertView.findViewById(R.id.amount);
            amount_label = (TextView)convertView.findViewById(R.id.text17);//DONOT ToUCH OnlY FOR UI
            createTitle = (TextView)convertView.findViewById(R.id.textView15);
            principal_amount = (TextView)convertView.findViewById(R.id.principal_amt);
        }
    }
}