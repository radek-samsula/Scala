package cz.kinoscala.scala.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import cz.kinoscala.scala.R;

/**
 * Created by Vladimira Hezelova on 29. 5. 2015.
 */
public class ContactsFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    ImageButton ticketReservationCallButton;
    ImageButton boxOfficeCallButton;
    Button ticketReservationPhoneButton;
    Button boxOfficePhoneButton;
    Button generalQuestionsMailButton;
    ImageView map;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contacts, container, false);
        ticketReservationCallButton = (ImageButton) v.findViewById(R.id.ticket_reservation_call_button);
        boxOfficeCallButton = (ImageButton) v.findViewById(R.id.box_office_call_button);
        ticketReservationPhoneButton = (Button) v.findViewById(R.id.ticket_reservation_phone);
        boxOfficePhoneButton = (Button) v.findViewById(R.id.box_office_phone);
        generalQuestionsMailButton = (Button) v.findViewById(R.id.general_questions_mail);
        map = (ImageView) v.findViewById(R.id.mapa);
        addListenerOnButton();
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    public void addListenerOnButton() {

        if (mListener != null) {
            ticketReservationPhoneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    String phoneNumber = "tel:" + "+420 608 330 088";
                    callIntent.setData(Uri.parse(phoneNumber));
                    startActivity(callIntent);
                }
            });
            ticketReservationCallButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    String phoneNumber = "tel:" + "+420 608 330 088";
                    callIntent.setData(Uri.parse(phoneNumber));
                    startActivity(callIntent);
                }
            });

            boxOfficePhoneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    String phoneNumber = "tel:" + "+420 778 448 574";
                    callIntent.setData(Uri.parse(phoneNumber));
                    startActivity(callIntent);
                }
            });

           boxOfficeCallButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    String phoneNumber = "tel:" + "+420 778 448 574";
                    callIntent.setData(Uri.parse(phoneNumber));
                    startActivity(callIntent);
                }
            });

            generalQuestionsMailButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@kinoscala.cz"});
                    startActivity(Intent.createChooser(intent, ""));
                }
            });

            map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/maps/place/Kino+Scala/@49.197483,16.60721,18z/data=!4m2!3m1!1s0x0:0x4025a20cd84b8c08?hl=en-US")));
                }
            });
        }

    }



}
