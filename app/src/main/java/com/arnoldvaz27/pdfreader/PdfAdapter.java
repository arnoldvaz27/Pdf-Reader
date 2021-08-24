package com.arnoldvaz27.pdfreader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.io.File;
import java.util.List;


public class PdfAdapter extends RecyclerView.Adapter<PdfViewHolder> {

    private final Context context;
    private final List<File> pdfFiles;
    private final onPdfFileSelectListener onPdfFileSelectListener;

    @NonNull
    @Override
    public PdfViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PdfViewHolder(LayoutInflater.from(context).inflate(R.layout.element_holder, parent, false));
    }

    public PdfAdapter(Context context, List<File> pdfFiles,onPdfFileSelectListener onPdfFileSelectListener) {
        this.context = context;
        this.pdfFiles = pdfFiles;
        this.onPdfFileSelectListener = onPdfFileSelectListener;
    }

    @Override
    public void onBindViewHolder(@NonNull PdfViewHolder holder, int position) {
        holder.tvName.setText(pdfFiles.get(position).getName());
        holder.tvName.setSelected(true);

        holder.container.setOnClickListener(v -> onPdfFileSelectListener.onPdfSelected(pdfFiles.get(position)));
    }

    @Override
    public int getItemCount() {
        return pdfFiles.size();
    }


}
