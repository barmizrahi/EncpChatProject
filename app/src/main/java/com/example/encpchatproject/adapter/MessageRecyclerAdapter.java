package com.example.encpchatproject.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.encpchatproject.model.MessageContent;
import com.example.encpchatproject.R;
import java.util.ArrayList;

public class MessageRecyclerAdapter extends RecyclerView.Adapter<MessageRecyclerAdapter.ViewHolder> {

    private static boolean isDarkBackground = false;
    Context context;
    private final ArrayList<MessageContent> messages;

    public MessageRecyclerAdapter(ArrayList<MessageContent> messages, Context context) {
        this.messages = messages;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.message_recycler_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView emailText;
        TextView dateText;
        TextView messageText;

        LinearLayout messageContentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            messageContentLayout = itemView.findViewById(R.id.messageRecyclerRow_messageContentLayout);

            emailText = itemView.findViewById(R.id.messageRecyclerRow_userEmail);
            dateText = itemView.findViewById(R.id.messageRecyclerRow_messageDate);
            messageText = itemView.findViewById(R.id.messageRecyclerRow_messageContent);
        }

        public void bind(int position) {
            String email = messages.get(position).getEmail();

            String mailStart = email.substring(0, email.indexOf("@"));
            String mailEnd = email.substring(email.indexOf("@"));

            email = mailStart.length() > 15 ? mailStart.substring(0, 15) + "..." + mailEnd
                    : mailStart + mailEnd;

            String date = messages.get(position).getDate()+" ";
            String message = messages.get(position).getMessage();

            emailText.setText(email);
            dateText.setText(date);
            messageText.setText(message);

            messageContentLayout.setBackgroundColor(getColorById());
        }

        private int getColorById() {
            int colorId = 0;

            if (isDarkBackground) {
                colorId = ContextCompat.getColor(context, R.color.pale_golden_rode);
            } else {
                colorId = ContextCompat.getColor(context, R.color.chartreuse);
            }

            isDarkBackground = !isDarkBackground;

            return colorId;
        }
    }

}
