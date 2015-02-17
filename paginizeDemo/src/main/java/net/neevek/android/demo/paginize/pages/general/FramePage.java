package net.neevek.android.demo.paginize.pages.general;

import android.view.View;
import android.widget.TextView;
import net.neevek.android.demo.paginize.R;
import net.neevek.android.lib.paginize.Page;
import net.neevek.android.lib.paginize.PageActivity;
import net.neevek.android.lib.paginize.annotation.ListenerDefs;
import net.neevek.android.lib.paginize.annotation.InjectView;
import net.neevek.android.lib.paginize.annotation.PageLayout;
import net.neevek.android.lib.paginize.annotation.SetListeners;

/**
 * Created by xiejm on 6/4/14.
 */
@PageLayout(R.layout.page_frame)
public abstract class FramePage extends Page {
  @InjectView(value = R.id.tv_title)
  TextView mTvTitle;

  @ListenerDefs({
      @SetListeners(view = R.id.tv_back, listenerTypes = View.OnClickListener.class, listener = MyOnClickListener.class),
      @SetListeners(view = R.id.tv_next, listenerTypes = View.OnClickListener.class, listener = MyOnClickListener.class)
  })
  public FramePage(PageActivity pageActivity) {
    super(pageActivity);
  }

  protected void setTitle(String title) {
    mTvTitle.setText(title);
  }

  protected void onBackButtonClicked() {
    hide(true, true);
  }

  protected void onNextButtonClicked() {

  }

  class MyOnClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
      switch (v.getId()) {
        case R.id.tv_back:
          onBackButtonClicked();
          break;
        case R.id.tv_next:
          onNextButtonClicked();
          break;
      }
    }
  }
}
