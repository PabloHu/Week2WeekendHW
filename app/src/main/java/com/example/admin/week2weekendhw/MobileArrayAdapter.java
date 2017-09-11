package com.example.admin.week2weekendhw;


        import android.app.Dialog;
        import android.content.Context;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.graphics.Color;
        import android.graphics.drawable.ColorDrawable;
        import android.media.Image;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.ImageButton;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.io.File;
        import java.util.ArrayList;
        import java.util.List;

public class MobileArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;Dialog dialog;
ImageView popupPic;

    private final List<ListViewObject> listViewObjectList;// = new ArrayList<ListViewObject>();
   // ListViewObject listViewObject = new ListViewObject();

//    public MobileArrayAdapter(Context context, String[] values) {
public MobileArrayAdapter(Context context, String[] values, List<ListViewObject> listViewObjectList) {
    super(context, R.layout.activity_list_view_adv, values);
    this.context = context;
    this.values = values;
    this.listViewObjectList = listViewObjectList;
}


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_list_view_adv, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        textView.setText(values[position]);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
        imageView.setImageResource(R.drawable.heart);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), listViewObjectList.get(position).getIcon() +"", Toast.LENGTH_SHORT).show();

                try {
                    File imgFile = new File(listViewObjectList.get(position).getIcon());
                    Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                    popupPic.setImageBitmap(myBitmap);
                }
                catch (Exception e){

                }
            }
        });


        return rowView;
    }




}
