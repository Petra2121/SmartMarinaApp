package com.profico.smartmarina.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.fragment.app.Fragment
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.profico.smartmarina.R
import com.profico.smartmarina.data.Repository
import com.profico.smartmarina.data.model.Dokovi
import kotlinx.android.synthetic.main.fragment_map.*

/**
 * A simple [Fragment] subclass.
 */

class MapFragment : BaseFragment(), GoogleMap.OnMarkerClickListener {

    val args : MapFragmentArgs by navArgs()

    override fun getLayout() = R.layout.fragment_map
    override fun hasToolbar() = false

    lateinit var mapFragment: SupportMapFragment
    var googleMap: GoogleMap? = null

    var listOfDocs: List<Dokovi>? = null

    var lastClickedMarker : Marker? = null

    var lastClickedIndex = 0

    var rez : String = ""

    override fun setupView() {

        mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync {
            googleMap = it

            val location1 = LatLng(43.500341, 16.460560)

            googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(location1, 17f))
            googleMap?.setOnMarkerClickListener(this)

            callAllDocks(args.arrivalDate, args.departureDate, args.shipSize)
            //callAllDocks("2020-11-01", "2020-11-04", "Medium")

            dateOfArrivalDock2.text = args.arrivalDate
            dateOfDepartureDock2.text = args.departureDate
        }

        map_button.setOnClickListener {
            val catchDockID = listOfDocs?.get(lastClickedIndex)?.id2
            if (catchDockID != null) {
                sendReservation(args.passengerNumber, args.arrivalDate, args.departureDate, "5d7a514b5d2c12c7449be040", catchDockID, args.shipId)
            }
        }
    }

    fun callAllDocks(startdate2: String, enddate2: String, boattype2: String) {
        Repository().callAllDocks(startdate2, enddate2, boattype2) {
            listOfDocs = it

            listOfDocs?.forEachIndexed { index, dokovi ->
                val location1 = LatLng(dokovi.lat2.toDouble(), dokovi.long2.toDouble())

                googleMap?.addMarker(MarkerOptions().position(location1).title(dokovi.number2)
                    .icon(bitmapDescriptorFromVector(requireContext(), R.drawable.ic_location_svg)))?.let { marker ->
                    marker.tag = index

                    numberDock.text = dokovi.number2
                    berthType2.text = dokovi.position2
                    priceDock.text = dokovi.price2
                }
            }
        }
    }

    override fun onMarkerClick(marker: Marker?): Boolean {
        val currentIndex = marker?.tag as Int

        listOfDocs?.get(currentIndex)?.apply {
            numberDock.text = number2
            berthType2.text = position2
            priceDock.text = price2
        }

        lastClickedMarker?.let {
            it.setIcon(bitmapDescriptorFromVector(requireContext(), R.drawable.ic_location_svg))
        }

        marker.setIcon(bitmapDescriptorFromVector(requireContext(), R.drawable.ic_location_clicked_svg))

        lastClickedMarker = marker

        lastClickedIndex = currentIndex

        return false
    }

    fun sendReservation (numberofpassengers: Int, dateofarrival: String, dateofdeparture: String, userr:String, dockk:String, boatt:String){
        Repository().sendReservation(numberofpassengers, dateofarrival, dateofdeparture, userr, dockk, boatt) {
            rez = it
            findNavController().navigate(MapFragmentDirections.actionMapFragmentToPaymentFragment(rez, args.arrivalDate, args.departureDate))
        }
    }

    private fun  bitmapDescriptorFromVector(context: Context, vectorResId:Int):BitmapDescriptor {
        val vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable!!.setBounds(0, 0, vectorDrawable.intrinsicWidth, vectorDrawable.intrinsicHeight);
        val bitmap = Bitmap.createBitmap(vectorDrawable.intrinsicWidth, vectorDrawable.intrinsicHeight, Bitmap.Config.ARGB_8888);
        val canvas =  Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

}
