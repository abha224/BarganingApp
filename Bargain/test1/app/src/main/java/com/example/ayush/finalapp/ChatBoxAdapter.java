package com.example.ayush.finalapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import static com.example.ayush.finalapp.ChatBox.chats;

class ChatBoxAdapter extends RecyclerView.Adapter<ChatBoxAdapter.myViewHolder>{
    List<Message> chat_list;
    Context mContext;
    String current_user,receiver;
    ChatBox activity;
    AlertDialog.Builder builder;

    ChatBoxAdapter(List<Message> chat_list, Context mContext, String current_user, String receiver, ChatBox activity)
    {
        this.chat_list = chat_list;
        this.mContext = mContext;
        this.current_user = current_user;
        this.receiver = receiver;
        this.activity = activity;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = null;
        if(i == ChatBox.Right)
            view = LayoutInflater.from(mContext).inflate(R.layout.message_right,viewGroup,false);
        else if(i == ChatBox.Left)
            view = LayoutInflater.from(mContext).inflate(R.layout.message_left,viewGroup,false);
        return new myViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull myViewHolder viewHolder, int i) {
        if(viewHolder.view == null)
            return;
        final int j = i;
        TextView textView = viewHolder.view.findViewById(R.id.Message);

        textView.setText(chats.get(i).message);
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                builder = new AlertDialog.Builder (activity);
                LayoutInflater inflater = activity.getLayoutInflater();
                builder.setTitle("Delete This Message");
                builder.setMessage("Are you sure? This action cannot be reversed.");
                        builder.setPositiveButton ("Yes", new DialogInterface.OnClickListener () {
                            public void onClick(DialogInterface dialog, int id) {
                                activity.DeleteMessage(j);
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener () {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel ();
                            }
                        });
                builder.setCancelable (false);
                AlertDialog alert = builder.create ();
                alert.show ();

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(current_user.equals(chats.get(position).sender))
            return ChatBox.Right;
        else
            return ChatBox.Left;

    }

    class myViewHolder extends RecyclerView.ViewHolder{
        View view;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }
}