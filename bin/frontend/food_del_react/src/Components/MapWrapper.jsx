import React from "react";
import { GoogleMap, useJsApiLoader, Marker } from "@react-google-maps/api";

const containerStyle = {
  width: "100%",
  height: "400px"
};

const center = {
  lat: 28.6139, // Default to New Delhi
  lng: 77.209
};

function MapWrapper({ userLocation, restaurantLocation }) {
  const { isLoaded } = useJsApiLoader({
    googleMapsApiKey: "AIzaSyCjOdZGiP1bBSOJkIHwgInqBT9hEQpyw7s", // Replace this
  });

  if (!isLoaded) return <div>Loading map...</div>;

  return (
    <GoogleMap mapContainerStyle={containerStyle} center={userLocation || center} zoom={12}>
      {restaurantLocation && <Marker position={restaurantLocation} />}
      {userLocation && <Marker position={userLocation} label="You" />}
    </GoogleMap>
  );
}

export default React.memo(MapWrapper);
