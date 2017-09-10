package justor.newsapp1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.oc.rss.fake.FakeNews;
import com.oc.rss.fake.FakeNewsList;
import java.util.List;
import android.app.Activity;

import static justor.newsapp1.R.id.webView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
private Context context;

    public MyAdapter() {

    }
    public MyAdapter(Context context) {
        this.context=context;
    }

    List<FakeNews> list = FakeNewsList.all;

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FakeNews fake = list.get(position);
        holder.display(fake);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        //private final TextView htmlcontent;
        public String htmlContent;

        private FakeNews currentPair;

        public MyViewHolder(final View itemView) {
            super(itemView);

            title = ((TextView) itemView.findViewById(R.id.title));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(context,Web.class);
                    myIntent.putExtra("htmlContent",htmlContent);
                    context.startActivity(myIntent);
                   // webView.loadData(htmlContent, "text/html; charset=UTF-8", null);

                }
            });
        }

        public void display(FakeNews fake) {
            currentPair = fake;
            title.setText(fake.title);
            htmlContent=fake.htmlContent;
           // htmlcontent.setText(fake.htmlContent);
        }
    }

}