package com.androidveteran.android.restclient.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.androidveteran.android.restclient.R;
import com.androidveteran.android.restclient.customview.RobotoTextView;
import com.androidveteran.android.restclient.fragment.RequestBodyFormDataFragment;

import java.util.List;

/**
 * Created by chint on 3/21/2016.
 */
public class RequestBodyFormDataRecyclerAdapter extends RecyclerView.Adapter<RequestBodyFormDataRecyclerAdapter.ViewHolder> {

    private Context mContext;
    private List<RequestBodyFormDataFragment.FormData> formDataList;

    public RequestBodyFormDataRecyclerAdapter(Context mContext, List<RequestBodyFormDataFragment.FormData> formDataList) {
        this.mContext = mContext;
        this.formDataList = formDataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_list_item_request_body_form_data, parent, false);
        return new ViewHolder(mContext, view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        RequestBodyFormDataFragment.FormData formData = formDataList.get(position);

        holder.mRobotoTextViewKey.setText(formData.getKey());
        holder.mRobotoTextViewValue.setText(formData.getValue());
    }

    @Override
    public int getItemCount() {
        return formDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //        @Bind(R.id.rlListItemRequestBodyFormData)
        RelativeLayout mRelativeLayout;

        //        @Bind(R.id.tvListItemRequestBodyFormDataKey)
        RobotoTextView mRobotoTextViewKey;

        //        @Bind(R.id.tvListItemRequestBodyFormDataValue)
        RobotoTextView mRobotoTextViewValue;

        //        @Bind(R.id.ibListItemRequestBodyFormDataDelete)
        ImageButton mImageButton;

        private Context mContext;

        public ViewHolder(Context context, View itemView) {
            super(itemView);
            mContext = context;
//            ButterKnife.bind(mContext, itemView);
            mRelativeLayout = (RelativeLayout) itemView.findViewById(R.id.rlListItemRequestBodyFormData);
            mRobotoTextViewKey = (RobotoTextView) itemView.findViewById(R.id.tvListItemRequestBodyFormDataKey);
            mRobotoTextViewValue = (RobotoTextView) itemView.findViewById(R.id.tvListItemRequestBodyFormDataValue);
            mImageButton = (ImageButton) itemView.findViewById(R.id.ibListItemRequestBodyFormDataDelete);

            mRelativeLayout.setOnClickListener(this);
            mImageButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.rlListItemRequestBodyFormData:
                    Toast.makeText(mContext, "listClick()", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.ibListItemRequestBodyFormDataDelete:
                    Toast.makeText(mContext, "deleteClick()", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
