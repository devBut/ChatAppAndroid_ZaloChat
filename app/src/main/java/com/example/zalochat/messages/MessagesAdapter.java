package com.example.zalochat.messages;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zalochat.R;
import com.example.zalochat.chat.Chat;
import com.squareup.picasso.Picasso;

import java.security.PublicKey;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MyViewHolder> {

    private List<MessagesList> messagesListList;
    private final Context context;

    public MessagesAdapter(List<MessagesList> messagesListList, Context context) {
        this.messagesListList = messagesListList;
        this.context = context;
    }

    @NonNull
    @Override
    public MessagesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.messages_adapter_layout,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesAdapter.MyViewHolder holder, int position) {
        MessagesList list2 = messagesListList.get(position);
        if(!list2.getProfilePic().isEmpty()){
            Picasso.get().load(list2.getProfilePic()).into(holder.ProfilePic);

        }
        holder.name.setText(list2.getName());
        holder.lastMessage.setText(list2.getLastMessage());
        if (list2.getUnseenMassages()==0){
            holder.unseenMessages.setVisibility(View.GONE);
            holder.lastMessage.setTextColor(Color.parseColor("#959595"));
        }
        else {
            holder.unseenMessages.setVisibility(View.VISIBLE);
            holder.unseenMessages.setText(list2.getUnseenMassages()+"");
            holder.lastMessage.setTextColor(context.getResources().getColor(R.color.them_color_80));


        }
        holder.rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(context, Chat.class);
                intent.putExtra("mobile", list2.getMobile());
                intent.putExtra("name", list2.getName());
                intent.putExtra("profile_pic", list2.getProfilePic());
                intent.putExtra("chat_key", list2.getChatKey());
                context.startActivity(intent);

            }
        });
    }

    public void updateData(List<MessagesList> messagesListList){
        this.messagesListList = messagesListList;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return messagesListList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView ProfilePic;
        private TextView name;
        private TextView lastMessage;
        private TextView unseenMessages;
        private LinearLayout rootLayout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ProfilePic = itemView.findViewById(R.id.profilePic);
            name = itemView.findViewById(R.id.name);
            lastMessage = itemView.findViewById(R.id.lastMessage);
            unseenMessages = itemView.findViewById(R.id.unseenMessages);
            rootLayout = itemView.findViewById(R.id.rootLayout);
        }
    }
}
