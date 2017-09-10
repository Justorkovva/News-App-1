package justor.newsapp1;

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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
private Context context;

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
        public String htmlContent;
        public String nav_title;

        public MyViewHolder(final View itemView) {
            super(itemView);

            title = ((TextView) itemView.findViewById(R.id.title));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(context,Web.class);
                    myIntent.putExtra("htmlContent",htmlContent);
                    myIntent.putExtra("title",nav_title);
                    context.startActivity(myIntent);
                }
            });
        }

        public void display(FakeNews fake) {
            title.setText(fake.title);
            htmlContent=fake.htmlContent;
            nav_title=fake.title;
        }
    }
}