package com.android.team920.contactnumbers;

import android.Manifest;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;

import java.util.List;

import mobile.sarproj.com.swipelayout.SwipeLayout;

import static android.support.v7.widget.RecyclerView.NO_POSITION;


public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context mContext;

    List<Contact> numbersList;



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, suggName, num;
        public CardView cardView;
        public CardView oneHandCardView;
        public Button call;
        ImageView copyImg;

        TextView dragItem;
        ImageView leftView;
        TextView rightTextView;
        SwipeLayout swipeLayout;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            suggName = (TextView) view.findViewById(R.id.sugg_name);
            num = (TextView) view.findViewById(R.id.number);
            cardView = (CardView) view.findViewById(R.id.card_view);
            oneHandCardView = (CardView) view.findViewById(R.id.one_hand_card_view);

//            dragItem = itemView.findViewById(R.id.drag_item);
//            swipeLayout = itemView.findViewById(R.id.swipe_layout);
//            leftView = itemView.findViewById(R.id.right_view);
//            swipeLayout = (SwipeLayout) view.findViewById(R.id.swipe_layout);


            call = (Button) view.findViewById(R.id.call);


            copyImg = (ImageView) view.findViewById(R.id.copyImage);
        }
    }


    public Adapter(Context mContext, List<Contact> numbersList) {
        this.mContext = mContext;
        this.numbersList = numbersList;
    }


    @Override
    public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (Search.first!=false) {
            View numView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_design, parent, false);

            return new MyViewHolder(numView);
        }else{
            View numView1 = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.one_hand_use, parent, false);


            return new MyViewHolder(numView1);



        }

    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        if (Search.first!=false) {
            final Contact contact = numbersList.get(position);
            holder.name.setText(contact.getName());
            holder.suggName.setText(contact.getSuggName());
            holder.num.setText(contact.getNumber());



//        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
//
//        StorageReference storageReference = firebaseStorage.getReference();

//        storageReference.child("items").child(item.getItemImages().get(0)).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri) {
//                Picasso.get().load(uri).fit().centerCrop().into(holder.thumbnail);
            //     }
            // });

            // loading album cover using Glide library
//        Glide.with(mContext).load(item.getImages().get(0)).into(holder.thumbnail);


//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(view.getContext(),ItemActivity.class);
//
//                intent.putExtra("ModuleItem",itemList.get(position));
//
//                view.getContext().startActivity(intent);
//
//            }
//        });


            holder.call.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {


                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + holder.num.getText().toString()));
                    mContext.startActivity(intent);

//                if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                    // TODO: Consider calling
//                     mContext.startActivity(intent);
//                    //    ActivityCompat#requestPermissions
//                    // here to request the missing permissions, and then overriding
//                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                    //                                          int[] grantResults)
//                    // to handle the case where the user grants the permission. See the documentation
//                    // for ActivityCompat#requestPermissions for more details.
//                    return;
//                }

                }
            });


            holder.num.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    ClipboardManager cm = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                    cm.setText(holder.num.getText().toString());
                    Toast.makeText(mContext, "تم النسخ إلى الحافظة", Toast.LENGTH_SHORT).show();


                }


            });


            holder.copyImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    ClipboardManager cm = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                    cm.setText(holder.num.getText().toString());
                    Toast.makeText(mContext, "تم النسخ إلى الحافظة", Toast.LENGTH_SHORT).show();


                }


            });







        }else{
            Search.first =true;

        }
    }

    @Override
    public int getItemCount() {
        {
            return numbersList.size();
        }


    }

    public interface onItemClickListener{
        public void itemDetailClick(Contact contact);



    }

}

