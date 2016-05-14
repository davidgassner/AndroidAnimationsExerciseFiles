package com.example.david.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;

public class ItemFragment extends Fragment {

    // constants for argument keys
    private static final String PRODUCT_ID = "productId";
    private static final String PRODUCT_NAME = "productName";
    private static final String PRODUCT_DESC = "productDesc";
    private static final String PRODUCT_PRICE = "productPrice";

    public static ItemFragment create(Product product) {

        // package data into a bundle
        Bundle args = new Bundle();
        args.putString(PRODUCT_ID, product.getProductId());
        args.putString(PRODUCT_NAME, product.getName());
        args.putString(PRODUCT_DESC, product.getDescription());
        args.putDouble(PRODUCT_PRICE, product.getPrice());

//      create the fragment and pass the arguments
        ItemFragment fragment = new ItemFragment();
        fragment.setArguments(args);

//      return the fragment
        return fragment;
    }

    //  required no-args constructor
    public ItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//      Inflate the layout
        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.fragment_detail, container, false);

        Bundle args = getArguments();

//      display text and image
        TextView nameText = (TextView) rootView.findViewById(R.id.nameText);
        nameText.setText(args.getString(PRODUCT_NAME));

        TextView descriptionText = (TextView) rootView.findViewById(R.id.descriptionText);
        descriptionText.setText(args.getString(PRODUCT_DESC));

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String price = formatter.format(args.getDouble(PRODUCT_PRICE));
        TextView priceText = (TextView) rootView.findViewById(R.id.priceText);
        priceText.setText(price);

        String productId = args.getString(PRODUCT_ID);
        int imageResource = getActivity().getResources()
                .getIdentifier(productId, "drawable", getActivity().getPackageName());
        ImageView iv = (ImageView) rootView.findViewById(R.id.imageView);
        iv.setImageResource(imageResource);

        return rootView;
    }

}
