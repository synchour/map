import React, { Component } from 'react';
import { connect } from "react-redux";
import uuid from 'uuid';
import { Gmaps, Marker, InfoWindow, Circle } from 'react-gmaps';

class TruckMap extends Component {

    handleClick(e) {
    }

    render() {
        var markers = [];
        if (this.props.externalState.movieLocations) {
            markers = this.props.externalState.movieLocations.map(function (data, index) {
            return (
                <Marker 
                    lat={data.latitude}
                    lng={data.longitude}
                    draggable={true}
                    key={uuid()}
                />
                );
            });
        }

        // SF
        const coords = {
            lat: 37.7749,
            lng: -122.4194
        };
        
        return (
            <Gmaps
                width={'800px'}
                height={'600px'}
                lat={coords.lat}
                lng={coords.lng}
                zoom={12}
                loadingMessage={'Map loading, please wait'}
                params={{ v: '3.exp', key: 'AIzaSyBz-3x-6Wr5EQcnnRYnFjK3ShH4E33AU7Q' }}
                onMapCreated={this.onMapCreated}>
                {markers}
            </Gmaps>
        );
    }
}

const mapStateToProps = function(state) {
  return { externalState: state };
};

const mapDispatchToProps = function(dispatch) {
  return {
    bla: (name) => {
      dispatch({
        type: "FOO",
        payload: "Bar"
      })
    }
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(TruckMap);