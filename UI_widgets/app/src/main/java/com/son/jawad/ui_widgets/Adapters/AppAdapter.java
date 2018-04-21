package com.son.jawad.ui_widgets.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.son.jawad.tutoriallibrary.Providers.ApplicationsProvider.AppInfo;
import com.son.jawad.ui_widgets.R;

import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.AppViewHolder> {

    // AppAdapter variables
    private List<AppInfo> appList;
    private Context context;

    public AppAdapter(List<AppInfo> appList, Context context) {
        this.appList = appList;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }

    public void clear() {
        appList.clear();
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(AppViewHolder appViewHolder, int i) {
        AppInfo appInfo = appList.get(i);
        appViewHolder.vName.setText(appInfo.getName());
        appViewHolder.vApk.setText(appInfo.getAPK());
        appViewHolder.vIcon.setImageDrawable(appInfo.getIcon());

        setButtonEvents(appViewHolder, appInfo);

    }

    private void setButtonEvents(AppViewHolder appViewHolder, final AppInfo appInfo) {
        Button appExtract = appViewHolder.vExtract;
        Button appShare = appViewHolder.vShare;
        final ImageView appIcon = appViewHolder.vIcon;
        final CardView cardView = appViewHolder.vCard;

        appExtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                MaterialDialog dialog = UtilsDialog.showTitleContentWithProgress(context
//                        , String.format(context.getResources().getString(R.string.dialog_saving), appInfo.getName())
//                        , context.getResources().getString(R.string.dialog_saving_description));
//                new ExtractFileInBackground(context, dialog, appInfo).execute();
            }
        });
        appShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                                            UtilsApp.copyFile(appInfo);
//                                            Intent shareIntent = UtilsApp.getShareIntent(UtilsApp.getOutputFilename(appInfo));
//                                            context.startActivity(Intent.createChooser(shareIntent, String.format(context.getResources().getString(R.string.send_to), appInfo.getName())));
            }
        });

        appViewHolder.vLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        appViewHolder.vUninstall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        appViewHolder.vOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        cardView.setOnClickListener(new View.OnClickListener()

                                    {
                                        @Override
                                        public void onClick(View view) {
//                Activity activity = (Activity) context;
//
//                Intent intent = new Intent(context, AppActivity.class);
//                intent.putExtra("app_name", appInfo.getName());
//                intent.putExtra("app_apk", appInfo.getAPK());
//                intent.putExtra("app_version", appInfo.getVersion());
//                intent.putExtra("app_source", appInfo.getSource());
//                intent.putExtra("app_data", appInfo.getData());
//                Bitmap bitmap = ((BitmapDrawable) appInfo.getIcon()).getBitmap();
//                intent.putExtra("app_icon", bitmap);
//                intent.putExtra("app_isSystem", appInfo.isSystem());
//
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    String transitionName = context.getResources().getString(R.string.transition_app_icon);
//
//                    ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(activity, appIcon, transitionName);
//                    context.startActivity(intent, transitionActivityOptions.toBundle());
//                } else {
//                    context.startActivity(intent);
//                    activity.overridePendingTransition(R.anim.slide_in_right, R.anim.fade_back);
//                }
                                        }
                                    }

        );

    }

    @Override
    public AppViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View appAdapterView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.provider_appitem_layout, viewGroup, false);
        return new AppViewHolder(appAdapterView);
    }

    public static class AppViewHolder extends RecyclerView.ViewHolder {
        protected TextView vName;
        protected TextView vApk;
        protected ImageView vIcon;
        protected Button vExtract;
        protected Button vShare;
        protected Button vOpen;
        protected Button vUninstall;
        protected Button vLink;
        protected CardView vCard;

        public AppViewHolder(View v) {
            super(v);
            vName = (TextView) v.findViewById(R.id.txtName);
            vApk = (TextView) v.findViewById(R.id.txtApk);
            vIcon = (ImageView) v.findViewById(R.id.imgIcon);
            vExtract = (Button) v.findViewById(R.id.btnExtract);
            vShare = (Button) v.findViewById(R.id.btnShare);
            vOpen = (Button) v.findViewById(R.id.btnOpen);
            vLink = (Button) v.findViewById(R.id.btnLink);
            vUninstall = (Button) v.findViewById(R.id.btnUninstall);

            vCard = (CardView) v.findViewById(R.id.app_card);
        }

    }

}
