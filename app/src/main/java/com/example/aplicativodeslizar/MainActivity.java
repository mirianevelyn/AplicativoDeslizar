package com.example.aplicativodeslizar;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ContactAdapter contactAdapter;
    private List<Contact> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        contactList = new ArrayList<>();

// Agregar 16 contactos con nuevos nombres y números
        contactList.add(new Contact("EVELIN MIRIAN MAMANI", "977-452-2667", R.drawable.ic_contact_picture2));
        contactList.add(new Contact("Juan Pérez", "987-654-3210", R.drawable.ic_contact_picture1));
        contactList.add(new Contact("Ana Gómez", "987-123-4567", R.drawable.ic_contact_picture2));
        contactList.add(new Contact("Luis Martínez", "956-789-1234", R.drawable.ic_contact_picture1));
        contactList.add(new Contact("María López", "998-765-4321", R.drawable.ic_contact_picture2));
        contactList.add(new Contact("Carlos Sánchez", "951-753-8642", R.drawable.ic_contact_picture1));
        contactList.add(new Contact("Laura Fernández", "952-468-1357", R.drawable.ic_contact_picture2));
        contactList.add(new Contact("Pedro Díaz", "963-852-7410", R.drawable.ic_contact_picture1));
        contactList.add(new Contact("Elena Ruiz", "987-321-6540", R.drawable.ic_contact_picture2));
        contactList.add(new Contact("José Torres", "945-678-9123", R.drawable.ic_contact_picture1));
        contactList.add(new Contact("Patricia Morales", "932-567-8910", R.drawable.ic_contact_picture2));
        contactList.add(new Contact("Andrés Romero", "911-223-3445", R.drawable.ic_contact_picture1));
        contactList.add(new Contact("Gabriela Castro", "944-556-7788", R.drawable.ic_contact_picture2));
        contactList.add(new Contact("Fernando Vargas", "980-123-4567", R.drawable.ic_contact_picture1));
        contactList.add(new Contact("Sara Mendoza", "987-654-3210", R.drawable.ic_contact_picture2));
        contactList.add(new Contact("Javier Jiménez", "912-345-6789", R.drawable.ic_contact_picture1));


        contactAdapter = new ContactAdapter(contactList, this, position -> showDeleteDialog(position));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(contactAdapter);

        // Implementar gestos de deslizar
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                showDeleteDialog(position);
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private void showDeleteDialog(int position) {
        new AlertDialog.Builder(this)
                .setTitle("Eliminar Contacto")
                .setMessage("¿Está seguro que desea eliminar este contacto?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        contactAdapter.removeItem(position);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        contactAdapter.notifyItemChanged(position);
                    }
                })
                .show();
    }
}
