package com.android.team920.contactnumbers;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.constraint.Group;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import mobile.sarproj.com.swipelayout.SwipeLayout;

import static android.support.v7.widget.RecyclerView.NO_POSITION;



public class NewAdapter extends RecyclerView.Adapter<NewAdapter.ItemHolder> {

    private Context mContext;

//    List<Contact> numbersList;
    private List<Contact> items;
     Contact contact;
    NewAdapter(Context mContext,List<Contact> items) {
        this.items = items;
        this.mContext = mContext;


    }


    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {


        if (Search.first!=false) {
            return new ItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_design_swipe, viewGroup, false));
        }else{
            return new ItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.one_hand_use, viewGroup, false));


    }
    }



    @Override
    public void onBindViewHolder(@NonNull final ItemHolder itemHolder, int position) {

        if (Search.first!=false) {
         contact = items.get(position);
        itemHolder.name.setText(contact.getName());
        itemHolder.suggName.setText(contact.getSuggName());
        itemHolder.num.setText(contact.getNumber());



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


        itemHolder.call.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + itemHolder.num.getText().toString()));
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


        itemHolder.num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ClipboardManager cm = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setText(itemHolder.num.getText().toString());
                Toast.makeText(mContext, "تم النسخ إلى الحافظة"+contact.isLike(), Toast.LENGTH_SHORT).show();


            }


        });


        itemHolder.copyImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ClipboardManager cm = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setText(itemHolder.num.getText().toString());
                Toast.makeText(mContext, "تم النسخ إلى الحافظة", Toast.LENGTH_SHORT).show();


            }


        });







        }else{
            Search.first =true;
    }
    }














    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private void addToFav(Context context, int position) {

        Toast.makeText(context, "تمت الإضافة الى المفضلة" + contact.isLike(), Toast.LENGTH_SHORT).show();
        contact.setLike(true);
    }

//    private boolean upload(Context context, int position) {
//        Toast.makeText(context, "upload item " + position, Toast.LENGTH_SHORT).show();
//        return true;
//    }

    class ItemHolder extends RecyclerView.ViewHolder {

        public TextView name, suggName, num;
        public CardView cardView;
        public CardView oneHandCardView;
        public Button call;
        ImageView copyImg;

        ImageView leftView;
//        ImageView rightView;
        SwipeLayout swipeLayout;

        ItemHolder(@NonNull final View itemView) {
            super(itemView);
                if (Search.first!=false) {



            name = (TextView) itemView.findViewById(R.id.name);
            suggName = (TextView) itemView.findViewById(R.id.sugg_name);
            num = (TextView) itemView.findViewById(R.id.number);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            oneHandCardView = (CardView) itemView.findViewById(R.id.one_hand_card_view);
            call = (Button) itemView.findViewById(R.id.call);
            copyImg = (ImageView) itemView.findViewById(R.id.copyImage);

            swipeLayout = itemView.findViewById(R.id.swipe_layout);
            leftView = itemView.findViewById(R.id.left_view);
//            rightView = itemView.findViewById(R.id.right_view);





//            rightView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (getAdapterPosition() != NO_POSITION) {
//                        addToFav(itemView.getContext(), getAdapterPosition());
//                    }
//                }
//            });

//            leftView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (getAdapterPosition() != NO_POSITION) {
//                        upload(itemView.getContext(), getAdapterPosition());
//                    }
//                }
//            });






                    swipeLayout.setOnActionsListener(new SwipeLayout.SwipeActionsListener() {
                        @Override
                        public void onOpen(int direction, boolean isContinuous) {
                            if (direction == SwipeLayout.RIGHT) {
                                if (getAdapterPosition() != NO_POSITION) {
                                    addToFav(itemView.getContext(), getAdapterPosition());
                                    swipeLayout.close();
                                }
                            }
                        }

                        @Override
                        public void onClose() {

                        }
                    });

                    }

        }
    }


}
