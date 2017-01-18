import React from 'react';
import ReactDOM from 'react-dom';
import $ from 'jquery';
import './index.css';
import store from './store';
import { Provider } from "react-redux";
import axios from "axios";
import Map from "./map"
import AutoComplete from "./autocomplete"

var renderAll = function (data) {

  ReactDOM.render(
      <AutoComplete />,
      document.getElementById('search')
    );

	ReactDOM.render(
      <Provider store={store}>
        <Map />
      </Provider>,
      document.getElementById('gmaps')
    );
}


$(document).ready(function () {

	renderAll();

});