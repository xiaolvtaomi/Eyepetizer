package com.zhf.main.viewholder;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;

import com.zhf.main.R;
import com.zhf.main.bean.CustomBean;
import com.zhpan.bannerview.holder.ViewHolder;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 */
public class CustomPageViewHolder implements ViewHolder<CustomBean> {
    private OnSubViewClickListener mOnSubViewClickListener;

    @Override
    public int getLayoutId() {
        return R.layout.main_item_custom_view;
    }

    @Override
    public void onBind(View itemView, CustomBean data, int position, int size) {
        ImageView mImageView = itemView.findViewById(R.id.banner_image);
        itemView.setOnClickListener(v -> mOnSubViewClickListener.onViewClick(v, position));
        mImageView.setImageResource(data.getImageRes());
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(mImageView, "alpha", 0, 1);
        alphaAnimator.setDuration(1500);
        alphaAnimator.start();
    }

    public void setOnSubViewClickListener(OnSubViewClickListener subViewClickListener) {
        mOnSubViewClickListener = subViewClickListener;
    }

    public interface OnSubViewClickListener {
        void onViewClick(View view, int position);
    }
}
