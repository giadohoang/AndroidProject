package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private ArrayList<Person> people;

    ItemClicked activity;

    public interface  ItemClicked{
        void onItemClicked(int index);
    }

    //parse in context: the context that we are using it
    //ArrayList: Arraylist of person object that will be parsed in
    public PersonAdapter(Context context, ArrayList<Person> list){
        //set people to list that is parsed in
        people = list;
        activity = (ItemClicked) context;
    }

    //ViewHolder class
    public class ViewHolder extends RecyclerView.ViewHolder{


        //Every item in the listview
        ImageView ivPref;
        TextView tvName, tvSurname;


        //This view holder class will represent the item on the list_item view
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //Create link to each component on list_items
            tvName = itemView.findViewById(R.id.tvName);
            tvSurname = itemView.findViewById(R.id.tvSurname );
            ivPref = itemView.findViewById(R.id.ivPref);

            //When item is clicked
            itemView.setOnClickListener(new View.OnClickListener() {

               //When an item on the list is clicked
                @Override
                public void onClick(View view) {

                    //Send through what is the index of the value that was clicked on
                    //in the people array list, we get the index of object that was tagged
                    // refer to this code ( viewHolder.itemView.setTag(people.get(i));)
                    activity.onItemClicked(people.indexOf((Person) view.getTag()));

                }
            });
        }
    }

    //This create connection to the layout list_items
    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//View v refer to list_items. We inflate that layout
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items, viewGroup, false);
        //When we parsing the v into ViewHolder, it goes to ViewHolder class ( defined above)
        return new ViewHolder(v);
    }

    //Run for every item that is currently on the arraylist
    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(people.get(i));

        viewHolder.tvName.setText(people.get(i).getName());
        viewHolder.tvSurname.setText(people.get(i).getSurname());

        if(people.get(i).getPreference().equals("bus")){
            viewHolder.ivPref.setImageResource(R.drawable.bus);
        }
        else
        {
            viewHolder.ivPref.setImageResource(R.drawable.plane);
        }


    }

    @Override
    public int getItemCount() {
        //return the size of the list
        return people.size();
    }
}
