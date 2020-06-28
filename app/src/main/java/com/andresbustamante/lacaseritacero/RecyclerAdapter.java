package com.andresbustamante.lacaseritacero;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.NumerosViewHolder>{
    ArrayList<Pojo> listaDatos;
    //private int mainNumeroItems;
    private final ListItemClick listItemClick;

    public RecyclerAdapter(ArrayList<Pojo> listaDatos, ListItemClick listItemClick) {
        this.listaDatos = listaDatos;
        this.listItemClick = listItemClick;
    }

    //para poder ponerle clicks a lis elementos
    public interface ListItemClick {
        void onListItemClick(int clickedItem);
    }


    @NonNull
    @Override
    public NumerosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflar la vista de lo que creamos en el 'lista_numeros_raw.xml'
        //rellenar cada elemento del recyclerview con vista

        Context context = parent.getContext();
        int layoutIdParaListItem = R.layout.lista_numeros_raw; //los ID son NUMEROS, nos guardaremos el del layout
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean atachParentRapido = false; //facilitar

        View view = inflater.inflate(layoutIdParaListItem, parent, atachParentRapido);

        //nos pasamos nuestra propia vista de la clase anidada

        NumerosViewHolder viewHolder = new NumerosViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumerosViewHolder holder, int position) {
        //Bindear (bind=comportamiento) a cada vista del ViewHolder con los datos
        holder.textViewListaNumeros.setText(listaDatos.get(position).getText());
        holder.textViewCantidad.setText(listaDatos.get(position).getCantidad());
        holder.imageView.setImageResource(listaDatos.get(position).getImagen());



    }

    @Override
    public int getItemCount() {
        return listaDatos.size(); //devuelve la cantidad de elementos que hay en el RecyclerView / nos llega desde el constructor / no es .length()
    }


    class NumerosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textViewListaNumeros;
        TextView textViewCantidad;
        ImageView imageView;

        public NumerosViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewListaNumeros = itemView.findViewById(R.id.textview_listanumeros);
            textViewCantidad = itemView.findViewById(R.id.cantidad);
            imageView = itemView.findViewById(R.id.imagen);

            itemView.setOnClickListener(this);
        }

        //onBindViewHolder es para que todas las vistas sean iguales, les pasa la misma vista a todos
//        void bind(String dato) {
//            textViewListaNumeros.setText(dato + "\t\t\t\t\t\t\t");
//            //aprender mas sobre linear layout
//
//        }

        @Override
        public void onClick(View v) {
            int clickedItem = getAdapterPosition(); // obtenemos la posicion del click llamado
            listItemClick.onListItemClick(clickedItem);
        }
    }
}
